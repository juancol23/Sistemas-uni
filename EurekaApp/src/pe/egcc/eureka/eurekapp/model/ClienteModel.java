package pe.egcc.eureka.eurekapp.model;

import java.util.List;
import pe.egcc.eureka.eurekapp.dao.espec.IDaoCrudCliente;
import pe.egcc.eureka.eurekapp.dao.impl.DaoCrudCliente;
import pe.egcc.eureka.eurekapp.domain.Cliente;

/**
 *
 * @author Gustavo Coronel
 */
public class ClienteModel {
  
  private IDaoCrudCliente daoCliente = new DaoCrudCliente();
  
  public List<Cliente> consultarPorNombre(String nombre) {
    return daoCliente.consultarPorNombre(nombre);
  }
}
