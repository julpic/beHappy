package modules.gestionFranquicias.controllers;

import modules.gestionFranquicias.dbEntities.Proveedor;
import modules.gestionFranquicias.ejb.ProveedorEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@Stateless
public class ProveedorController {
    @Inject
    ProveedorEJB proveedorEJB;

    public Proveedor find(int id) {
        return proveedorEJB.find(id);
    }

    public List<Proveedor> findAll() {
        return proveedorEJB.findAll();
    }

    public boolean create(Proveedor e) {
        if (validarCuit(e.getCuit())) {
            e.setAlta(true);
            proveedorEJB.create(e);
            return true;
        }
        return false;
    }

    public boolean update(int id, Proveedor e) {
        if (validarCuit(e.getCuit())) {
            proveedorEJB.update(id, e);
            return true;
        }
        return false;
    }

    public void remove(int id) {
        proveedorEJB.remove(id);
    }

    //sacado de wikipedia
    private boolean validarCuit(String cuit) {
        //Eliminamos todos los caracteres que no son números
        cuit = cuit.replaceAll("[^\\d]", "");
        //Controlamos si son 11 números los que quedaron, si no es el caso, ya devuelve falso
        if (cuit.length() != 11) {
            return false;
        }
        //Convertimos la cadena que quedó en una matriz de caracteres
        char[] cuitArray = cuit.toCharArray();
        //Inicializamos una matriz por la cual se multiplicarán cada uno de los dígitos
        Integer[] serie = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        //Creamos una variable auxiliar donde guardaremos los resultados del cálculo del número validador
        Integer aux = 0;
        //Recorremos las matrices de forma simultanea, sumando los productos de la serie por el número en la misma posición
        for (int i = 0; i < 10; i++) {
            aux += Character.getNumericValue(cuitArray[i]) * serie[i];
        }
        //Hacemos como se especifica: 11 menos el resto de de la división de la suma de productos anterior por 11
        aux = 11 - (aux % 11);
        //Si el resultado anterior es 11 el código es 0
        if (aux == 11) {
            aux = 0;
        }
        //Si el resultado anterior es 10 el código no tiene que validar, cosa que de todas formas pasa
        //en la siguiente comparación.
        //Devuelve verdadero si son iguales, falso si no lo son
        //(Esta forma esta dada para prevenir errores, en java 6 se puede usar: return aux.equals(Character.getNumericValue(cuitArray[10]));)
        return Objects.equals(Character.getNumericValue(cuitArray[10]), aux);
    }
}
