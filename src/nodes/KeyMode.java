package nodes;

public interface KeyMode { // Key Field Mode

	public abstract void setKey(Object key);

	public abstract Object getKey();

	public abstract Object deepCopy(); // shallow copy and deep copy

	public abstract int compareTo(Object targetKey);

	public abstract String toString();

}
