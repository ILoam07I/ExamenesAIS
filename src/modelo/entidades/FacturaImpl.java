
package modelo.entidades;

public class FacturaImpl implements Factura {
    
    private String identificador;
    private Cliente cliente;
    private Double importe;

    public FacturaImpl(String identificador, Cliente cliente, Double importe) {
        this.identificador = identificador;
        this.cliente = cliente;
        this.importe = importe;
    }

    public FacturaImpl(String identificador, Cliente cliente) {
        this.identificador = identificador;
        this.cliente = cliente;
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
    
}
