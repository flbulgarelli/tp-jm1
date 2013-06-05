
import groovy.util.GroovyTestCase

class testManejoDeStock extends GroovyTestCase {
	
	void testNoSePuedeReservarMateriaPrima() {

		def Observador[] observadores = new GeneradorPedidoCompra()
		
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
		
		assertFalse(zinc.sePuedeReservar())
	}

}