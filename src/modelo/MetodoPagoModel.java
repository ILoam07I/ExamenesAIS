
package modelo;

import controlador.MetodoPagoController;
import java.util.List;
import modelo.entidades.MetodoPago;
import modelo.persistencia.MetodoPagoDAO;

public interface MetodoPagoModel {
    
    public MetodoPagoController getController();
    public void setController(MetodoPagoController controller);
    
    public List<MetodoPago> listaMetodos();
    
    public MetodoPagoDAO obtenerImplementacionMetodoPagoDAO();
    
}
