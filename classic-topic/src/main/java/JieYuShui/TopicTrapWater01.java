package JieYuShui;

public class TopicTrapWater01 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(arr);
        System.out.println(trap);
    }

    //双指针
    public static int trap(int[] height) {
        int trapWater = 0;
        int length = height.length;
        int max = getMax(height);
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp = 0;
            for (int j = 0; j < length; j++) {
                if (isStart && height[j] < i) {
                    temp++;
                }
                if (height[j] >= i) {
                    trapWater += temp;
                    temp = 0;
                    isStart = true;
                }
            }
        }

        return trapWater;

    }
    private static int getMax(int[] height) {
        int max = 0;
        for (int j : height) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
