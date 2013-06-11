package solucion1

class Mailer implements Observador {
	
	def destinatario
	
	public Mailer (destinatario){
		this.destinatario = destinatario
	}

	@Override
	public Object notificarseDeCambioDeStock(Object stockActual,
			Object stockMinimo, Object stockMaximo, Object puntoPedido,
			Object unidades, Object nombre) {
		// TODO Auto-generated method stub
		
			this.enviarMail(nombre)
	}
	
	void enviarMail(nombre){
		def mensaje = "el stock actual de $nombre es menor al minimo establecido"
		destinatario.recibir(mensaje)
		
	}

	
}
