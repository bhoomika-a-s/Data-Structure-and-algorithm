
public class CheckResult {                                     //singleton class:single object
    static CheckResult shared = new CheckResult( );
    public boolean checkPalindrome(String word) {
            StringBuilder reverseString = new StringBuilder(word);
            return( reverseString.reverse().toString() == word);
    }

    public String StrRev(String word) {
     StringBuilder reverseString = new StringBuilder(word); 
        return reverseString.toString();
    }
    public static CheckResult getInstance() { 
            return shared;
    }
}