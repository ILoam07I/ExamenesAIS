
package modelo.entidades;

import java.util.Objects;

public class MetodoPagoImpl implements MetodoPago {
    
    private String metodo;

    public MetodoPagoImpl(String metodo) {
        
        if (metodo != null) {            
            this.metodo = metodo;         
        }
    }

    @Override
    public String getMetodo() {
        return metodo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.metodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MetodoPagoImpl other = (MetodoPagoImpl) obj;
        return Objects.equals(this.metodo, other.metodo);
    }
    
    @Override
    public String toString() {
        return metodo;
    }
    
}
