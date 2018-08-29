import java.io.PrintStream;

public class LocalTest {
	
	public static void main(String[]args) {
		LinkedListMultiset l = new LinkedListMultiset();
		final PrintStream outStream = System.out;
		
		String A = "hello";
		String B = "world";
		String C = "Yes";
		
		l.add(A);
		l.add(B);
		l.add(C);
		l.add(A);
		l.add(A);
		
		
		
		System.out.println(l.search(A));
		
		
		l.print(outStream);
		
		System.out.println(l.search(A));
		System.out.println("Success");
	}
}
