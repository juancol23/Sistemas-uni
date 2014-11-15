package pe.egcc.app.model;

public class MatematicaModel {

	public long factorial(int n) {
		long f = 1;
		while (n > 1) {
			f *= n--;
		}
		return f;
	}

	public int mcd(int n1, int n2) {
	  while(n1 != n2){
	  	if(n1 > n2){
	  		n1 -= n2;
	  	} else {
	  		n2 -= n1;
	  	}
	  }
	  return n1;
  }
	
}
