
package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.persistencia.ClienteDAO;

public class ClienteDAOJDBC implements ClienteDAO {

    @Override
    public Cliente read(String pk) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE nombre = " + pk;
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            c = new ClienteImpl(res.getString("dni"), res.getString("nombre"), res.getString("direccion"), res.getString("tipo"));
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
            
        } finally {
            Persistencia.closeConnection();
        }
        
        return c;
    }

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO clientes(dni, nombre, direccion, tipo) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getDNI());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getDireccion());
            pstmt.setString(4, cliente.getTipo());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, direccion = ? WHERE dni LIKE ?";
        
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getDireccion());
            pstmt.setString(3, cliente.getDNI());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void delete(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE dni = ?";
        
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, cliente.getDNI());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public List<Cliente> list() {
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM clientes");

            while (res.next()) {
                Cliente cliente = new ClienteImpl(res.getString("dni"), res.getString("nombre"), res.getString("direccion"), res.getString("tipo"));
                clientes.add(cliente);
            }
            res.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        } finally {
            Persistencia.closeConnection();
        }

        return clientes;
    }
    
}
