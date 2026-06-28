
package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import modelo.persistencia.FacturaDAO;

public class FacturaDAOJDBC implements FacturaDAO {

    @Override
    public Factura read(String pk) {
        Factura f = null;
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM facturas WHERE identificador = " + pk);
            String identificador, id_cliente;
            Double importe;
            
            if (res.next()) {
                identificador = res.getString("identificador");
                id_cliente = res.getString("id_cliente");
                importe = res.getDouble("importe");
                Cliente cliente = (new ClienteDAOJDBC()).read(id_cliente);
                f = new FacturaImpl(identificador, cliente, importe);
            }

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
        
        return f;
    }

    @Override
    public void create(Factura factura) {
        String sql = "INSERT INTO facturas(identificador, id_cliente, importe) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, factura.getIdentificador());
            stm.setString(2, factura.getCliente().getDNI());
            stm.setDouble(3, factura.getImporte());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void update(Factura factura) {
        String sql = "UPDATE facturas SET id_cliente = ?, importe = ? WHERE identificador LIKE ?";
        
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(3, factura.getIdentificador());
            stm.setString(1, factura.getCliente().getDNI());
            stm.setDouble(2, factura.getImporte()); 
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void delete(Factura factura) {
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM facturas WHERE identificador = " + factura.getIdentificador());

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public List<Factura> list() {
        List<Factura> facturas = new ArrayList<>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM vfacturas");
            String DNI, nombre, direccion, identificador, metodoPago;
            double importe;
            
            while (res.next()) {
                DNI = res.getString("DNI");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                identificador = res.getString("identificador");
                importe = res.getDouble("importe");
                metodoPago = res.getString("metodo_pago");

                Cliente cliente = new ClienteImpl(DNI, nombre, direccion, metodoPago);

                facturas.add(new FacturaImpl(identificador, cliente, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
        
        return facturas;
    }

    @Override
    public List<Factura> listByMethod(String method) {
        List<Factura> facturas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vfacturas WHERE metodo_pago = ?";
            String dni, nombre, direccion, identificador, metodoPago;
            double importe;

            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, method);

            ResultSet res = stm.executeQuery();
            
            while (res.next()) {
                dni = res.getString("dni");
                nombre = res.getString("nombre");
                direccion = res.getString("direccion");
                identificador = res.getString("identificador");
                importe = res.getDouble("importe");
                metodoPago = res.getString("metodo_pago");

                Cliente cliente = new ClienteImpl(dni, nombre, direccion, metodoPago);

                facturas.add(new FacturaImpl(identificador, cliente, importe));
            }

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            Persistencia.closeConnection();
        }
        
        return facturas;
    }
        
}
