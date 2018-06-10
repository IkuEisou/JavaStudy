package inheritan;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human kid = new Kids();
		Human ad = new Adult();
		
		HumanIF humanIF = new PrintKids();
		humanIF.printInfo(kid);
		
		 humanIF = new PrintAdult();
		humanIF.printInfo(ad);
	}

}
