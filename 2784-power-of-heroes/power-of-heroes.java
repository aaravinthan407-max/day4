class Solution {
    private int mod = (int)1e9 + 7;

    private int power(int x, int n) {
        long result = 1;
        while (n-- != 0) {
            result = (result * x) % mod;
        }
        return (int)result;
    }

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long result = power(nums[n - 1], 3), factor = 0; // factor is f(i)
        for (int i = n - 2; i >= 0; i--) {
            factor = (2 * factor + power(nums[i + 1], 2)) % mod; // f(i) = x[i + 1]^2 + 2f(i + 1)
            result = (result + power(nums[i], 3) + (nums[i] * factor) % mod) % mod; // x[i]^3 + x[i].f(i)
        }
        return (int)result;
    }
}