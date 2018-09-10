import java.io.PrintStream;
import java.util.Random;

public class LocalTest {
	
	public static void main(String[]args) {
	    //SortedLinkedListMultiset l = new SortedLinkedListMultiset();
		//LinkedListMultiset l = new LinkedListMultiset();
	    BstMultiset l = new BstMultiset();
		final PrintStream outStream = System.out;
		
		String A = "hello";
		String B = "world";
		String C = "Mes";
		String D = "dd";
		String E = "aa";
		String F = "ee";
		String G = "jj";
		String H = "zz";
		String I = "oo";
		Random r = new Random();
		for(int i=0;i<10000000;i++) {
			l.add(Integer.toString(r.nextInt(10000)));
			
		}
		
		l.add(A);
		l.add(B);
		l.add(C);
		l.add(D);
		l.add(E);
		l.add(A);
		l.add(A);
		l.add(F);
		l.add(G);
		l.add(H);
		l.add("99999999");
		
//		l.removeOne(A);
//		System.out.println(l.search(A));
//		System.out.println(l.search(B));
//		System.out.println(l.search(C));
//		System.out.println(l.search(D));
//		System.out.println(l.search(E));
//		System.out.println(l.search(F));
//		System.out.println(l.search(G));
//		System.out.println(l.search(H));
//		System.out.println(l.search(I));
		l.print(outStream);
		System.out.println("Success");
	}
}
