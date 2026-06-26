
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Cliente;
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
        Cliente clienteAsoc = facturaNueva.getCliente();
        
        dao.create(facturaNueva);
        clienteAsoc.updateTipoCliente(dao.listByClient(clienteAsoc.getDNI()));
        this.controller.fireDataModelChanged();
    }

    @Override
    public void modificadaFactura(Factura facturaModificada) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        Cliente clienteAsoc = facturaModificada.getCliente();
        
        dao.update(facturaModificada);
        clienteAsoc.updateTipoCliente(dao.listByClient(clienteAsoc.getDNI()));
        this.controller.fireDataModelChanged();
    }

    @Override
    public void eliminadaFactura(Factura facturaEliminada) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        Cliente clienteAsoc = facturaEliminada.getCliente();
        
        dao.delete(facturaEliminada);
        clienteAsoc.updateTipoCliente(dao.listByClient(clienteAsoc.getDNI()));
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
