import groovy.util.GroovyTestCase

class tamagotchiTest extends GroovyTestCase {

	void testSiEstaContentaYJuega() {

		def leo = new Mascota(70, new Contenta())

		assertTrue(leo.podesJugar())

		leo.juga()

		assertEquals (leo.getNivelFelicidad(),72)
	}

	void testSiEstaAburridaYJuega(){

		def leo = new Mascota (70, new Aburrida(30,20))

		assertTrue(leo.podesJugar())

		leo.juga()

		assertTrue(leo.podesJugar())

		leo.juga()

		assertEquals(leo.getNivelFelicidad(),72)
	}

	void testSiEstaHambrientaYJuega(){

		def leo = new Mascota(70, new Hambrienta())

		assertFalse(leo.podesJugar())
	}

	void testSiEstaContentaYCome(){

		def leo = new Mascota(70, new Contenta())

		assertEquals(leo.getNivelFelicidad(),70)

		leo.come()

		assertEquals(leo.getNivelFelicidad(),71)
	}

	void testSiEstaAburridaYComeYNoPasaron80minutos(){
		
		def estadoAburrida = new Aburrida (30,10)
		
		def stubDate = new TiempoActual(40,10)
		
	    estadoAburrida.tiempoActual = stubDate
		
		def leo = new Mascota (70, estadoAburrida)
		
		leo.come()
		
		assertEquals(leo.getNivelFelicidad(),70)
		
		leo.come()
		
		assertEquals(leo.getNivelFelicidad(),70)
		
	}

	void testSiEstaAburridaYComeYPasaron80minutos(){
		
		def estadoAburrida = new Aburrida (40,20)
		
		def stubDate = new TiempoActual(40,23)
		
		estadoAburrida.tiempoActual = stubDate
		
		def leo = new Mascota (70, estadoAburrida)
		
		leo.come()
		
		assertEquals(leo.getNivelFelicidad(),70)
		
		leo.come()
		
		assertEquals(leo.getNivelFelicidad(),71)
		
	}

	void testSiEstaHambrientaYCome(){
		def leo = new Mascota(70,new Hambrienta())

		assertFalse (leo.podesJugar())

		leo.come()

		assertTrue (leo.podesJugar())
	}
}