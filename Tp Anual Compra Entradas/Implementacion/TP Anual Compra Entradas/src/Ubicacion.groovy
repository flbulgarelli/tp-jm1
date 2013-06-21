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
		disponibilidad>0
	}
	def actDispon() {
		if (this.disponible()) {
		disponibilidad-- 
		}//fin if
	}
	
	
}
