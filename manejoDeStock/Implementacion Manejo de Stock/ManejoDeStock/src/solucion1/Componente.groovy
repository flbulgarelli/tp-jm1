package solucion1

class Componente 
{
	public Componente(cantidad, elemento)
	{
		this.cantidad = cantidad
		this.elemento = elemento
	}
	
	def cantidad
	def Producto elemento
	
	def alcanzanLasUnidades()
	{
		this.cantidad <= this.elemento.stockActual
	}
	
}
