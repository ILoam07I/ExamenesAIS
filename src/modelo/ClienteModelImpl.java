
package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.persistencia.ClienteDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;

public class ClienteModelImpl implements ClienteModel {
    
    private ClienteController controller;

    @Override
    public ClienteController getController() {
        return controller;
    }

    @Override
    public void setController(ClienteController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevoCliente(Cliente clienteNuevo) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        
        dao.create(clienteNuevo);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void modificadoCliente(Cliente clienteModificado) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        
        dao.update(clienteModificado);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void eliminadoCliente(Cliente clienteEliminado) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        
        dao.delete(clienteEliminado);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<Cliente> listaClientes() {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        
        return dao.list();
    }
    
    public ClienteDAO obtenerImplementacionClienteDAO() {
        return new ClienteDAOJDBC();
    }
    
}
