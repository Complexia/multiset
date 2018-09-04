import java.io.PrintStream;

public class LocalTest {
	
	public static void main(String[]args) {
	    SortedLinkedListMultiset l = new SortedLinkedListMultiset();
		//LinkedListMultiset l = new LinkedListMultiset();
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
		
		
		
//		System.out.println(l.search(B));
//		System.out.println(l.search(A));
		
		
		l.print(outStream);
		
		System.out.println(l.search(A));
		l.removeOne(E);
		
		
		
//		l.removeOne(A);
//		l.removeOne(A);
//		
		l.removeOne(A);
		
		l.print(outStream);
		
		System.out.println(l.search(A));
		
		System.out.println("Success");
	}
}
