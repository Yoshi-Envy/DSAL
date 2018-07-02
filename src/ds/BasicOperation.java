package ds;

public interface BasicOperation<T> { 

	public abstract boolean insert(T node);

	public abstract boolean update(String targetKey, T node);

	public abstract boolean delete(String targetKey);

	public abstract T fetch(String targetKey);
	
	public abstract void display();
	
}
