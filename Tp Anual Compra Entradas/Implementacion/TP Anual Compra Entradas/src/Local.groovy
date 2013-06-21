
class Local {
	
	def List ubicaciones = [] 
	def List espectaculos =[]
	def List entradasVendidas =[] 
	
	def Local(){
	}
	
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
