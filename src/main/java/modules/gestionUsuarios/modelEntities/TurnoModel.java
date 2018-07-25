package modules.gestionUsuarios.modelEntities;

import modules.gestionUsuarios.dbEntities.Turno;

import java.sql.Timestamp;
import java.util.Date;

public class TurnoModel {
    private long idTurno;
    private long idSesion;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;

    public TurnoModel(Turno t) {
        this.idTurno = t.getIdTurno();
        this.idSesion = t.getIdSesion();
        this.fechaHoraInicio = t.getFechaHoraInicio();
        if(t.getFechaHoraFin() != null){
            this.fechaHoraFin = t.getFechaHoraFin();
        }
    }

    public Turno getDBEntity(){
        Turno t = new Turno();

        t.setIdTurno(this.idTurno);
        t.setIdSesion(this.idSesion);

        Timestamp timestamp = new Timestamp(this.fechaHoraInicio.getTime());
        t.setFechaHoraInicio(timestamp);

        if (fechaHoraFin != null){
            Timestamp timestamp2 = new Timestamp(this.fechaHoraFin.getTime());
            t.setFechaHoraFin(timestamp2);
        }else{
            t.setFechaHoraFin(null);
        }

        return t;
    }
}
