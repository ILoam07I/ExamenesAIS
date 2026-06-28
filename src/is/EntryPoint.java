
package is;

import controlador.ClienteControllerImpl;
import controlador.FacturaControllerImpl;
import controlador.MetodoPagoController;
import controlador.MetodoPagoControllerImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import modelo.ClienteModel;
import modelo.ClienteModelImpl;
import modelo.FacturaModel;
import modelo.FacturaModelImpl;
import modelo.MetodoPagoModel;
import modelo.MetodoPagoModelImpl;
import vista.VistaGlobal;
import vista.cliente.ClienteView;
import vista.cliente.ClienteViewImpl;
import vista.factura.FacturaView;
import vista.factura.FacturaViewImpl;

public class EntryPoint {

    public static void main(String[] args) {
        ClienteModel clienteModel = new ClienteModelImpl();
        List<ClienteView> clienteViews = new ArrayList<>();
        FacturaModel facturaModel = new FacturaModelImpl();
        List<FacturaView> facturaViews = new ArrayList<>();
        MetodoPagoModel metodoPagoModel = new MetodoPagoModelImpl();
        
        ClienteView clienteView = new ClienteViewImpl();
        clienteViews.add(clienteView);
        ClienteControllerImpl clienteController = new ClienteControllerImpl();
        clienteController.setup(clienteModel, clienteViews);
        
        MetodoPagoControllerImpl metodoPagoController = new MetodoPagoControllerImpl();
        metodoPagoController.setup(metodoPagoModel, clienteViews);
        clienteView.setmController(metodoPagoController);
        
        FacturaView facturaView = new FacturaViewImpl();
        facturaViews.add(facturaView);
        FacturaControllerImpl facturaController = new FacturaControllerImpl();
        facturaController.setup(facturaModel, facturaViews);
        
        facturaView.setmController(metodoPagoController);
        
        VistaGlobal vista = new VistaGlobal(clienteView, facturaView);
        JFrame frame = new JFrame("MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(vista);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        clienteView.dataModelChanged();
        facturaView.dataModelChanged();
    }
    
}
