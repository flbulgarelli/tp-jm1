class Entrada {
	
	def espectaculo;
	def Ubicacion ubicacion;
	def id;
	def fecha 

	public Entrada(espectaculo,ubicacion,fecha) {
		
		this.espectaculo=espectaculo
		this.ubicacion=ubicacion
		this.fecha=fecha
	}
	
	def getCosto(Tipo tipo) {
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
