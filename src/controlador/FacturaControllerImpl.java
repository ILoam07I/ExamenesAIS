
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;

public class FacturaControllerImpl implements FacturaController {
    
    private FacturaModel model;
    private List<FacturaView> views;

    public FacturaControllerImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public FacturaModel getModel() {
        return model;
    }

    @Override
    public void setModel(FacturaModel model) {
        this.model = model;
    }

    @Override
    public void addView(FacturaView view) {
        view.setController(this);
        views.add(view);
    }

    @Override
    public void removeView(FacturaView view) {
        views.remove(view);
    }

    @Override
    public void crearFacturaGesture(String identificador, Cliente cliente, Double importe) {
        Factura factura = new FacturaImpl(identificador, cliente, importe);
        
        model.nuevaFactura(factura);
    }

    @Override
    public void modificarFacturaGesture(String identificador, Cliente cliente, Double importe) {
        Factura factura = new FacturaImpl(identificador, cliente, importe);
        
        model.modificadaFactura(factura);
    }

    @Override
    public void eliminarFacturaGesture(String identificador, Cliente cliente) {
        Factura factura = new FacturaImpl(identificador, cliente);
        
        model.eliminadaFactura(factura);
    }

    @Override
    public List<Factura> listarFacturasGesture() {
        return model.listaFacturas();
    }

    @Override
    public List<Factura> listarFacturasPorClienteGesture(String DNI) {
        return model.listaFacturasPorCliente(DNI);
    }

    @Override
    public void fireDataModelChanged() {
        
        for (FacturaView view : views) {
            view.display();
        }
    }
    
    public void setup(FacturaModel model, List<FacturaView> views) {
        this.model = model;
        model.setController(this);
        addViews(views);
    }
    
    public void addViews(List<FacturaView> views) {
        
        for (FacturaView v : views) {
            addView(v);
        }       
    }
    
}
