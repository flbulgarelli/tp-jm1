

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
		this.notificar(unidades)
	}
	
	def hayStock()
	{
		return stockActual>0
	}
	//de esta manera el observer sólo hace lo que tiene que hacer
	/*
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
		
	} PLANTEADO PARA LA OTRA ALTERNATIVA
	*/
	def notificar(unidades) //Comparar con notificar(unidades)
	{
		observadores.each{ notificacionCambioStock(stockActual,unidades)}
	}

}


