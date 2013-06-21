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
	//FIXME expresividad. No usar acrónimos, afecta a la mantenibilidad del sistema 
	def actDispon() {
		if (this.disponible()) {
		disponibilidad-- 
		}//fin if
	}
	
	
}
