
public class Prueba {
	//EL main es como nuestro workspace en paradigmas, aca llamamos a todo
	public static void main(String[] args) {

//Prueba para la mascota con 70 de felicidad y arranca en estado contento	
def leo = new Mascota(70,new Contenta());

println "Empezamos a interactuar con la mascota";

//Le digo que coma y observo que el nivel de felicidad aumenta a 71
println "Leo come y decime tu nivel de felicidad"
leo.come();
leo.mostrar();

//Le digo que juegue, como esta contenta el nivelFelicidad pasa a 73
println "Leo juga y decime tu nivel de felicidad"
leo.juga();
leo.mostrar();

//Puede jugar!
println "Che leo ¿Podes jugar?"
leo.podesJugar();

	}

}
