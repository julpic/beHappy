package modules.gestionFranquicias.dbEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "InsumosXProveedor", schema = "BeFruit", catalog = "")
public class InsumosXProveedor implements Serializable {
    public long idProveedor;
    public long idInsumo;

    @Id
    @Column(name = "idProveedor")

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Id
    @Column(name = "idInsumo")

    public long getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(long idInsumo) {
        this.idInsumo = idInsumo;
    }
}
