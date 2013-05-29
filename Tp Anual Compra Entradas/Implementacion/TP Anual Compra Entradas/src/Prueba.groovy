
class Prueba {
		public static void main(String[] args) {
		
		def sing;
		sing=SingletonID.getInstance();
		sing.id(1);
		def fila1Sector4 = new Ubicacion(10,250);
		
		def espectaculo1 = new Categoria1();	
		def espectaculo2= new Categoria2();
		def espectaculo3= new Categoria3();
		
		def entrada= new Entrada(espectaculo1, fila1Sector4);	
		def entrada2 = new Entrada(espectaculo2,fila1Sector4);
		def entrada3 = new Entrada(espectaculo2,fila1Sector4);
		
		def entrada4 = new Entrada(espectaculo3, fila1Sector4);
		def entrada5 = new Entrada(espectaculo3, fila1Sector4);
		def entrada6 = new Entrada(espectaculo3, fila1Sector4);
		
		
		def mayor= new Tipo();
		def jubilada= new Jubilado();
		def menor= new MenorEdad();
				
		// asserts juan
		
		def juan = new Persona(mayor,1000);
		juan.compraEntrada(entrada);
			
		def costo = entrada.getCosto(mayor);
		def saldo = juan.getSaldo();
		def dispon = fila1Sector4.disponibilidad; 
		def cantEntradas= juan.entradas.size();
		def id1= entrada.id;
		
		println "El costo de entrada es: $costo.";
		println "El saldo de juan es: $saldo.";
		println "La disponibilidad de fila1Sector4 es: $dispon.";
		println "La cantidad de entradas de juan es: $cantEntradas.";
		println "El id de entrada es: $id1.";
		
		println " "
 		println "-------Soy una barra Separadora-------"
		println " "
		
		//asserts caro
				
		def caro= new Persona(jubilada,600);
		caro.compraEntrada(entrada2);
		caro.compraEntrada(entrada3);
		
		def costo2= entrada2.getCosto(jubilada);
		def saldo2= caro.getSaldo();
		def dispon2= fila1Sector4.disponibilidad;
		def cantEntradas2= caro.entradas.size();
		def id2= entrada2.id;
		
		println "El costo de entrada2 es: $costo2.";
		println "El saldo de caro es: $saldo2.";
		println "La disponibilidad de fila1Sector4 es: $dispon2.";
		println "La cantidad de entradas de caro es: $cantEntradas2.";
		println "El id de entrada2 es: $id2.";
		
		println " "
		println "-------Soy una barra Separadora-------"
		println " "
		
		//asserts jonhy
		
		def jonhy= new Persona(menor, 3000);
		jonhy.compraEntrada(entrada4);
		jonhy.compraEntrada(entrada5);
		jonhy.compraEntrada(entrada6);
		
		def costo4= entrada4.getCosto(jubilada);
		def saldo4= jonhy.getSaldo();
		def dispon4= fila1Sector4.disponibilidad;
		def cantEntradas4= jonhy.entradas.size();
		def id4= entrada4.id;
		
		
		println "El costo de entrada2 es: $costo4.";
		println "El saldo de caro es: $saldo4.";
		println "La disponibilidad de fila1Sector4 es: $dispon4.";
		println "La cantidad de entradas de jonhy es: $cantEntradas4.";
		println "El id de entrada4 es: $id4.";
		
		
		println " "
		println "-------Soy una barra Separadora-------"
		println " "
		
		// asserts yami
		def yami = new Persona(menor,15);
		yami.compraEntrada(entrada);
		
		}			
}
