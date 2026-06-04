
package modelo.entidades;

public interface Factura {
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    
    public void setIdentificador(String identificador);
    public void setCliente(Cliente cliente);
    public void setImporte(Double importe);
    
}
