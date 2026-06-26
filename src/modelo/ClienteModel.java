
package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.persistencia.ClienteDAO;

public interface ClienteModel {
    
    public ClienteController getController();
    public void setController(ClienteController controller);
    
    public void nuevoCliente(Cliente clienteNuevo);
    public void modificadoCliente(Cliente clienteModificado);
    public void eliminadoCliente(Cliente clienteEliminado);
    
    public List<Cliente> listaClientes();
    
    public ClienteDAO obtenerImplementacionClienteDAO();
    
    public void recalculateClientType(Double total, Cliente cliente);
    
}
