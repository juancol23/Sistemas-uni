
package pe.egcc.eureka.eurekapp.controller;

import pe.egcc.eureka.eurekapp.domain.Empleado;
import pe.egcc.eureka.eurekapp.model.LogonModel;
import pe.egcc.eureka.eurekapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonModel model = new LogonModel();
    Empleado bean = model.validar(usuario, clave);
    Memoria.put("empleado", bean);
  }
  
}
