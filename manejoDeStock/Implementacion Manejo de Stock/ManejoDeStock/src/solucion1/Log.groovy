package solucion1

class Log {

	def producto
	def fecha
	def mensaje
	
	public Log (Object nombre, Object mensaje){
		this.producto = nombre
		this.fecha = new Date()
		this.mensaje = mensaje
	}
}
