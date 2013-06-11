class Ubicacion {
	def int disponibilidad;
	def double costo;
	def fila
	def sector
	
	public Ubicacion(Object disponibilidad,Object costo, fila, sector) {
		super();
		this.disponibilidad = disponibilidad;
		this.costo= costo;
		this.fila = fila
		this.sector = sector
		
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
