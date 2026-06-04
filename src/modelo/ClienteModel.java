
package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;

public interface ClienteModel {
    
    public ClienteController getController();
    public void setController(ClienteController controller);
    
    public void nuevoCliente(Cliente clienteNuevo);
    public void modificadoCliente(Cliente clienteModificado);
    public void eliminadoCliente(Cliente clienteEliminado);
    
    public List<Cliente> listaClientes();
    
}
