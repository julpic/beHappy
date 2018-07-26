package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Sesion;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class SesionModel {
    private long idSesion;
    private long idUsuario;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private List<TurnoModel> turnos;

    public SesionModel(Sesion s) {
        this.idSesion = s.getIdSesion();
        this.idUsuario = s.getIdUsuario();
        this.fechaHoraInicio = s.getFechaHoraInicio();
        if(s.getFechaHoraFin() != null){
            this.fechaHoraFin = s.getFechaHoraFin();
        }
    }

    public long getIdSesion() {
        return idSesion;
    }

    public List<TurnoModel> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<TurnoModel> turnos) {
        this.turnos = turnos;
    }

    public Sesion getDBEntity(){
        Sesion s = new Sesion();

        s.setIdSesion(this.idSesion);
        s.setIdUsuario(this.idUsuario);

        Timestamp timestamp = new Timestamp(this.fechaHoraInicio.getTime());
        s.setFechaHoraInicio(timestamp);

        if (fechaHoraFin != null){
            Timestamp timestamp2 = new Timestamp(this.fechaHoraFin.getTime());
            s.setFechaHoraFin(timestamp2);
        }else{
            s.setFechaHoraFin(null);
        }

        return s;
    }
}
