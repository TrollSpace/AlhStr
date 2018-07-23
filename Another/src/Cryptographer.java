import java.util.Scanner;

/**
 * Created by Misha on 20.07.2018.
 */
public class Cryptographer {
    private String s;
    private Stack stack;

    public void printStackToString(Stack stack) {
        while (stack.isEmpty()) {
            System.out.print(stack.pop());

        }
        System.out.println();
    }

    public Stack initializeStack() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        this.stack = new StackImpl(s.length());
        for (int i = 0; i < s.length(); i++) {
            this.stack.push(s.charAt(i));
        }
        return this.stack;
    }

}
