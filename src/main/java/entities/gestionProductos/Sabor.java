package entities.gestionProductos;

import javax.persistence.*;

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

        if (idSabor != sabor.idSabor) return false;
        if (nombe != null ? !nombe.equals(sabor.nombe) : sabor.nombe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSabor;
        result = 31 * result + (nombe != null ? nombe.hashCode() : 0);
        return result;
    }
}
