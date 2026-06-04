
package vista.cliente;

import controlador.ClienteController;

public interface ClienteView {
    
    public ClienteController getController();
    
    public void setController(ClienteController cc);
    
    public void dataModelChanged();
    public void display();
    
}
