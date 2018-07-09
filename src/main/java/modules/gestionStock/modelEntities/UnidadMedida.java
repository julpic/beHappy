package modules.gestionStock.modelEntities;


import java.util.Objects;


public class UnidadMedida {
    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadMedida that = (UnidadMedida) o;
        return Objects.equals(nombre, that.nombre);
    }


}
