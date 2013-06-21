/*FIXME repito un comentario que les hice en un mail anterior:
 * Les dejo una pregunta: los objetos de su solucion que modelan las categorias y tipos de usuarios, 
 * ¿son statefull? Dos objetos "tipoJubilado", ¿podrían ser intercambiados? 
 * ¿Que consencuancias podría traer eso? ¿Como podrían mejorar su diseño en tal sentido? 
 * Me gustaría ver un análisis (tipo bonus) sobre esto. 
 */
class Categoria3 extends Espectaculo{
	
	public Categoria3(fecha, bandas)
	{
		this.fecha = fecha
		this.bandas = bandas
	}
	
	def int getCosto(){
		100;
	}

}
