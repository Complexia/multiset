
public class LocalTest {
	
	public static void main(String[]args) {
		LinkedListMultiset l = new LinkedListMultiset();
		
		String A = "hello";
		String B = "world";
		String C = "Yes";
		
		l.add(A);
		l.add(B);
		l.add(C);
		l.add(A);
		l.add(A);
		
		
		System.out.println(l.search(A));
		
		
		System.out.println("Success");
	}
}
