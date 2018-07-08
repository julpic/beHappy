package entities.gestionProductos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Sabores", schema = "BeFruit", catalog = "")
public class Sabor {
    private int idSabor;
    private String nombe;

    @Id
    @Column(name = "idSabor")
    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }

    @Basic
    @Column(name = "nombe")
    public String getNombe() {
        return nombe;
    }

    public void setNombe(String nombe) {
        this.nombe = nombe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sabor sabor = (Sabor) o;
        return idSabor == sabor.idSabor &&
                Objects.equals(nombe, sabor.nombe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSabor, nombe);
    }
}
