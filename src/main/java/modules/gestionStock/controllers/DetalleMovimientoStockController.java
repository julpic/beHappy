package modules.gestionStock.controllers;

import modules.gestionStock.ModelEntities.DetalleMovimientoStockModel;
import modules.gestionStock.ModelEntities.InsumoModel;
import modules.gestionStock.ModelEntities.MovimientoStockModel;
import modules.gestionStock.dbEntities.DetalleMovimientoStock;
import modules.gestionStock.dbEntities.MovimientoStock;
import modules.gestionStock.ejb.DetalleMovimientoStockEJB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class DetalleMovimientoStockController {
    @Inject
    DetalleMovimientoStockEJB detalleMovimientoStockEJB;
    @Inject
    InsumoController insumoController;
    @Inject
    MovimientoStockController movimientoStockController;

    public List<DetalleMovimientoStockModel> findAll(long idMovimiento){
        List<DetalleMovimientoStock> detalles= detalleMovimientoStockEJB.findAll(idMovimiento);
        if(!detalles.isEmpty()){
            ArrayList<DetalleMovimientoStockModel> detallesModel = new ArrayList<DetalleMovimientoStockModel>();
            for(DetalleMovimientoStock det: detalles){
                InsumoModel im = insumoController.find(det.getIdInsumo());
                DetalleMovimientoStockModel detModel = new DetalleMovimientoStockModel(det, im);
                detallesModel.add(detModel);
            }
            return detallesModel;
        }else{
            return null;
        }
    }

    public List<DetalleMovimientoStockModel> findAll(){
        List<DetalleMovimientoStock> detalles= detalleMovimientoStockEJB.findAll();
        ArrayList<DetalleMovimientoStockModel> detallesModel = new ArrayList<DetalleMovimientoStockModel>();
        for(DetalleMovimientoStock det: detalles){
            InsumoModel im = insumoController.find(det.getIdInsumo());
            DetalleMovimientoStockModel detModel = new DetalleMovimientoStockModel(det, im);
            detallesModel.add(detModel);
        }
        return detallesModel;
    }


    public void create(List<DetalleMovimientoStockModel> detallesModel, long idMovimiento) {
        long idInsumo;
        int cantidad;

        MovimientoStockModel x = movimientoStockController.find(idMovimiento);
        ArrayList<DetalleMovimientoStock> detalles = new ArrayList<DetalleMovimientoStock>();

        for (DetalleMovimientoStockModel detModel : detallesModel) {
            DetalleMovimientoStock det = detModel.getDBEntity(idMovimiento);
            idInsumo = det.getIdInsumo();
            cantidad = det.getCantidad();
            insumoController.updateStock(idInsumo, cantidad, x.getEntrada());
            detalles.add(det);
        }
        detalleMovimientoStockEJB.createAll(detalles);
    }


    public void restore(DetalleMovimientoStock det, long idMovimiento) {
        /*MovimientoStockModel msm = movimientoStockController.find(idMovimiento);
        MovimientoStock x = msm.getDBEntity();
        long idInsumo = det.getIdInsumo();
        int cantidad = det.getCantidad();
        insumoController.updateStock(idInsumo, cantidad, !(x.isEntrada()));*/
    }

}
