package modules.gestionFranquicias.modelEntities;

import modules.gestionFranquicias.dbEntities.Proveedor;

public class ProveedorModel {
    private int idProveedor;
    private String cuit;
    private String razonSocial;
    private String eMail;
    private String telefonoContacto;
    private boolean alta;

    public ProveedorModel(Proveedor p) {
        this.idProveedor = p.getIdProveedor();
        this.cuit = p.getCuit();
        this.razonSocial = p.getRazonSocial();
        this.eMail = p.geteMail();
        this.telefonoContacto = p.getTelefonoContacto();
        this.alta = p.getAlta();
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public Proveedor getDBEntity(){
        Proveedor p = new Proveedor();

        p.setIdProveedor(this.idProveedor);
        p.setCuit(this.cuit);
        p.setRazonSocial(this.razonSocial);
        p.seteMail(this.eMail);
        p.setTelefonoContacto(this.telefonoContacto);
        p.setAlta(this.alta);

        return p;
    }
}
