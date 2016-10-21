package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class RightRotation {
    public static int rightRotate(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0 || word1.length() != word2.length()) {
            return -1;
        }
        String str = word1 + word1;
        return str.indexOf(word2) != -1 ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(rightRotate("abc", "cab"));
    }
}
