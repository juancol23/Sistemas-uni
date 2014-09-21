package pe.egcc.eureka.eurekapp.controller;

import java.util.List;
import pe.egcc.eureka.eurekapp.domain.Cliente;
import pe.egcc.eureka.eurekapp.model.ClienteModel;

/**
 *
 * @author Gustavo Coronel
 */
public class ClienteController {

  public List<Cliente> traerPorNombre(String nombre) {
    ClienteModel model = new ClienteModel();
    return model.consultarPorNombre(nombre);
  }
  
    
   //para buscar el codigo
  
     private List <Cliente> fact;
     public Cliente buscar(String nombre)
    {
        for(Cliente f: fact)
            if(f.getCodigo().equals(nombre))
                return f;
        return null;
    }
  
     //seleccionaremos el tmñ
   public int getTamaño()
    {
        return fact.size();
    }

    
     //este metodo es para eliminar 
    public void eliminar(Cliente Elimando_cliente)
    {
        fact.remove(Elimando_cliente);
    }
    
    //agregaremos personas 
    
     public void agregar(Cliente Cliente_agregar)
    {
        fact.add(Cliente_agregar);
    }
  
     //editando los clientes
       public List<Cliente> EditandoClientes(String nombre) {
    ClienteModel model = new ClienteModel();
    return model.consultarPorNombre(nombre);
  }
}
