
package modelo.entidades;

import java.io.Serializable;

public interface Cliente extends Serializable {
    
    public String getDNI();
    public String getNombre();
    public String getDireccion();
    public MetodoPago getMetodoPago();
    
    public void setDNI(String DNI);
    public void setNombre(String nombre);
    public void setDireccion(String direccion);
    public void setMetodoPago(MetodoPago metodoPago);
    
    public String getMetodoPagoToString();
    
}
