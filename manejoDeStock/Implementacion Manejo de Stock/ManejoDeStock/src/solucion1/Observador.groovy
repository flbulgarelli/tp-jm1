package solucion1

interface Observador {

	def notificarseDeCambioDeStock(stockActual, stockMinimo, stockMaximo, puntoPedido, unidades, nombre)
}