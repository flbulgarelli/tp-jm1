
class SingletonID {

	def int id;
	private static SingletonID INSTANCE = new SingletonID();
	
	private SingletonID(){
		}
	
	public static SingletonID getInstance() {
		return INSTANCE;
	}
	def sumarId(){
		this.id++;
	}
	def private id(codigo){
		this.id=codigo;
	}
	
}
