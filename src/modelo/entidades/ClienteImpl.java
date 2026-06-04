
package modelo.entidades;

public class ClienteImpl implements Cliente {
    
    private String DNI;
    private String nombre;
    private String direccion;

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
    public String toString() {
        return nombre + " " + DNI;
    }
    
}
