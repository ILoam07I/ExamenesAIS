
package controlador;

import java.util.List;
import modelo.MetodoPagoModel;
import modelo.entidades.MetodoPago;
import vista.cliente.ClienteView;

public interface MetodoPagoController {
    
    public MetodoPagoModel getModel();
    public void setModel(MetodoPagoModel model);
    
    public void addView(ClienteView view);
    public void removeView(ClienteView view);
    
    public List<MetodoPago> listarMetodosGesture();
    
    public void fireDataModelChanged();
    
}
