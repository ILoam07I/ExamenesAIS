
package modelo.entidades;

import java.io.Serializable;
import java.util.List;

public interface Cliente extends Serializable {
    
    public String getDNI();
    public String getNombre();
    public String getDireccion();
    public String getTipo();
    
    public void setDNI(String DNI);
    public void setNombre(String nombre);
    public void setDireccion(String direccion);
    public void setTipo(String tipo);
    
    public void updateTipoCliente(List<Factura> facturas);
    
}
