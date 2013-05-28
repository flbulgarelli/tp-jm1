class Ubicacion {
	def int disponibilidad;
	def double costo;
	
	public Ubicacion(Object disponibilidad,Object costo) {
		super();
		this.disponibilidad = disponibilidad;
		this.costo= costo;
	}
	
	def getCosto() {
		return costo;
	}
	def disponible() {
		if (disponibilidad>0){
		return true;
		}//fin if
		else { 
			return false;
		}//fin else
	}
	def actDispon() {
		if (this.disponible()) {
		disponibilidad--;
		}//fin if
	}
}
