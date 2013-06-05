

class Fabrica 
{

	def mensajeError
	
	
	public Fabrica(mensajeError)
	{
		this.mensajeError = mensajeError
	}
	
	def reservar(Producto producto)
	{
		if(producto.sePuedeReservar())  
		{
			producto.actualizarStock(-1)
		}
		else
		{
			println mensajeError
		}	
			
	}
	
	def comprar(Producto producto, int unidades)
	{
		producto.actualizarStock(unidades)	
	}
	
}
