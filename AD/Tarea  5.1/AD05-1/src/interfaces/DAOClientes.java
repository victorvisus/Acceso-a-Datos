
package interfaces;

import Ppal.Clientes;
import Ppal.Ventas;
import java.util.List;

public interface DAOClientes {
    
    public void insertar_registros(Clientes cli) throws Exception;
    public List<Clientes> obtenerClientes() throws Exception;

}
