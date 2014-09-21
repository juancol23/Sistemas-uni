package pe.egcc.eureka.eurekapp.dao.espec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel
 * @param <T>
 */
public interface IDaoCrud <T>{
  
  T consultarPorCodigo(String codigo);
  
  List<T> consultarPorNombre(String nombre);
  
  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(String codigo);
  
}
