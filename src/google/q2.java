package google;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class q2 {
    public static int solution(String s) {
        String[] lines = s.split("\n");
        int spaces = 0;
        int sum = 0;
        for (int j = lines.length - 1; j >= 0; j--) {
            if (lines[j].contains(".jpeg") | lines[j].contains(".gif") | lines[j].contains(".png")) {
                spaces = lines[j].length() - lines[j].trim().length();
            }
            if (spaces >= (lines[j].length() - lines[j].trim().length())) {
                sum += lines[j].trim().length() + 1;
                spaces--;
            }
        }
        return sum % 1000000007;
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
