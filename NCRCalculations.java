public class NCRCalculations{

    public static long calculateNCR(int n, int r) {
        if (r > n) {
            throw new IllegalArgumentException("R cannot be greater than N");
        }

        // NCR = N * (N-1) * ... * (N-R+1) / R!
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1); // Dividing progressively avoids large intermediate values
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int r = 2;

        long ncr = calculateNCR(n, r);
        System.out.println("NCR (" + n + " choose " + r + ") = " + ncr);
    }
}
