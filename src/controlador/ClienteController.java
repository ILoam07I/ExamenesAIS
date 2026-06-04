
package controlador;

import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import vista.cliente.ClienteView;

public interface ClienteController {
    
    public ClienteModel getModel();
    public void setModel(ClienteModel model);
    
    public void addView(ClienteView view);
    public void removeView(ClienteView view);
    
    public void crearClienteGesture(String DNI, String nombre, String direccion);
    public void modificarClienteGesture(String DNI, String nombre, String direccion);
    public void eliminarClienteGesture(String DNI);
    
    public List<Cliente> listarClientesGesture();
    
    public void fireDataModelChanged();
    
}
