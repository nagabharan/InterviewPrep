package google;

/**
 * Created by nagabharan on 15-Sep-16.
 */
public class path {

    public static int solution(String s) {
        int retVal = 0;
        int numspace = 0;
        String[] l = s.split("\n");
        for (int j = l.length - 1; j >= 0; j--) {
            String i = l[j];
            if (i.contains(".jpeg") | i.contains(".gif") | i.contains(".png")) {
                numspace = i.length() - i.trim().length();
            }
            if (numspace > i.length() - i.trim().length()) {
                retVal += i.trim().length() + 1;
                numspace--;
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        String in = "dir1\n" +
                " dir11\n" +
                " dir12\n" +
                "  picture.jpeg\n" +
                "  dir 121\n" +
                "   file1.txt\n" +
                "dir2\n" +
                " file2.gif";
        System.out.println(solution(in));
    }
}
