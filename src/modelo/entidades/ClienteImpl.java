
package modelo.entidades;

public class ClienteImpl implements Cliente {
    
    public static final Double MID_TRESHOLD = 100.0;
    public static final Double VIP_TRESHOLD = 200.0;
    
    private String DNI;
    private String nombre;
    private String direccion;
    private String tipo;

    public ClienteImpl(String DNI, String nombre, String direccion, String tipo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public ClienteImpl(String DNI, String nombre, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
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
    public String getTipo() {
        return tipo;
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
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void recalculateType(Double total) {
        
        if (total >= VIP_TRESHOLD) {
            tipo = "Vip";
            
        } else if (total <= MID_TRESHOLD) {
            tipo = "Normal";
            
        } else {
            tipo = "Medio";
        }
    }
    
    @Override
    public String toString() {
        return nombre + " " + DNI;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj != null) {
            Cliente other = (ClienteImpl) obj;

            return DNI.equals(other.getDNI());          
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return DNI.hashCode();
    }
    
}
