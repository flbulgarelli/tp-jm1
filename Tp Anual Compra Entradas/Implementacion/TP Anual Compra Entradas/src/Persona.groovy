
class Persona {
	def tipo;
	def entradas;
	def saldo;
	
	public Persona(tipo,saldo) {
		super();
		this.tipo=tipo;
		this.saldo=saldo;
		this.entradas= [];
	}
	
	def compraEntrada(entrada) {
		if ((saldo >= entrada.getCosto(tipo))&& (entrada.ubicacion.disponible())) {
			saldo = saldo - entrada.getCosto(tipo);
			entradas.add(entrada);
			entrada.ubicacion.actDispon();
		}//fin if
		else {
			println "Imposible realizar la compra.";
		}//fin else
	}
}
