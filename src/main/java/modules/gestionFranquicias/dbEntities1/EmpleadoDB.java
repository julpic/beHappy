package modules.gestionFranquicias.dbEntities1;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "befruit", catalog = "")
@IdClass(EmpleadoPK.class)
public class EmpleadoDB {
    private int idEmpleado;
    private int idFranquicia;
    private String apellido;
    private int dni;
    private String eMail;
    private Timestamp fechaNacimiento;
    private String nombre;
    private int telefonoContacto;
    private byte alta;

    @Id
    @Column(name = "idEmpleado")
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Id
    @Column(name = "idFranquicia")
    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "dni")
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "eMail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "fechaNacimiento")
    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "telefonoContacto")
    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Basic
    @Column(name = "alta")
    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoDB that = (EmpleadoDB) o;
        return idEmpleado == that.idEmpleado &&
                idFranquicia == that.idFranquicia &&
                dni == that.dni &&
                telefonoContacto == that.telefonoContacto &&
                alta == that.alta &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(eMail, that.eMail) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEmpleado, idFranquicia, apellido, dni, eMail, fechaNacimiento, nombre, telefonoContacto, alta);
    }
}
