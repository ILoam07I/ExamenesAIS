
package vista.factura;

import controlador.FacturaController;
import controlador.MetodoPagoController;

public interface FacturaView {
    
    public FacturaController getfController();
    public MetodoPagoController getmController();
    
    public void setfController(FacturaController fController);
    public void setmController(MetodoPagoController mController);
    
    public void dataModelChanged();
    public void display();
    
}
