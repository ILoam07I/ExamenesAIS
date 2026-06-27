
package vista.factura;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Factura;

public class FacturaTableModel implements TableModel {
    
    private List<Factura> facturas = new ArrayList<>();
    private List<TableModelListener> tableListeners = new ArrayList<>();

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = new ArrayList<>(facturas);
        fireContentsChangedForTableModel();
    }
    
    
    //------Métodos propios de TableModel------
    
    public Factura getFactura(int index) {
        return facturas.get(index);
    }

    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombre;
        
        switch (columnIndex) {
            
            case 0:
                nombre = "Identificador";
                break;
                
            case 1:
                nombre = "Cliente";
                break;
            
            case 2:
                nombre = "Importe";
                break;
                
            case 3:
                nombre = "Pendiente de Pago";
                break;
                
            default:
                nombre = null;
                break;
        }
        
        return nombre;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class c;
        
        switch (columnIndex) {
            
            case 2:
                c = Double.class;
                break;
                
            case 3:
                c = Boolean.class;
                break;
                
            default:
                c = String.class;
                break;
        }
        
        return c;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura facturaSelected = facturas.get(rowIndex);
        Object val;
        
        switch (columnIndex) {
            
            case 0:
                val = (String) facturaSelected.getIdentificador();
                break;
                
            case 1:
                val = (String) facturaSelected.getCliente().getDNI();
                break;
            
            case 2:
                val = (Double) facturaSelected.getImporte();
                break;
                
            case 3:
                val = (Boolean) facturaSelected.isPendiente();
                break;
                
            default:
                val = null;
                break;
        }
        
        return val;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }
    
    public void fireContentsChangedForTableModel() {
        TableModelEvent event = new TableModelEvent(this, 0, (this.getRowCount() - 1), TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        } 
    }
    
}
