
public class ArrayListChungo {

	Object[] elementos= new Object[20];
	int pos = 0;
	
	public void add(Object obj){
		elementos[pos] = obj;
		pos++;
	}
	
	public Object get(int pos){
		return  elementos[pos];
	}
	
}
