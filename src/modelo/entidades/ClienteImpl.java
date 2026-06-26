
package modelo.entidades;

import java.util.List;

public class ClienteImpl implements Cliente {
    
    public static final int MID_TRESHOLD = 100;
    public static final int VIP_TRESHOLD = 200;
    
    private String DNI;
    private String nombre;
    private String direccion;
    private String tipo;

    public ClienteImpl(String DNI, String nombre, String direccion) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        tipo = "Normal";
    }
    
    public ClienteImpl(String DNI, String nombre, String direccion, String tipo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
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
    public void updateTipoCliente(List<Factura> facturas) {
        double sum = 0.0;
        int i = 0;
        
        for(Factura factura : facturas) {
            sum += factura.getImporte();
            i++;
        }     
        sum = sum / i;
        
        if (sum < MID_TRESHOLD) {
            tipo = "Normal";
            
        } else if (sum > VIP_TRESHOLD) {
            tipo = "Vip";
            
        } else {
            tipo = "Medio";
        }    
    }
    
    @Override
    public String toString() {
        return nombre + " " + DNI;
    }
    
}
