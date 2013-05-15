
public class Aburrida extends Stado {
  	
	def m;
	def h;
	
	//el objeto s ahora entiende para pedirle hora, minuto, blabla del sistema
	def s = new Date();
		
	public Aburrida(Object m, Object h) {
		super();
		this.m = m;
		this.h = h;
	}

	def come(mascota){	
	
	//de 13:54 a 15:00 hay 66 minutos de diferencia
	//Si haces (15*60) - (13*60+54) = 66 Es lo que implemente
	//el error es que mi maquina la hora la expresa de 00.00 a 13 y dps de 1 a 00, no usa 14,12,16
	//entonces no diferencia pm de am y hace lo que pense obsoleto 
	// si los minutos de aburrimiento son mayores a 80
		
	if ( (this.minutosTotalTiempoActual() - this.minutosTotalInicioDeAburrimiento())>80 ){
		println "entre";
		mascota.poneteContenta();
		}
	}

	def juga(mascota){
		mascota.poneteContenta();
			
	}
	
	def minutosTotalInicioDeAburrimiento(){
		//paso todo a minutos
		def tot = h*60 + m;
	    return tot;
	}
	
	def  minutosTotalTiempoActual(){
		
	//obtengo la hora y minutos del sistema
	// uso s que entiende los mensajes minutes y hours 
		def mActual = s.minutes;
		def hActual = s.hours;
		
		
	//obtengo minutos totales
		def tActual = hActual*60 + mActual;
		return tActual;
		}
	}

	

