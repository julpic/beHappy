package modules.gestionUsuarios.controllers;


import modules.gestionUsuarios.dbEntities.Turno;
import modules.gestionUsuarios.ejb.TurnoEJB;
import modules.gestionUsuarios.modelEntities.TurnoModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TurnoController {
    @Inject
    TurnoEJB turnoEJB;

    public TurnoModel find(long id) {
        TurnoModel tm = new TurnoModel(turnoEJB.find(id));
        return tm;

    }
    public List<TurnoModel> findAll() {
        List<Turno> turnos = turnoEJB.findAll();
        ArrayList<TurnoModel> turnosModel = new ArrayList<TurnoModel>();
        for(Turno t : turnos){
            TurnoModel tm = new TurnoModel(t);
            turnosModel.add(tm);
        }
        return turnosModel;
    }
}
