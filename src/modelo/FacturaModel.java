
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.persistencia.FacturaDAO;

public interface FacturaModel {
    
    public FacturaController getController();
    public void setController(FacturaController controller);
    
    public void nuevaFactura(Factura facturaNueva);
    public void modificadaFactura(Factura facturaModificada);
    public void eliminadaFactura(Factura facturaEliminada);
    
    public List<Factura> listaFacturas();
    public List<Factura> listaFacturasPorCliente(String DNI);
    
    public FacturaDAO obtenerImplementacionFacturaDAO();
    
    public void updateAsocClient(Cliente client);
    
}
