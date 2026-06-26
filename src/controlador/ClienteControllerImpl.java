
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import vista.cliente.ClienteView;

public class ClienteControllerImpl implements ClienteController {
    
    private ClienteModel model;
    private List<ClienteView> views;

    public ClienteControllerImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public ClienteModel getModel() {
        return model;
    }

    @Override
    public void setModel(ClienteModel model) {
        this.model = model;
    }

    @Override
    public void addView(ClienteView view) {
        view.setController(this);
        views.add(view);
    }

    @Override
    public void removeView(ClienteView view) {
        views.remove(view);
    }

    @Override
    public void crearClienteGesture(String DNI, String nombre, String direccion) {
        Cliente cliente = new ClienteImpl(DNI, nombre, direccion, "Normal");
        model.nuevoCliente(cliente);
    }

    @Override
    public void modificarClienteGesture(String DNI, String nombre, String direccion, String tipo) {
        Cliente cliente = new ClienteImpl(DNI, nombre, direccion, tipo);
        model.modificadoCliente(cliente);
    }

    @Override
    public void eliminarClienteGesture(String DNI) {
        Cliente cliente = new ClienteImpl(DNI);
        model.eliminadoCliente(cliente);
    }

    @Override
    public List<Cliente> listarClientesGesture() {
        return model.listaClientes();
    }

    @Override
    public void fireDataModelChanged() {
        for (ClienteView view : views) {
            view.display();
        }
    }
    
    public void setup(ClienteModel model, List<ClienteView> views) {
        this.model = model;
        model.setController(this);
        addViews(views);
    }
    
    public void addViews(List<ClienteView> views) {
        for (ClienteView v : views) {
            addView(v);
        }
    }

}
