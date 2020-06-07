package leetcode._1_100._42;
/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class LC_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxIndex = 0;
        int maxHeight = height[0];
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int area = 0;
        int leftMax = height[0];
        for (int i = 0; i < maxIndex; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            } else {
                area += leftMax - height[i];
            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (rightMax < height[i]) {
                rightMax = height[i];
            } else {
                area += rightMax - height[i];
            }
        }

        return area;
    }
}
