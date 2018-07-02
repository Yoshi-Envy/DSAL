package arrays;

public class UnsortedArrayTest {
	public static void main(String[] args) throws Exception {
		
		// Structure
		UnsortedArray unsortedArray = new UnsortedArray();
		
		System.out.println("Khởi tạo...");
		
		unsortedArray.print();
		
		unsortedArray.insert(new Node("Manh", "BN"));
		unsortedArray.insert(new Node("Tuan", "BN"));
		unsortedArray.insert(new Node("Thang", "BN"));
		unsortedArray.insert(new Node("Long", "BN"));
		unsortedArray.insert(new Node("Binh", "BN"));
		unsortedArray.insert(new Node("Nam", "BN"));
		unsortedArray.print();
		
		// fetch
		//System.out.println(unsortedArray.fetch("Long"));
		
		boolean deleted = unsortedArray.delete("Long");
		System.out.println(deleted);
		unsortedArray.print();
		
		unsortedArray.insert(new Node("Long ML", "BN"));
		unsortedArray.print();
		
	}
}
