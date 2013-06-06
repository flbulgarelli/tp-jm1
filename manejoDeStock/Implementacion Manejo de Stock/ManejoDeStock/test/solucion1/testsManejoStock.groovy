package solucion1;

import groovy.util.GroovyTestCase;

class testsManejoStock extends GroovyTestCase 
{
	
	void testNoSePuedeReservarMateriaPrima()
	{
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
	
				
		
		assertFalse(zinc.sePuedeReservar())
	}
	
	void testNoSePuedeFabricarMateriaPrima()
	{
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
	
				
		
		assertFalse(zinc.sePuedeFabricar())
	}
	
	void testNoSePuedeReservarProductoCompuesto()
	{	
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)
		
		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		
		def Componente[] componentes = [componenteZinc, componenteTugs] 
		
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertFalse(chapa.sePuedeReservar())
	}
	
	void testSePuedeFabricarProductoCompuesto()
	{
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(20,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)
		
		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		
		def Componente[] componentes = [componenteZinc, componenteTugs]
		
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertTrue(chapa.sePuedeFabricar())
	}
	
	void testNoSePuedeFabricarProductoCompuesto()
	{
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)
		
		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		
		def Componente[] componentes = [componenteZinc, componenteTugs]
		
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentes, observadores)
		assertFalse(chapa.sePuedeFabricar())
	}
	
	void testSePuedeReservarProductoFinal()
	{
		def Observador[] observadores = [new GeneradorPedidoCompra(), new Logger()]
		def zinc = new MateriaPrima(1,20,40,4,"zinc",observadores)
		def tugsteno = new MateriaPrima(20,20,40,4,"tugsteno",observadores)
		
		def componenteZinc = new Componente(2, zinc)
		def componenteTugs = new Componente(2, tugsteno)
		def Componente[] componentesChapa = [componenteZinc, componenteTugs]
		def chapa = new ProductoCompuesto(2,2,2,3,"chapa",false, componentesChapa, observadores)	
		
		def Componente[] componentesPuerta = [new Componente(2,chapa), componenteZinc]

		def puerta = new ProductoCompuesto(2,2,2,3,"puerta",true, componentesPuerta, observadores)	

		assertTrue(puerta.sePuedeReservar())
	}
}
