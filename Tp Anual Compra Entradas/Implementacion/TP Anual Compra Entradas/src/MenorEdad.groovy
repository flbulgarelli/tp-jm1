
class MenorEdad extends Tipo {
	
	public MenorEdad() {
	super();
	}
	
	def double getDescuento(double valorEntradaBase) {
		if (valorEntradaBase > 100) {
			return valorEntradaBase*0.2;
		}//fin if
		if ((valorEntradaBase >50) && (valorEntradaBase <=100)) {
			return 10;
		}//fin if
		else {
			return 0;
		}//fin else
	};
}
