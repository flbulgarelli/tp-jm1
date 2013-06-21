
class Local {
	
	def List ubicaciones = [] 
	def List espectaculos =[]
	def List entradasVendidas =[] 
	
	def venderEntrada(fila, sector, fecha, Persona persona)
	{
		def Entrada entrada
		def Ubicacion ubicacion
		def Espectaculo espectaculo 
		
		ubicacion = this.traerUbicacion(fila,sector)
		espectaculo =  this.traerEspectaculo(fecha)
		
		if(ubicacion.disponible())
		{
			
			entrada = new Entrada(espectaculo,ubicacion,fecha)
			
			/*FIXME si bien los motores de persistencia se encargan normalmente de solucionar este problema,
			 * entiendo que hayan tenido que implementar a mano un ID autoincremental dado que en esta parte del TP aún 
			 * no contamos con esta infraestructura.
			 * 
			 * Sin embargo, este no tiene una interfaz razonble: el usuario de su SingletonID debe primero
			 * obtener el id, luego incrementarlo, para que otro no lo reutilice.
			 *  
			 * No sólo esto es propenso a errores (si algun código cliente del SingletonID olvidó incrementarlo, 
			 * el sistema todo se comportará inadecuamente al introducir inconsistencias y ids duplicados), sino que 
			 * no funciona en ambientes concurrentes. Un componente que genere un ID típicamente:
			 * 	1.expondrá una única operación que permita obtener siempre un ID único  (su SingletonID.id no cumple esto,
			 *    envios consecutivos del mensaje id devolverán el mismo id). Si el ID es autoincremental, 
			 *    esto implica que la operación se encargará, al mismo tiempo, de incremantar y devolver el nuevo valor.
			 *  2.generará IDs opacos, es decir, sólo garantizará que los ids sean únicos, pero no dará garantías sobre el valor concreto del id generado
			 *    El código cliente no debería asumir nada sobre el valor concreto. 
			 *    Los IDs autoincrementales son un caso concreyo de ID; lo que aseguran es que el siguiente ID será mayor que el anterior (típicamente en una unidad)
			 *    pero el códgio cliente no debería depender del tipo de incremento. Por ejemplo, ustedes están incrementando el ID sólo cuando realmente lo utilizaron, 
			 *    pero esto es incorrecto: el ID debería ser incrementado siempre, sin importar que haya sido usado o no, para evitar los problemas del punto 1
			 *  3. Generará valores de forma thread-safe. En la materia no nos estamos preocupando mucho por la concurrencia, no porque no sean un tema
			 *    fundamental, sino porque el tiempo es tirano y no todos los alumnos han cursado operativos previamente. No les voy a pedir que cambien nada
			 *    al respecto de esto último,pero sí que entiendan que un entero incrementado mediante ++ es un pésimo ID único, porque
			 *     a. están separando la operación de obtención e incremento en dos operaciones (id e incrementarId)
			 *     b. aún la operación ++ NO es atómica (ergo, no es thread safe)
			 *    Por ello, para implementar IDs, se utilizan cosas como, por ejemplo:
			 *     * UUIDs : identificadores únicos universales, a veces costosos de calcular, 
			 *     	pero que garantizan la generación de valores teoricamente únicos a nivel mundial. 
			 *      Hay distintas variantes; utilizan para su cálculo elementos como números aleatorios, horarios, direcciones MAC, etc   
			 *      Por ejemplo, en la JVM se obtiene mediante UUID.randomUUID()  
			 *     * Valores autoincrementales atómicos: una solución más modesta que la anterior, pero igualmente útil, similar al id++ que ustedes emplearon pero 
			 *       que garantiza ser thread safe. Por ejemplo AtomicLong.incrementAndGet()
			 *     * IDs con esquemas ad-hoc, también sintetizados como los UUIDs a partir de elementos como hora del sistema, MAC, hashes, numeros de proceso, etc, pero que 
			 *       no pretenden ser únicos a escal global sino dentro de algun contexto más reducido. Ejemplo: los ids de la base de datos no relacional MongoDB  
			 *
			 * En resumen, independienteme de la forma de generación de los IDs, las cuestiones de concurrencia,
			 * y aún reconociendo que rara vez será necesario en un sistema de este tipo
			 * generar un ID a mano, un componente que lo haga debería permitir generarlo empleando un único mensaje.        
		     */    
			def sing=SingletonID.instance
			entrada.id = sing.id
			
			if(persona.comprarEntrada(entrada))
			{
				sing.incrementarId()
				ubicacion.actDispon()
				
				this.entradasVendidas.add(entrada)
			}
		}
		else
		{
			//FIXME Esto está mal, no sólo están escribiendo por consola
			//lo cual es una resposabilidad de la UI y no del dominio, sino que además
			//en este punto esta información se está perdiendo y el sistema no da ningun feedback 
			//acerca de que no hubo disponibilidad!!
			println "No hay disponibilidad"
		}
		
	}
	
	def Ubicacion traerUbicacion(fila,sector)
	{
		this.ubicaciones.find {  it.fila == fila && it.sector == sector }
	}
	def Espectaculo traerEspectaculo(fecha)
	{
		this.espectaculos.find { it.fecha == fecha }
	}

	def agregarEspectaculo(espec){
		espectaculos.add(espec)
	}	
	def agregarUbicacion(ub){
		ubicaciones.add(ub)
	}
}
