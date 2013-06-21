
class Persona {
	def tipo 
	def List entradas
	//FIXME de dónde sale el saldo? No veo de dónde sale este concepto, no está en el enunciado, ni 
	//en las pregunta al cliente, ni siquiera en sus CU's. No agreguen funcionalidad
	//que no surja de los requerimientos, porque es esfuerzo invertido en algo que no aporta valor
	//al sistema 
	def saldo 
	
	public Persona(tipo,saldo) {
		this.tipo=tipo 
		this.saldo=saldo 
		this.entradas= [] 
	}
	
	def boolean comprarEntrada(Entrada entrada) {
		if ((saldo >= entrada.getCosto(tipo))) {
			saldo = saldo - entrada.getCosto(tipo) 
			entradas.add(entrada) 
			true 
		} else {
			false 
		}
	}
}
