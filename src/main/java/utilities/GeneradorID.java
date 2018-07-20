package utilities;

import modules.gestionFranquicias.ejb.FranquiciaEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GeneradorID {
    @Inject FranquiciaEJB franquiciaEJB;

    public long buscarID(long ultimoID){
        //Busco el id de la franquicia
        Long idFranquicia = franquiciaEJB.findIDFranquicia();
        if (idFranquicia == null || idFranquicia == 0){
            return -1;
        }
        long idObjeto;

        if (ultimoID != 0){
            idObjeto = idObjeto(ultimoID, idFranquicia);
        }else{
            idObjeto = 1;
        }

        //Se forma el id que ira a la bd con el formato necesario
        String idObjetoNuevo = Long.toString(idFranquicia) + "00" + Long.toString(idObjeto);
        //Se retorna el valor numerico
        return Long.parseLong(idObjetoNuevo);
    }

    public long buscarID(long ultimoID, Long idFranquicia){
        long idObjeto;

        if (idFranquicia == null || idFranquicia == 0){
            return -1;
        }

        if (ultimoID != 0){
            idObjeto = idObjeto(ultimoID, idFranquicia);
        }else{
            idObjeto = 1;
        }

        //Se forma el id que ira a la bd con el formato necesario
        String idObjetoNuevo = Long.toString(idFranquicia) + "00" + Long.toString(idObjeto);
        //Se retorna el valor numerico
        return Long.parseLong(idObjetoNuevo);
    }

    private long idObjeto(long ultimoID, Long idFranquicia){
        //Se convierte el id que se paso a un array de char
        String idUltimo = Long.toString(ultimoID);
        char[] idArray = idUltimo.toCharArray();

        //Declaracion de una variable que ayuda a ver cuando empieza el id del insumo en el
        //ultimo id (Que se compone de idFranquicia + 00 + idObjeto)
        long digitosFranquicia = String.valueOf(idFranquicia).length();
        long digitosExtra = digitosFranquicia + 2; //El 2se refiere a los 2 ceros siguientes al id de franquicia
        String idObjetoString = "";

        for (int i = 0; i < idArray.length; i++){
            if(i >= digitosExtra){
                idObjetoString += idArray[i];
            }
        }
        //Nuevo id para el objeto
        long idObjetoViejo = Long.parseLong(idObjetoString);
        long idObjetoNuevo = idObjetoViejo + 1;
        return idObjetoNuevo;
    }

}
