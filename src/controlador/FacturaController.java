
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
    
    public void crearFacturaGesture(String identificador, Cliente cliente, Double importe, String fechaPago);
    public void modificarFacturaGesture(String identificador, Cliente cliente, Double importe, String fechaPago);
    public void eliminarFacturaGesture(String identificador);
    
    public List<Factura> listarFacturasGesture();
    public List<Factura> listarFacturasPorFechaGesture(String fechaFilter);
    
    public void fireDataModelChanged();
    
}
