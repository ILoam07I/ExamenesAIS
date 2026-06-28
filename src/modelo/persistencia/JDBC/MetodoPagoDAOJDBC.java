
package modelo.persistencia.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.MetodoPago;
import modelo.entidades.MetodoPagoImpl;
import modelo.persistencia.MetodoPagoDAO;

public class MetodoPagoDAOJDBC implements MetodoPagoDAO {

    @Override
    public List<MetodoPago> list() {
        List<MetodoPago> metodos = new ArrayList<>();
        
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM metodos_pago");

            while (res.next()) {
                metodos.add(new MetodoPagoImpl(res.getString("metodo")));
            }
            res.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        } finally {
            Persistencia.closeConnection();
        }

        return metodos;
    }
    
}
