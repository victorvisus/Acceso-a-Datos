
package interfaces;

import Ppal.Ventas;
import java.util.List;

public interface DAOVentas {
    
    public void insertar_registros(Ventas ven) throws Exception;
    public List<Ventas> obtenerVentasConId() throws Exception;
    
}
