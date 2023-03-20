import java.util.*;

public class Palindrome {
        public static void main(String[] st) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Expression");
        String expression = scan.nextLine();
        // CheckResult obj = CheckResult.shared.getInstance();
        CheckResult.shared.checkPalindrome(expression);
        CheckResult.shared.StrRev(expression);
scan.close();
}
}


