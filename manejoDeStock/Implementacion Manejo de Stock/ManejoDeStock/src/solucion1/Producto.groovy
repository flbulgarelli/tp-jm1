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
		//this.notificar1(unidades) : de esta manera el observer sólo hace lo que tiene que hacer
		//this.notificar2(unidades) : de esta manera, el observer tiene que validar si la notificacion le corresponde o no. Se desacopla mucho más el producto del observer
		
	}
	
	def hayStock()
	{
		return stockActual>0
	}
	
	def notificar(unidades)
	{
		def stockAnterior = stockActual - unidades
		 
		if(stockActual < stockMinimo)
		{
			observadores.each{ it.notificacionStockMenorAlMinimo()}
		}

		if(stockAnterior < stockMinimo && stockActual > stockMinimo)
		{
			observadores.each{ it.notificacionSuperoStockMinimo()}
		}
		
		if(stockActual > stockMaximo)
		{
			observadores.each{ it.notificacionStockMayorAlMaximo()}
		}
		
		observadores.each {it.notificacionUnidades(unidades)}
		
	}
	
	def notificar2(unidades) //Comparar con notificar(unidades)
	{
		observadores.each{ notificacionCambioStock(stockActual,unidades)}
	}

}


