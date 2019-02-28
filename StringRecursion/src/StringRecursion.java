
public class StringRecursion {
	public static void main(String[] args) {
		System.out.println("Code Testing for Problem 1:  ");
		System.out.println("\"\" --> \"" + removeE("") + "\"");
		System.out.println("\"abc\" --> \"" + removeE("abc") + "\"");
		System.out.println("\"abcdefg\" --> \"" + removeE("abcdefg") + "\"");
		System.out.println("\"eeeeeeee\" --> \"" + removeE("eeeeeeee") + "\"");
		System.out.println("\"whenever, wherever, we're meant to be together\" --> \"" + removeE("whenever, wherever, we're meant to be together") + "\"");
		System.out.println();
		
		System.out.println("Code Testing for Problem 2");
		System.out.println("\"\" --> \"" + hiToHello("") + "\"");
		System.out.println("\"abc\" --> \"" + hiToHello("abc") + "\"");
		System.out.println("\"hi\" --> \"" + hiToHello("hi") + "\"");
		System.out.println("\"hit\" --> \"" + hiToHello("hit") + "\"");
		System.out.println("\"hihihi\" --> \"" + hiToHello("hihihi") + "\"");
		System.out.println("\"this is whispering\" --> \"" + hiToHello("this is whispering") + "\"");
		System.out.println();
		
		System.out.println("Code Testing for Problem 3");
		System.out.println("\"\" --> " + countS("") + "");
		System.out.println("\"abc\" --> " + countS("abc") + "");
		System.out.println("\"rst\" --> " + countS("rst") + "");
		System.out.println("\"somebody, stop me\" --> " + countS("somebody, stop me") + "");
		System.out.println("\"Mississippi\" --> " + countS("Mississippi") + "");
		System.out.println();

	}
	public static String removeE (String a) {
		if (a.equals("")) {
			return a;
		}
		else if (a.substring(0,1).equals("e"))
			return removeE(a.substring(1));
		else
			return a.substring(0, 1) + removeE(a.substring(1));
	}
	public static String hiToHello(String a) {
		if(a.length() <= 1)
			return a;
		else if(a.substring(0, 2).equals("hi"))
			return "hello" + hiToHello(a.substring(2));
		else if(a.substring(1, 2).equals("h")) {
			return a.substring(0, 1)  + hiToHello(a.substring(1));
		}
		else
			return a.substring(0, 2) + hiToHello(a.substring(2));
	}
	public static int countS(String a) {
		if(a.equals("")){
			return 0;
		}
		else if (a.substring(0, 1).equals("s")){
			return 1 + countS(a.substring(1));
		}
		else {
			return 0 + countS(a.substring(1));
		}
	}
}

