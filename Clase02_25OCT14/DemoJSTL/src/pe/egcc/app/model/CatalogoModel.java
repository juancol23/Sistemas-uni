package pe.egcc.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogoModel {

	
	public List<Map<String,Object>> listado(){
		List<Map<String,Object>> lista;
		lista = new ArrayList<Map<String,Object>>();
		// Producto 1
		Map<String,Object> p = new HashMap<String, Object>();
		p.put("id", "P001");
		p.put("nombre", "Televisor");
		p.put("precio", 1567.78);
		lista.add(p);
		// Producto 2
		p = new HashMap<String, Object>();
		p.put("id", "P002");
		p.put("nombre", "Refrigeradora");
		p.put("precio", 4567.78);
		lista.add(p);
		// Producto 3
		p = new HashMap<String, Object>();
		p.put("id", "P003");
		p.put("nombre", "Cocina");
		p.put("precio", 989.45);
		lista.add(p);
		return lista;
	}
}
