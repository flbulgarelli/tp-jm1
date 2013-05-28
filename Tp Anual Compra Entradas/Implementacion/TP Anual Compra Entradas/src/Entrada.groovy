class Entrada {
	
	def espectaculo;
	def Ubicacion ubicacion;

	public Entrada(espectaculo,ubicacion) {
		super();
		this.espectaculo=espectaculo;
		this.ubicacion=ubicacion;
	}
	
	def getCosto(tipo) {
		def costo;
		costo = espectaculo.getCosto()+ ubicacion.getCosto() - tipo.getDescuento(ubicacion.getCosto());
		return costo;	
	}
}
