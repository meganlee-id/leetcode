import java.util.Arrays;

public class UniquePath {

    //------------ Solution 1: Pure Recursion ---------------//
    // Pure Recursion (exceed time limit)
    public int uniquePaths(int m, int n) {
        // base cases
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        
        // general cases
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    //--------- Solution 2: Top-down Recursion Cache ----------//
    // Recursion with cache
    public int uniquePaths2(int m, int n) {
        // create a table for cache repeated used value
        int[][] cache = new int[m + 1][n + 1];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);   // -1 means unlabeled
        }
        return helper(m, n, cache);
     }
    
    public int helper(int m, int n, int[][] table) {
        // base cases
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        
        // general cases
        if (table[m][n] == -1){
            table[m][n] = helper(m - 1, n, table) + helper(m, n - 1, table);
        }

        return table[m][n];
    }
    

    //------------ Solution 3: Bottom-up DP solution ---------------//
    // m X n space
    public int uniquePaths3(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // create a table for storing intermediate results
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    
    
    //------------ Solution 4: Bottom-up DP solution ---------------//
    // memory saving
    public int uniquePaths4(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // initial row
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }
    
    //------------ Solution 5: Combination Formula -----------------//
    public int uniquePaths5(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        // calculate C(m+n-2, n-1)
        int denominator = 1, numerator = 1;
        for (int i = n - 1; i >= 1; i--) {
            numerator *= (m - 1) + i;
            denominator *= i;
            int factor = gcd(numerator, denominator);
            denominator /= factor;
            numerator /= factor;
        }
        return numerator / denominator;
    }

    // call gcd(Math.max(a, b), Math.min(a, b))
    // a >= b && a > 0 && b > 0
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    
    /////////////// TEST /////////////////////////
    public static void main(String[] args) {
        UniquePath up = new UniquePath();
        System.out.println(up.gcd(0, 0));
        System.out.println(up.gcd(1, 0));
        System.out.println(up.gcd(12, 8));
        System.out.println((new UniquePath()).uniquePaths4(23, 12));
    }
}



