
package vista.metodo_pago;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import modelo.entidades.MetodoPago;

public class MetodoPagoModel implements ComboBoxModel {
    
    private List<MetodoPago> metodos;
    private List<ListDataListener> dataListeners;
    private MetodoPago metodoSelected;
    
    public MetodoPagoModel() {
        metodos = new ArrayList<>();
        dataListeners = new ArrayList<>();
        metodoSelected = null;
    }
    
    @Override
    public Object getSelectedItem() {
        return metodoSelected;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if (anItem == null) {
            metodoSelected = null;
            
        } else {
            metodoSelected = (MetodoPago) anItem;
        }
        
        fireContentsChangedForDataList();
    }

    @Override
    public int getSize() {
        return metodos.size();
    }

    @Override
    public MetodoPago getElementAt(int index) {
        return metodos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
    
    public void setMetodos(List<MetodoPago> metodos) {
        this.metodos = metodos;
        
        fireContentsChangedForDataList();
    }

    public void fireContentsChangedForDataList() {
        ListDataEvent event = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, metodos.size());
        
        for (ListDataListener listener : dataListeners) {
            listener.contentsChanged(event);
        }
    }
    
}
