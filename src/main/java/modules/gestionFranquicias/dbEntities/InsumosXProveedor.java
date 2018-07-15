package modules.gestionFranquicias.dbEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "InsumosXProveedor", schema = "BeFruit", catalog = "")
public class InsumosXProveedor implements Serializable {
    public int idProveedor;
    public int idInsumo;

    @Id
    @Column(name = "idProveedor")

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Id
    @Column(name = "idInsumo")

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
}
