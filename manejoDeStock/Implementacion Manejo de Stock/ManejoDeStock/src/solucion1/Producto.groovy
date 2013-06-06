package solucion1

abstract class Producto {

	def nombre
	def stockMinimo
	def stockMaximo
	def stockActual
	def puntoPedido
	def Observador[] observadores

	def boolean sePuedeReservar() {
		return false
	}
	def boolean esProductoFinal() {
		return false
	}
	def boolean sePuedeFabricar() {
		return false
	}
	def actualizarStock(int unidades) {
		stockActual= stockActual + unidades
		this.notificar(unidades)
	}

	def hayStock() {
		return stockActual>0
	}

	def notificar(unidades) {
		observadores.each{ it.notificarseDeCambioDeStock(stockActual, stockMinimo, stockMaximo, puntoPedido, unidades, nombre)}
	}
}


