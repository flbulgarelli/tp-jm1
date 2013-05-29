@Singleton
class SingletonID {

	def int id;
	private static SingletonID INSTANCE = new SingletonID();
	
	private SingletonID(){
		}
	
	public static SingletonID getInstance() {
		return INSTANCE;
	}
	def incrementarId(){
		this.id++;
	}
	def private id(codigo){
		this.id=codigo;
	}
	
}
