
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
