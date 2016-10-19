package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _204CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++)
            prime[i] = true;
        for (int i = 2; i <= n - 1; i++)
            if (prime[i])
                for (int j = i * i; j < n; j += i)
                    prime[j] = false;
        int c = 0;
        for (int i = 2; i < n; i++)
            if (prime[i])
                c++;
        return c;
    }
}
