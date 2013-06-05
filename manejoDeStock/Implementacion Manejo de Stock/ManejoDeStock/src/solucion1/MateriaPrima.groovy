package solucion1

class MateriaPrima implements Producto {
		
	public MateriaPrima(stockActual, stockMinimo, stockMaximo, puntoPedido, nombre, observadores)
	{
		this.observadores = observadores
		this.stockActual=stockActual
		this.stockMinimo=stockMinimo
		this.stockMaximo=stockMaximo
		this.puntoPedido=puntoPedido
		this.nombre=nombre
		this.esProductoFinal=false
	}
	def hayStock()
	{
		return stockActual > 0 
	}


	@Override
	public boolean sePuedeReservar() 
	{
		return false;
	}


	@Override
	public boolean esProductoFinal() 
	{
		return esProductoFinal;
	}

	@Override
	public Object actualizarStock(int unidades) 
	{
		stockActual= stockActual + unidades		
	}


	@Override
	public boolean sePuedeFabricar() 
	{
		return false;
	}
	

}
