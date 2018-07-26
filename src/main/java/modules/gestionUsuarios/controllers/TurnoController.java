package modules.gestionUsuarios.controllers;


import modules.gestionUsuarios.dbEntities.Turno;
import modules.gestionUsuarios.ejb.TurnoEJB;
import modules.gestionUsuarios.modelEntities.TurnoModel;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TurnoController {
    @Inject
    TurnoEJB turnoEJB;
    @Inject
    SesionController sesionController;

    public TurnoModel find(long id) {
        TurnoModel tm = new TurnoModel(turnoEJB.find(id));
        return tm;

    }

    public List<TurnoModel> findAll() {
        List<Turno> turnos = turnoEJB.findAll();
        ArrayList<TurnoModel> turnosModel = new ArrayList<TurnoModel>();
        for (Turno t : turnos) {
            TurnoModel tm = new TurnoModel(t);
            turnosModel.add(tm);
        }
        return turnosModel;
    }

    public List<TurnoModel> findAll(long idSesion) {
        List<Turno> turnos = turnoEJB.findAll(idSesion);
        ArrayList<TurnoModel> turnosModel = new ArrayList<TurnoModel>();
        for (Turno t : turnos) {
            TurnoModel tm = new TurnoModel(t);
            turnosModel.add(tm);
        }
        return turnosModel;
    }

    public long create() {
        if (!(sesionController.haySesionIniciada()) || turnoEJB.hayTurnoIniciado()) {
            return -1;
        } else {
            Turno t = new Turno();
            t.setIdTurno(turnoEJB.buscarNuevoID());
            t.setIdSesion(sesionController.sesionActual().getIdSesion());
            t.setFechaHoraInicio(new Timestamp(System.currentTimeMillis()));
            turnoEJB.create(t);
            return t.getIdTurno();
        }
    }

    public boolean hayTurnoIniciado(){
        Turno tempTurno = turnoEJB.turnoIniciado();
        return tempTurno != null;
    }

    public boolean remove() {
        if (turnoEJB.hayTurnoIniciado()) {
            turnoEJB.cancel();
            return true;
        }
        return false;
    }
}


