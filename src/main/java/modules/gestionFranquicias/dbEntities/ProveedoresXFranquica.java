package modules.gestionFranquicias.dbEntities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ProveedoresXFranquica", schema = "BeFruit", catalog = "")
public class ProveedoresXFranquica implements Serializable {
    private int idProveedor;
    private int idFranquicia;

    @Id
    @Column(name = "idProveedor")
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Id
    @Column(name = "idFranquicia")
    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

}
