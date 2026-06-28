
package modelo;

import controlador.MetodoPagoController;
import java.util.List;
import modelo.entidades.MetodoPago;
import modelo.persistencia.JDBC.MetodoPagoDAOJDBC;
import modelo.persistencia.MetodoPagoDAO;

public class MetodoPagoModelImpl implements MetodoPagoModel {
    
    private MetodoPagoController controller;

    @Override
    public MetodoPagoController getController() {
        return controller;
    }

    @Override
    public void setController(MetodoPagoController controller) {
        this.controller = controller;
    }

    @Override
    public List<MetodoPago> listaMetodos() {
        MetodoPagoDAO dao = obtenerImplementacionMetodoPagoDAO();
        
        return dao.list();
    }

    @Override
    public MetodoPagoDAO obtenerImplementacionMetodoPagoDAO() {
        return new MetodoPagoDAOJDBC();
    }
    
}
