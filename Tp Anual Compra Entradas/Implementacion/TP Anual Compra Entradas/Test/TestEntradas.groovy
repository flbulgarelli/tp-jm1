import static org.junit.Assert.*;
import groovy.util.GroovyTestCase;


class TestEntradas extends GroovyTestCase {
	
		 
	void testComprarEntradaMayor() {
	    def sing = SingletonID.instance
		sing.id(1)
		
		def campus= new Local()
		def fila1Sector4 = new Ubicacion(10,250,1,4)
		def espectaculo1 = new Categoria1(18122012, [])
		campus.agregarEspectaculo(espectaculo1)
		campus.agregarUbicacion(fila1Sector4)
		def mayor= new Mayor()
		
		def jonhy = new Persona(mayor,1000)
		campus.venderEntrada(1, 4, 18122012, jonhy) 

		assertEquals(jonhy.getSaldo(),750,0)
		assertEquals(jonhy.entradas.size(),1)
		assertEquals(campus.entradasVendidas.size(),1)
		assertEquals(sing.getId(),2)
		
	}
		
	void testComprarEntradaJubilado(){
		def sing = SingletonID.instance
		sing.id(1)
		def jubilada= new Jubilado()
		
		def medrano= new Local()
		def fila5Sector3= new Ubicacion(20,100,5,3)
		def espectaculo2= new Categoria2(06062013,[])
		medrano.agregarEspectaculo(espectaculo2)
		medrano.agregarUbicacion(fila5Sector3)
		
		def caro = new Persona(jubilada,800)
		
		medrano.venderEntrada(5, 3, 06062013, caro)
		medrano.venderEntrada(5, 3, 06062013, caro)
		
		
		assertEquals(caro.entradas.size(),2)
		assertEquals(medrano.entradasVendidas.size(),2)
		assertEquals(sing.getId(),3)
		
	}
	
	void testComprarEntradaMenor(){
		def menor= new MenorEdad()
		
		def locuras= new Local()
		def fila4Sector1 = new Ubicacion(10,350,4,1)
		def espectaculo3 = new Categoria3(20042013,[])
		locuras.agregarEspectaculo(espectaculo3)
		locuras.agregarUbicacion(fila4Sector1)
		
		def juan = new Persona(menor,2000)
		
		locuras.venderEntrada(4, 1, 20042013, juan)
		locuras.venderEntrada(4, 1, 20042013, juan)
		locuras.venderEntrada(4, 1, 20042013, juan)
		
		assertEquals(juan.entradas.size(),3)
		assertEquals(locuras.entradasVendidas.size(),3)
		assertTrue(juan.getSaldo()<2000)
		
	}
	void testNoPuedeComprar(){
		
		def menor= new MenorEdad()
		
		def locuras= new Local()
		def fila4Sector1 = new Ubicacion(10,350,4,1)
		def espectaculo3 = new Categoria3(20042013,[])
		locuras.agregarEspectaculo(espectaculo3)
		locuras.agregarUbicacion(fila4Sector1)
		
		def yami = new Persona(menor,50)
		
		locuras.venderEntrada(4, 1, 20042013, yami)
		
		assertEquals(yami.entradas.size(),0)
		assertEquals(locuras.entradasVendidas.size(),0)
		
	}
	
	void testComprarMixto(){
		def sing= SingletonID.instance
		sing.id(20)
		def mayor= new Mayor()
		
		def campus= new Local()
				
		def fila1Sector4 = new Ubicacion(10,250,1,4)
		def espectaculo1 = new Categoria1(18122012, [])
		
		def fila5Sector3= new Ubicacion(20,100,5,3)
		def espectaculo2= new Categoria2(06062013,[])
		
		def fila4Sector1 = new Ubicacion(10,350,4,1)
		def espectaculo3 = new Categoria3(20042013,[])
		
		campus.agregarEspectaculo(espectaculo1)
		campus.agregarEspectaculo(espectaculo2)
		campus.agregarEspectaculo(espectaculo3)
		
		campus.agregarUbicacion(fila4Sector1)
		campus.agregarUbicacion(fila5Sector3)
		campus.agregarUbicacion(fila1Sector4)
		
		
		def leo = new Persona(mayor,5000)
		
		campus.venderEntrada(4, 1, 20042013, leo)
		campus.venderEntrada(5, 3, 06062013, leo)
		campus.venderEntrada(1, 4, 18122012, leo)
		campus.venderEntrada(4, 1, 20042013, leo)
		campus.venderEntrada(5, 3, 06062013, leo)
		campus.venderEntrada(1, 4, 18122012, leo)
		
		
		assertEquals(leo.entradas.size(),6)
		assertTrue(leo.getSaldo()<5000)
		assertEquals(campus.entradasVendidas.size(),6)
		assertEquals(sing.getId(),26)
		
		
	}
}
