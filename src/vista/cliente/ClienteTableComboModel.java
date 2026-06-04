
package vista.cliente;

import java.util.List;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Cliente;

public class ClienteTableComboModel implements TableModel, ComboBoxModel {
    
    private static ClienteTableComboModel instance = null;
    
    private List<Cliente> clientes;
    private List<TableModelListener> tableListeners;
    private List<ListDataListener> dataListeners;
    private Cliente clienteSelected;
    
    private ClienteTableComboModel() {
        clientes = new ArrayList<>();
        tableListeners = new ArrayList<>();
        dataListeners = new ArrayList<>();
        clienteSelected = null;
    }
    
    public static ClienteTableComboModel getInstance() {
        
        if (instance == null) {
            instance = new ClienteTableComboModel();         
        }
        
        return instance;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = new ArrayList<>(clientes);
        fireContentsChanged();
    }
    
    protected void fireContentsChanged() {
        fireContentsChangedForTableModel();
        fireContentsChangedForDataList();
    }

    
    //------Métodos propios de TableModel-------
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String columnName;
        
        switch (columnIndex) {
            
            case 0:
                columnName = "DNI";
                break;
                
            case 1:
                columnName = "Nombre";
                break;
                
            case 2:
                columnName = "Direccion";
                break;
            
            default:
                columnName = null;
        }
        
        return columnName;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente clienteSelected = clientes.get(rowIndex);
        String val;
        
        switch (columnIndex) {
            case 0:
                val = clienteSelected.getDNI();
                break;
                
            case 1:
                val = clienteSelected.getNombre();
                break;
                
            case 2:
                val = clienteSelected.getDireccion();
                break;
            
            default:
                val = null;
        }
        
        return val;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        TableModelEvent event = new TableModelEvent(this, 0, (clientes.size() - 1),TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    
    //------Métodos propios de ComboBoxModel-------
    
    public Cliente getCliente(int index) {
        return clientes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if (anItem != null) {
            clienteSelected = (Cliente) anItem;
            fireContentsChangedForDataList();
        }
    }

    @Override
    public Object getSelectedItem() {
        return clienteSelected;
    }

    @Override
    public int getSize() {
        return clientes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return clientes.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
    
    public void fireContentsChangedForDataList() {
        ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, clientes.size());
        
        for (ListDataListener listener : dataListeners) {
            listener.contentsChanged(event);
        }
    }
    
}
