package modules.gestionFranquicias.dbEntities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ProveedoresXFranquica", schema = "BeFruit", catalog = "")
public class ProveedoresXFranquica implements Serializable {
    private long idProveedor;
    private long idFranquicia;

    @Id
    @Column(name = "idProveedor")
    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Id
    @Column(name = "idFranquicia")
    public long getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(long idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

}
