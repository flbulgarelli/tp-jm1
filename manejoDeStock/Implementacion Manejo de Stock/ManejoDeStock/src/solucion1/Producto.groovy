package solucion1

public interface Producto {
	
	def nombre
	def boolean esProductoFinal
	def stockMinimo
	def stockMaximo
	def stockActual
	def puntoPedido
	def Observador[] observadores
	def boolean sePuedeReservar()
	def boolean esProductoFinal()
	def boolean sePuedeFabricar()
	def actualizarStock(int unidades)

}


