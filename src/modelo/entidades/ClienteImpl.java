
package modelo.entidades;

public class ClienteImpl implements Cliente {
    
    private String DNI;
    private String nombre;
    private String direccion;
    private MetodoPago metodoPago;

    public ClienteImpl(String DNI, String nombre, String direccion, MetodoPago metodoPago) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
    }
    
    public ClienteImpl(String DNI, String nombre, String direccion, String metodoPago) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.metodoPago = new MetodoPagoImpl(metodoPago);
    }

    public ClienteImpl(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String getDNI() {
        return DNI;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    @Override
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    @Override
    public String getMetodoPagoToString() {
        
        if (metodoPago == null) {
            return null;
            
        } else {      
            return metodoPago.toString();
        }
    }
    
    @Override
    public String toString() {
        return nombre + " " + DNI;
    }
    
}
