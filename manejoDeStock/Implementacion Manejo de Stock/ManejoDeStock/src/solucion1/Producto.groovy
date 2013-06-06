package solucion1

abstract class Producto {
	
	def nombre
	def stockMinimo
	def stockMaximo
	def stockActual
	def puntoPedido
	def Observador[] observadores
	
	def boolean sePuedeReservar()
	{
		return false
	}
	def boolean esProductoFinal()
	{
		return false
	}
	def boolean sePuedeFabricar()
	{
		return false
	}
	def actualizarStock(int unidades)
	{
		stockActual= stockActual + unidades
		this.notificar(stockActual, unidades, nombre)// agregar todo lo que necesites : de esta manera, el observer tiene que validar si la notificacion le corresponde o no. Se desacopla mucho más el producto del observer

	}
	
	def hayStock()
	{
		return stockActual>0
	}
	
	def notificar(stockActual,unidades,nombre) 
	{
		observadores.each{ it.notificarseDeCambioDeStock(stockActual,unidades, nombre)}
	}

}


