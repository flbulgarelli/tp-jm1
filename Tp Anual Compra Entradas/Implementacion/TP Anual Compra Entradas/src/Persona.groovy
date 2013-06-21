
class Persona {
	def tipo 
	def List entradas 
	def saldo 
	
	public Persona(tipo,saldo) {
		this.tipo=tipo 
		this.saldo=saldo 
		this.entradas= [] 
	}
	
	def boolean comprarEntrada(Entrada entrada) {
		def int codigo 
		def sing 
		if ((saldo >= entrada.getCosto(tipo))) {
			saldo = saldo - entrada.getCosto(tipo) 
			entradas.add(entrada) 
			true 
		} else {
			false 
		}
	}
}
