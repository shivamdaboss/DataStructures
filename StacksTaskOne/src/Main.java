import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		int number = 50;
		Stack<Integer> stack = new Stack<Integer>();
		while(number != 0) {
			stack.add(number%2);
			number = number/2;
		}
		while(stack.size() > 0) {
			System.out.print(stack.pop());
		}
	}

	
}
