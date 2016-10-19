package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _223RectArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A)
            return (G - E) * (H - F) + (C - A) * (D - B);
        if (D < F || H < B)
            return (G - E) * (H - F) + (C - A) * (D - B);

        int r = Math.min(C, G);
        int l = Math.max(A, E);
        int t = Math.min(D, H);
        int b = Math.max(F, B);

        return (G - E) * (H - F) + (C - A) * (D - B) - (r - l) * (t - b);
    }
}
