
class Local {
	
	def ubicaciones = []
	def espectaculos = []
	def entradasVendidas = []
	
	def venderEntrada(fila, sector, fecha, persona)
	{
		def Entrada entrada
		def Ubicacion ubicacion
		def Espectaculo espectaculo 
		
		ubicacion = this.traerUbicacion(fila,sector)
		espectaculo =  this.traerEspectaculo(fecha)
		
		if(ubicacion.disponible())
		{
			
			entrada = new Entrada(ubicacion,espectaculo)
			
			sing=SingletonID.getInstance()
			codigo=sing.id
			entrada.id(codigo)
			
			if(persona.comprarEntrada(entrada))
			{
				sing.incrementarId()
				ubicacion.actDispon()
				
				entradasVendidas << entrada
			}
		}
		else
		{
			println "No hay disponibilidad"
		}
		
	}
	
	def Ubicacion traerUbicacion(fila,sector)
	{
		this.ubicaciones.find { it.fila == fila && it.sector == sector }
	}
	def Espectaculo traerEspectaculo(fecha)
	{
		this.Espectaculos.find { it.fecha == fecha }
	}

	
}
