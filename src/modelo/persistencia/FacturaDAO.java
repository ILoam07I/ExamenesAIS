
package modelo.persistencia;

import java.util.List;
import modelo.entidades.Factura;

public interface FacturaDAO {
    
    public Factura read(String pk);
    public void create(Factura factura);
    public void update(Factura factura);
    public void delete(Factura factura);
    public List <Factura> list();
    public List<Factura> listByClient(String DNI);
    
}
