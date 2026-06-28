
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.MetodoPagoModel;
import modelo.entidades.MetodoPago;
import vista.cliente.ClienteView;


public class MetodoPagoControllerImpl implements MetodoPagoController {
    
    private MetodoPagoModel model;
    private List<ClienteView> views;

    public MetodoPagoControllerImpl() {
        views = new ArrayList<>();
    }

    @Override
    public MetodoPagoModel getModel() {
        return model;
    }

    @Override
    public void setModel(MetodoPagoModel model) {
        this.model = model;
    }

    @Override
    public void addView(ClienteView view) {
        views.add(view);
    }

    @Override
    public void removeView(ClienteView view) {
        views.remove(view);
    }

    @Override
    public List<MetodoPago> listarMetodosGesture() {
        return model.listaMetodos();
    }

    @Override
    public void fireDataModelChanged() {
        for (ClienteView view : views) {
            view.display();
        }
    }
    
    public void setup(MetodoPagoModel model, List<ClienteView> views) {
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
