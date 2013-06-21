class Ubicacion {
	def int disponibilidad 
	def double costo 
	def fila
	def sector
	
	public Ubicacion(Object disponibilidad,Object costo, fila, sector) {
		super() 
		this.disponibilidad = disponibilidad 
		this.costo= costo 
		this.fila = fila
		this.sector = sector
		
	}
	
	def disponible() {
		if (disponibilidad>0){
			true 
		}//fin if
		else { 
			false 
		}//fin else
	}
	def actDispon() {
		if (this.disponible()) {
		disponibilidad-- 
		}//fin if
	}
	
	
}
