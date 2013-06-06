package solucion1

class Logger implements Observador {

	def logs
	
	public Logger(){
		this.logs = []
	}

	@Override
	public Object notificarseDeCambioDeStock(Object stockActual,
			Object stockMinimo, Object stockMaximo, Object puntoPedido,
			Object unidades, Object nombre) {
		// TODO Auto-generated method stub
		if((stockActual - unidades) >= stockMinimo){ //si el stock anterior ya era menor al minimo, no hace nada
			if(stockActual < stockMinimo){
				logs << new Log(nombre, "el stock actual es menor al minimo establecido")
			}
		}
		if(stockMinimo >= (stockActual - unidades)){
			if(stockActual > stockMinimo){
				def mensaje = "el stock actual es mayor al minimo establecido en $unidades"
				logs << new Log(nombre, mensaje)
			}
		}
		if((stockActual > stockMaximo)){
			def mensaje = "el stock actual de $nombre supera al maximo establecido"
			logs << new Log(nombre, mensaje)
			println mensaje
		}
		return null;
	}

}
