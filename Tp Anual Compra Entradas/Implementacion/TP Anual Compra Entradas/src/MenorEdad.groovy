
class MenorEdad extends Tipo {
	
	public MenorEdad() {
	super() 
	}
	
	def double getDescuento(double valorEntradaBase) {
		if (valorEntradaBase > 100) {
			valorEntradaBase*0.2 
		} else if ((valorEntradaBase >50) && (valorEntradaBase <=100)) {
			10 
		} else {
			0 
		}
	} 
}
