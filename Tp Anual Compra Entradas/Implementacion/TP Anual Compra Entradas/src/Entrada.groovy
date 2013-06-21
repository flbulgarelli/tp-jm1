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
		espectaculo.getCosto()+ ubicacion.getCosto() - tipo.getDescuento(ubicacion.getCosto())
	}
}
