package solucion1;

import groovy.util.GroovyTestCase;

class testsManejoStock extends GroovyTestCase {

	void testNoSePuedeReservarMateriaPrima() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)

		assertFalse(zinc.sePuedeReservar())
	}

	void testNoSePuedeFabricarMateriaPrima() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)

		assertFalse(zinc.sePuedeFabricar())
	}

	void testNoSePuedeReservarProductoCompuesto() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)

		def Componente[] componentes = [
			componenteZinc,
			componenteTugs
		]
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertFalse(chapa.sePuedeReservar())
	}

	void testSePuedeFabricarProductoCompuesto() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)

		def Componente[] componentes = [
			componenteZinc,
			componenteTugs
		]

		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertTrue(chapa.sePuedeFabricar())
	}

	void testNoSePuedeFabricarProductoCompuesto() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)

		def Componente[] componentes = [
			componenteZinc,
			componenteTugs
		]

		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertFalse(chapa.sePuedeFabricar())
	}

	void testSePuedeReservarProductoFinal() {
		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		def Componente[] componentesChapa = [
			componenteZinc,
			componenteTugs
		]
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentesChapa, observadores)

		def Componente[] componentesPuerta = [
			new Componente(2,chapa),
			componenteZinc
		]

		def puerta = new ProductoCompuesto(2,2,2,3,"puerta",true, componentesPuerta, observadores)

		assertTrue(puerta.sePuedeReservar())
	}

	void testFabricaPuedeReservar() {

		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		def Componente[] componentesChapa = [
			componenteZinc,
			componenteTugs
		]
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentesChapa, observadores)

		def Componente[] componentesPuerta = [
			new Componente(2,chapa),
			componenteZinc
		]

		def puerta = new ProductoCompuesto(2,2,2,3,"puerta",true, componentesPuerta, observadores)

		assertEquals(puerta.stockActual, 2)

		def fabrica = new Fabrica("no se puede reservar el producto")

		fabrica.reservar(puerta)

		assertEquals(puerta.stockActual,1)
	}

	void testMailEnviado(){

		def nicanor = new UsuarioStub()

		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger(),
			new Mailer(nicanor)
		]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)

		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		def Componente[] componentesChapa = [
			componenteZinc,
			componenteTugs
		]
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentesChapa, observadores)

		def Componente[] componentesPuerta = [
			new Componente(2,chapa),
			componenteZinc
		]

		def puerta = new ProductoCompuesto(2,2,2,3,"puerta",true, componentesPuerta, observadores)

		def fabrica = new Fabrica("no se puede reservar el producto")

		fabrica.reservar(puerta)

		println (nicanor.getMensaje())
	}

	void testPedidoGeneradoYLogCreado(){

		def Observador[] observadores = [
			new GeneradorPedidoCompra(),
			new Logger()
		]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)

		zinc.actualizarStock(-1)

		def generador = observadores[0]
		def pedidos = generador.getPedidos()
		pedidos.each{
			def producto = it.getMateriaPrima()
			def cantidad = it.getCantidad()
			println "se genero un pedido de compra de $producto en $cantidad unidades"
		}
	}

	void testLogStockMaximo() {

		def Observador[] observadores = [new Logger()]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)

		zinc.actualizarStock(60)
	}
	
}
