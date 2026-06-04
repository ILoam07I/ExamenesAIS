
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;
import modelo.persistencia.FacturaDAO;
import modelo.persistencia.JDBC.FacturaDAOJDBC;

public class FacturaModelImpl implements FacturaModel {
    
    private FacturaController controller;

    @Override
    public FacturaController getController() {
        return controller;
    }

    @Override
    public void setController(FacturaController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevaFactura(Factura facturaNueva) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        
        dao.create(facturaNueva);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void modificadaFactura(Factura facturaModificada) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        
        dao.update(facturaModificada);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void eliminadaFactura(Factura facturaEliminada) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        
        dao.delete(facturaEliminada);
        this.controller.fireDataModelChanged();    
    }

    @Override
    public List<Factura> listaFacturas() {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        
        return dao.list();
    }

    @Override
    public List<Factura> listaFacturasPorCliente(String DNI) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        
        return dao.listByClient(DNI);
    }

    @Override
    public FacturaDAO obtenerImplementacionFacturaDAO() {
        return new FacturaDAOJDBC();
    }
    
}
