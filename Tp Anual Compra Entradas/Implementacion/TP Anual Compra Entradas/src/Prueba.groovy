
class Prueba {
		public static void main(String[] args) {
		
		def fila1Sector4 = new Ubicacion(10,250);
		
		def espectaculo1 = new Categoria1();	
		def espectaculo2= new Categoria2();
		def espectaculo3= new Categoria3();
		
		def entrada= new Entrada(espectaculo1, fila1Sector4);	
		def entrada2 = new Entrada(espectaculo2,fila1Sector4);
		def entrada3 = new Entrada(espectaculo3, fila1Sector4);
		
		def mayor= new Mayor();
		def jubilada= new Jubilado();
		def menor= new MenorEdad();
				
		// asserts juan
		
		def juan = new Persona(mayor,1000);
		juan.compraEntrada(entrada);
			
		def costo = entrada.getCosto(mayor);
		def saldo = juan.getSaldo();
		def dispon = fila1Sector4.disponibilidad; 
		def cantEntradas= juan.entradas.size();
		
		
		println "El costo de entrada es: $costo.";
		println "El saldo de juan es: $saldo.";
		println "La disponibilidad de fila1Sector4 es: $dispon.";
		println "La cantidad de entradas de juan es: $cantEntradas.";
		
		println " "
 		println "-------Soy una barra Separadora-------"
		println " "
		
		//asserts caro
				
		def caro= new Persona(jubilada,600);
		caro.compraEntrada(entrada2);
		caro.compraEntrada(entrada2);
		
		def costo2= entrada2.getCosto(jubilada);
		def saldo2= caro.getSaldo();
		def dispon2= fila1Sector4.disponibilidad;
		def cantEntradas2= caro.entradas.size();
		
		println "El costo de entrada2 es: $costo2.";
		println "El saldo de caro es: $saldo2.";
		println "La disponibilidad de fila1Sector4 es: $dispon2.";
		println "La cantidad de entradas de caro es: $cantEntradas2.";
		
		println " "
		println "-------Soy una barra Separadora-------"
		println " "
		
		//asserts jonhy
		
		def jonhy= new Persona(menor, 3000);
		jonhy.compraEntrada(entrada3);
		jonhy.compraEntrada(entrada3);
		jonhy.compraEntrada(entrada3);
		
		def costo3= entrada3.getCosto(jubilada);
		def saldo3= jonhy.getSaldo();
		def dispon3= fila1Sector4.disponibilidad;
		def cantEntradas3= jonhy.entradas.size();
		
		println "El costo de entrada2 es: $costo3.";
		println "El saldo de caro es: $saldo3.";
		println "La disponibilidad de fila1Sector4 es: $dispon3.";
		println "La cantidad de entradas de caro es: $cantEntradas3.";
		
		println " "
		println "-------Soy una barra Separadora-------"
		println " "
		
		// asserts yami
		def yami = new Persona(menor,15);
		yami.compraEntrada(entrada);
		
		}			
}
