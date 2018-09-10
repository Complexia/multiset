import java.io.PrintStream;
import java.util.Random;

public class AdditionRemovalTest {
	
	public static void main(String[]args) {
		
		//SortedLinkedListMultiset l = new SortedLinkedListMultiset();
		//LinkedListMultiset l = new LinkedListMultiset();
	    BstMultiset l = new BstMultiset();
		final PrintStream outStream = System.out;
		Random r = new Random();
		for(int i=0;i<10000;i++) {
			l.add(r.nextInt(10000));
			
		}
		long startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			int pr = r.nextInt(100);
			if(pr >= 100) {
				
				l.add(r.nextInt(10000));
			}
			else {
				l.removeOne(r.nextInt());
			}
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Program terminated in : " + totalTime);
		System.out.println("Success");
	}
}
