package leetcode._1_100._4;

import org.omg.CORBA.INTERNAL;

/*
4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class LC_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (n1 + n2 + 1) / 2;
        boolean odd = (n1 + n2) % 2 == 1 ? true : false;

        int start = 0;
        int end = n1;
        while (start < end) {
            int m1 = start + (end - start) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                start = m1 + 1;
            } else {
                end = m1;
            }
        }

        int m1 = start, m2 = k - start;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if (odd) {
            return c1;
        }

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) / 0.5;
    }
}
