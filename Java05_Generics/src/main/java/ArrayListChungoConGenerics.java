
public class ArrayListChungoConGenerics<E> {

	Object[] elementos = new Object[20];
	int pos = 0;
	
	public void add(E obj){
		elementos[pos] = obj;
		pos++;
	}
	
	public E get(int pos){
		return (E) elementos[pos];
	}
	
}
