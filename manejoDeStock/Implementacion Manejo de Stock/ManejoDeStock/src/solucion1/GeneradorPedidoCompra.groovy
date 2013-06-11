package solucion1

class GeneradorPedidoCompra implements Observador
{
	def pedidos
	
	public GeneradorPedidoCompra(){
		this.pedidos = []
	}
	
	@Override
	public Object notificarseDeCambioDeStock(Object stockActual, Object stockMinimo, Object stockMaximo, Object puntoPedido, Object unidades, Object nombre) 
	{
		if(stockActual < stockMinimo)
		{
			pedidos.add(new PedidoCompra(nombre, puntoPedido))
		
		}
		return null;
	}

}
