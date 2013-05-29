
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
		def int codigo;
		def sing;
		if ((saldo >= entrada.getCosto(tipo))&& (entrada.ubicacion.disponible())) {
			saldo = saldo - entrada.getCosto(tipo);
			entradas.add(entrada);
			entrada.ubicacion.actDispon();
			sing=SingletonID.getInstance()			
			codigo=sing.id;
			entrada.id(codigo);
			sing.sumarId();
		}//fin if
		else {
			println "Imposible realizar la compra.";
		}//fin else
	}
}
