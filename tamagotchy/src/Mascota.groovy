
public class Mascota {

	def nivelFelicidad;
    def estado;
	
	public Mascota(Object nivelContenta, Object estado) {
		super();
		this.nivelFelicidad = nivelContenta;
		this.estado = estado;
	}
	
	def come() {
		estado.come(this);
		
	}
	
	def incrementaNivelFelicidad(incremento){
		nivelFelicidad=nivelFelicidad+incremento;
		}
	
	def poneteContenta(){
		estado = new Contenta(); 
	}
	
	def juga(){
		estado.juga(this);
	}
	
	def podesJugar(){
 return (estado.podesJugar());
	}
	
	//Se antepone el $ para mostrar lo que hay dentro de la variable
	def mostrar(){
		println "Mi nivel de felicidad es: $nivelFelicidad";
	}
	
}
