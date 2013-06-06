package solucion1
class ProductoCompuesto extends Producto {
	def Componente[] componentes
	def boolean esProductoFinal
	public ProductoCompuesto(stockActual, stockMinimo, stockMaximo, puntoPedido, nombre, esProductoFinal, componentes, observadores) {
		this.componentes = componentes
		this.observadores = observadores
		this.stockActual=stockActual
		this.stockMinimo=stockMinimo
		this.stockMaximo=stockMaximo
		this.puntoPedido=puntoPedido
		this.nombre=nombre
		this.esProductoFinal=esProductoFinal //Se agrega este flag porque puede haber productos compuestos no finales y, por ahora, s�lo queremos vender finales
	}

	def agregarComponente(Componente componente) {
		this.componentes << componente
	}

	@Override
	public boolean sePuedeReservar() {
		if(! esProductoFinal) {
			return false
		}

		if(this.hayStock()) {
			return true
		}
		if(this.sePuedeFabricar()) {
			this.fabricate()
			return true
		}
		else {
			return false
		}
	}


	def boolean sePuedeFabricar() {
		return componentes.every { it.alcanzanLasUnidades()}
	}

	def hayStock() {
		return stockActual>0
	}


	@Override
	public boolean esProductoFinal() {
		return esProductoFinal;
	}

	def fabricate() {

		componentes.each{ it.elemento.actualizarStock(-it.cantidad) }
		this.actualizarStock(1)
	}
}

