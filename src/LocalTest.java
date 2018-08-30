import java.io.PrintStream;

public class LocalTest {
	
	public static void main(String[]args) {
		SortedLinkedListMultiset l = new SortedLinkedListMultiset();
		final PrintStream outStream = System.out;
		
		String A = "hello";
		String B = "world";
		String C = "Mes";
		String D = "dd";
		String E = "aa";
		
		
		
		l.add(A);
		l.add(B);
		l.add(C);
		l.add(D);
		l.add(E);
		l.add(A);
		l.add(A);
		
		
		
		
		
		
		
		
		
		System.out.println("Success");
	}
}
