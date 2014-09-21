package pe.egcc.eureka.eurekapp.dao.espec;

import pe.egcc.eureka.eurekapp.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public interface IDaoCrudEmpleado
        extends IDaoCrud<Empleado> {

  Empleado consultarPorUsuario(String usuario); 
}
