package pe.egcc.eureka.eurekapp.model;

import pe.egcc.eureka.eurekapp.dao.espec.IDaoCrudEmpleado;
import pe.egcc.eureka.eurekapp.dao.impl.DaoCrudEmpleado;
import pe.egcc.eureka.eurekapp.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonModel {

  
  public Empleado validar(String usuario, String clave){
    IDaoCrudEmpleado dao = new DaoCrudEmpleado();
    Empleado bean = dao.consultarPorUsuario(usuario);
    if(bean == null){
      throw new RuntimeException("Error, usuario no encontrado.");
    }
    if(!bean.getClave().equals(clave)){
      throw new RuntimeException("Error, clave incorrecta.");
    }
    return bean;
  }
}
