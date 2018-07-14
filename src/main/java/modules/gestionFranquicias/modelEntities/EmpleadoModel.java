package modules.gestionFranquicias.modelEntities;

import modules.gestionFranquicias.dbEntities.Empleado;

import java.sql.Timestamp;
import java.util.Date;

public class EmpleadoModel {
    private int idEmpleado;
    private int idFranquicia;
    private String apellido;
    private long dni;
    private String eMail;
    private Date fechaNacimiento;
    private String nombre;
    private long telefonoContacto;
    private boolean alta;

    public EmpleadoModel(Empleado e) {
        this.idEmpleado = e.getIdEmpleado();
        this.idFranquicia = e.getIdFranquicia();
        this.apellido = e.getApellido();
        this.dni = e.getDni();
        this.eMail = e.geteMail();
        Date date = new Date(e.getFechaNacimiento().getTime());
        this.fechaNacimiento = date;
        this.nombre = e.getNombre();
        this.telefonoContacto = e.getTelefonoContacto();
        this.alta = e.getAlta();
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public Empleado getDBEntity(){
        Empleado e = new Empleado();

        e.setIdEmpleado(this.idEmpleado);
        e.setIdFranquicia(this.idFranquicia);
        e.setApellido(this.apellido);
        e.setDni(this.dni);
        e.seteMail(this.eMail);
        Timestamp timestamp = new Timestamp(this.fechaNacimiento.getTime());
        e.setFechaNacimiento(timestamp);
        e.setNombre(this.nombre);
        e.setTelefonoContacto(this.telefonoContacto);
        e.setAlta(this.alta);

        return e;
    }
}
