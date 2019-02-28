import java.util.Stack;

public class Main {
	public static void main (String[] args) {
		Stack<String> stack = new Stack<String>();
		String x = ";lakjsf;lkajsf";
		for(int i = 0; i < x.length(); i++) {
			stack.add(x.substring(i, i+1));
		}
		while(stack.size() > 0) {
			System.out.print(stack.pop());
		}
	}
}
