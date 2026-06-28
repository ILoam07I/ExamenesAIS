
package vista.cliente;

import controlador.ClienteController;
import controlador.MetodoPagoController;
import vista.metodo_pago.MetodoPagoModel;

public interface ClienteView {
    
    public ClienteController getcController();
    public MetodoPagoController getmController();
    public MetodoPagoModel getComboMetodoPago();
    
    public void setcController(ClienteController cc);
    public void setmController(MetodoPagoController mc);
    
    public void dataModelChanged();
    public void display();
    
}
