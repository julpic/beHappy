package entities.gestionStock.controllers;

import daos.gestionStockDAO.repositorios.RepositorioStock;
import entities.gestionStock.MovimientoStock;
import entities.gestionStock.UnidadMedida;

import java.util.List;

public class UnidadMedidaController {
    RepositorioStock rs = new RepositorioStock();


    public UnidadMedida find(int id) {
        return rs.buscarUnidadMedida(id);
    }

    public List<UnidadMedida> findAll() {
        return rs.buscarUnidadesMedida();
    }

    public void create(UnidadMedida um) {
        rs.crearUnidadMedida(um);
    }


}
