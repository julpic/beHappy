package utilities;

import modules.gestionFranquicias.ejb.FranquiciaEJB;

public class GeneradorID {

    public static int buscarID(int ultimoID){
        //Busco el id de la franquicia
        FranquiciaEJB franquiciaEJB = new FranquiciaEJB();
        Integer idFranquicia = franquiciaEJB.findIDFranquicia();
        if (idFranquicia == null){
            return -1;
        }
        int idObjeto;

        if (ultimoID != 0){
            idObjeto = idObjeto(ultimoID, idFranquicia);
        }else{
            idObjeto = 1;
        }

        //Se forma el id que ira a la bd con el formato necesario
        String idObjetoNuevo = Integer.toString(idFranquicia) + "00" + Integer.toString(idObjeto);
        //Se retorna el valor numerico
        return Integer.parseInt(idObjetoNuevo);
    }

    public static int buscarID(int ultimoID, int idFranquicia){
        int idObjeto;

        if (ultimoID != 0){
            idObjeto = idObjeto(ultimoID, idFranquicia);
        }else{
            idObjeto = 1;
        }

        //Se forma el id que ira a la bd con el formato necesario
        String idObjetoNuevo = Integer.toString(idFranquicia) + "00" + Integer.toString(idObjeto);
        //Se retorna el valor numerico
        return Integer.parseInt(idObjetoNuevo);
    }

    private static int idObjeto(int ultimoID, int idFranquicia){
        //Se convierte el id que se paso a un array de char
        String idUltimo = Integer.toString(ultimoID);
        char[] idArray = idUltimo.toCharArray();

        //Declaracion de una variable que ayuda a ver cuando empieza el id del insumo en el
        //ultimo id (Que se compone de idFranquicia + 00 + idObjeto)
        int digitosFranquicia = String.valueOf(idFranquicia).length();
        int digitosExtra = digitosFranquicia + 2; //El 2se refiere a los 2 ceros siguientes al id de franquicia
        String idObjetoString = "";

        for (int i = 0; i < idArray.length; i++){
            if(i >= digitosExtra){
                idObjetoString += idArray[i];
            }
        }
        //Nuevo id para el objeto
        int idObjetoViejo = Integer.parseInt(idObjetoString);
        int idObjetoNuevo = idObjetoViejo + 1;
        return idObjetoNuevo;
    }

}
