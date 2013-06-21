
//FIXME poqué es espectáculo la clase base de las categorías?
// O bien el nombre está mal elegido, o bien están mezclando dos abstracciones.
// Que responsabilidad cumple un espectáculo? Es la misma que la de categoria? Es el mismo concepto?
// Esto no solo afecta a la cohesión del componente (, no hay ninguna relación entre el comportamiento de la categoría y su estado interno),
// sino también hace mas difícil de mantener al sistema:
// nótese que todoas las categorias, para ser instanciadas, requieren de una fecha y banda, pero ninguna de estas
// subclases las utilizan. 
class Espectaculo {
  
  def fecha;
  def bandas;
  
	
		
	
}
