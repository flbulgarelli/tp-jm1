
public class Aburrida extends Stado {

	def minutosDeAburrimiento=160;
	
	
	def come(mascota){
		if (this.minutosDeAburrimiento>80){
			mascota.poneteContenta();
		}
		
	}
	
	def juga(mascota){
		mascota.poneteContenta();
			
	}

	
}
