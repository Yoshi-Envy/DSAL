package nodes;

public interface Vehicle {
	
	public abstract void setKey(Object key);
	
	public abstract Object getKey();
	
	public abstract Object deepCopy();
	
	public abstract int compareTo(Object targetKey);
	
}
