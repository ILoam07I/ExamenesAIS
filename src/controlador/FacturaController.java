
package controlador;

import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import vista.factura.FacturaView;

public interface FacturaController {
    
    public FacturaModel getModel();
    public void setModel(FacturaModel model);
    
    public void addView(FacturaView view);
    public void removeView(FacturaView view);
    
    public void crearFacturaGesture(String identificador, Cliente cliente, Double importe);
    public void modificarFacturaGesture(String identificador, Cliente cliente, Double importe);
    public void eliminarFacturaGesture(String identificador, Cliente cliente);
    
    public List<Factura> listarFacturasGesture();
    public List<Factura> listarFacturasPorClienteGesture(String DNI);
    
    public void fireDataModelChanged();
    
}
