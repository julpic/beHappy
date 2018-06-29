package entities.gestionFranquicia;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Empleados", schema = "BeFruit", catalog = "")
@IdClass(EmpleadoPK.class)
public class Empleado {
    private int idEmpleado;
    private int idFranquicia;
    private String apellido;
    private int dni;
    private String eMail;
    private Timestamp fechaNacimiento;
    private String nombre;
    private int telefonoContacto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;

        if (idEmpleado != empleado.idEmpleado) return false;
        if (idFranquicia != empleado.idFranquicia) return false;
        if (dni != empleado.dni) return false;
        if (telefonoContacto != empleado.telefonoContacto) return false;
        if (apellido != null ? !apellido.equals(empleado.apellido) : empleado.apellido != null) return false;
        if (eMail != null ? !eMail.equals(empleado.eMail) : empleado.eMail != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(empleado.fechaNacimiento) : empleado.fechaNacimiento != null)
            return false;
        if (nombre != null ? !nombre.equals(empleado.nombre) : empleado.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpleado;
        result = 31 * result + idFranquicia;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + dni;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + telefonoContacto;
        return result;
    }
}
