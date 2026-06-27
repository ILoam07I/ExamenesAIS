
package modelo.entidades;

import java.util.Date;

public interface Factura {
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    public Date getFechaPago();
    public String getFechaPagoToString();
    public boolean isPendiente();
    
    public void setIdentificador(String identificador);
    public void setCliente(Cliente cliente);
    public void setImporte(Double importe);
    public void setFechaPago(Date fechaPago);
    
}
