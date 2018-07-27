package modules.gestionUsuarios.controllers;

import modules.gestionUsuarios.dbEntities.Sesion;
import modules.gestionUsuarios.ejb.SesionEJB;
import modules.gestionUsuarios.modelEntities.SesionModel;
import modules.gestionUsuarios.modelEntities.TurnoModel;
import modules.gestionUsuarios.modelEntities.UsuarioModel;
import utilities.AuthParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class SesionController {
    @Inject
    SesionEJB sesionEJB;
    @Inject
    AuthParser authParser;
    @Inject
    UsuarioController usuarioController;
    @Inject
    TurnoController turnoController;

    public SesionModel find(long id) {
        SesionModel sm = new SesionModel(sesionEJB.find(id));
        List<TurnoModel> turnos = turnoController.findAll(id);
        if(turnos != turnos){
            sm.setTurnos(turnos);
        }
        return sm;
    }

    public List<SesionModel> findAll() {
        List<Sesion> sesiones = sesionEJB.findAll();
        ArrayList<SesionModel> sesionesModel = new ArrayList<SesionModel>();
        for(Sesion s : sesiones){
            SesionModel sm = new SesionModel(s);
            List<TurnoModel> turnos = turnoController.findAll(s.getIdSesion());
            if(turnos != turnos){
                sm.setTurnos(turnos);
            }
            sesionesModel.add(sm);
        }
        return sesionesModel;
    }

    public SesionModel sesionActual(){
        SesionModel sm = new SesionModel(sesionEJB.sesionIniciada());
        List<TurnoModel> turnos = turnoController.findAll(sm.getIdSesion());
        if(turnos != turnos){
            sm.setTurnos(turnos);
        }
        return sm;
    }

    public boolean haySesionIniciada() {
        Sesion tempSesion = sesionEJB.sesionIniciada();
        return tempSesion != null;
    }

    public long create(HttpHeaders header) {
        String[] loginInfo = authParser.
                parse(header.getRequestHeader("Authorization").get(0));
        if (usuarioController.inicioSesionValido(loginInfo[0], loginInfo[1])) {
            if (haySesionIniciada()) {
                return -1;
            } else {
                create(loginInfo[0]);
                return 1;
            }
        } return 0;
    }

    private void create(String s) {
        UsuarioModel u = usuarioController.find(s);
        Sesion temp = new Sesion();
        temp.setIdUsuario(u.getDBEntity().getIdUsuario());
        temp.setIdSesion(sesionEJB.buscarNuevoID());
        temp.setFechaHoraInicio(new Timestamp(System.currentTimeMillis()));
        sesionEJB.create(temp);
    }

    public boolean remove() {
        if (haySesionIniciada() && !(turnoController.hayTurnoIniciado())) {
            sesionEJB.cancel();
            return true;
        }
        return false;
    }
}
