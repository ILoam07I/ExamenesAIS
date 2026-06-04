
package vista.factura;

import controlador.FacturaController;

public interface FacturaView {
    
    public FacturaController getController();
    
    public void setController(FacturaController controller);
    
    public void dataModelChanged();
    public void display();
    
}
