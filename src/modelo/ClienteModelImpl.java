
package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.persistencia.ClienteDAO;
import modelo.persistencia.FacturaDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;
import modelo.persistencia.JDBC.FacturaDAOJDBC;

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
        ClienteDAO cDao = obtenerImplementacionClienteDAO();
        FacturaDAO fDao = obtenerImplementacionFacturaDAO();
        List<Cliente> clientes = cDao.list();
        
        for (Cliente cliente : clientes) {
            cliente.updateTipoCliente(fDao.listByClient(cliente.getDNI()));
        }
        
        return clientes;
    }
    
    public ClienteDAO obtenerImplementacionClienteDAO() {
        return new ClienteDAOJDBC();
    }
    
    public FacturaDAO obtenerImplementacionFacturaDAO() {
        return new FacturaDAOJDBC();
    }
    
}
