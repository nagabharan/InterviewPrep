package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class RemoveVowel {
    public static String removeVowel(String s) {
        StringBuffer sb = new StringBuffer();
        String v = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (v.indexOf(s.charAt(i)) > -1) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowel("hello"));
        System.out.println(removeVowel("oo"));
    }
}
