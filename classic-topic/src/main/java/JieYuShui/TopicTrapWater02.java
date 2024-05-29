package JieYuShui;

public class TopicTrapWater02 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(arr);
        System.out.println(trap);

    }

    //DP解法
    public static int trap(int[] height) {

        int l = height.length;
        if (l == 0) {
            return 0;
        }
        int[] leftMax = new int[l];
        leftMax[0] = height[0];
        for (int i = 1; i < l; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[l];
        rightMax[l - 1] = height[l - 1];
        for (int i = l-2; i >=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trapWater = 0;

        for (int i = 0; i < l; i++) {
            trapWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trapWater;
    }
}
