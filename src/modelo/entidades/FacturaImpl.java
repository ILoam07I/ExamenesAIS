
package modelo.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FacturaImpl implements Factura {
    
    private String identificador;
    private Cliente cliente;
    private Double importe;
    private Date fechaPago;
    
    public FacturaImpl(String identificador, Cliente cliente, Double importe, String fechaPagoStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        this.identificador = identificador;
        this.cliente = cliente;
        this.importe = importe;
        
        try {
            fechaPago = formatter.parse(fechaPagoStr);
            
        } catch (ParseException ex) {
            System.getLogger(FacturaImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public FacturaImpl(String identificador, Cliente cliente, Double importe, Date fechaPago) {
        this.identificador = identificador;
        this.cliente = cliente;
        this.importe = importe;
        this.fechaPago = fechaPago;
    }

    public FacturaImpl(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public Double getImporte() {
        return importe;
    }
    
    @Override
    public Date getFechaPago() {
        return fechaPago;
    }
    
    @Override
    public String getFechaPagoToString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        return formatter.format(fechaPago);
    }
    
    @Override
    public boolean isPendiente() {
        return fechaPago.after(new Date());
    }

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
}
