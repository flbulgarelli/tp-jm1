class Entrada {
	
	def espectaculo;
	def Ubicacion ubicacion;
	def id;
	def fecha = new Date();

	public Entrada(espectaculo,ubicacion) {
		
		this.espectaculo=espectaculo
		this.ubicacion=ubicacion
	}
	
	def getCosto(tipo) {
		def costo;
		costo = espectaculo.getCosto()+ ubicacion.getCosto() - tipo.getDescuento(ubicacion.getCosto());
		
		/* if((espectaculo.fecha-fecha)>1mes) {
		 * return costo*0.9;
		 * }
		 * else {
		 * return costo;
		 * }
		 */
		
		return costo;	
	}

	def id(codigo){
		this.id=codigo;
	}	
}
