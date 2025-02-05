/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.matrix;

public class KthSmallestInMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // Binary search on the range of elements
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessEqual(mid, matrix, n) < k) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid; // Target is in the left half
            }
        }

        return left;
    }

    // Helper function to count elements <= mid
    static int countLessEqual(int mid, int[][] matrix, int n) {
        int count = 0, j = n - 1; // Start from the top-right corner
        for (int i = 0; i < n; i++) {
            while (j >= 0 && matrix[i][j] > mid) {
                j--; // Move left
            }
            count += (j + 1);
        }
        return count;
    }

    // Test case
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8; // Find the 8th smallest element
        System.out.println("The " + k + "th smallest element is: " + findKthSmallest(matrix, k));
    }
}
