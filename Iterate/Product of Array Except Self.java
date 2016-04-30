public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        for (int i = 0, product = 1; i < nums.length; i++) {
            products[i] = product;
            product *= nums[i];
        }
        for (int i = nums.length - 1, product = 1; i >= 0; i--) {
            products[i] *= product;
            product *= nums[i];
        }
        return products;
    }
}
