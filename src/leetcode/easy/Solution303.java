package leetcode.easy;

/*
 * 전략: 누적합(Prefix Sum)
 *
 * 배열이 변경되지 않고 구간 합을 여러 번 조회하므로,
 * 누적합을 한 번 계산해 저장한 뒤 각 조회를 뺄셈으로 처리한다.
 *
 * prefix[i]는 nums의 앞에서부터 i개 원소의 합이다.
 * 따라서 prefix[0] = 0이며,
 * left부터 right까지 양끝을 포함한 구간 합은
 * prefix[right + 1] - prefix[left]로 계산한다.
 *
 * 복잡도:
 * - 생성자: 시간 O(N)
 * - sumRange: 호출당 시간 O(1)
 * - Q번 조회까지 전체 시간: O(N + Q)
 * - 추가 공간: 누적합 배열 O(N)
 *
 * N: 원본 배열의 길이
 * Q: sumRange 호출 횟수
 */

class Solution303 {
    class NumArray {

        private long[] prefix;

        public NumArray(int[] nums) {
            prefix = new long[nums.length + 1];
            for (int i = 0 ; i < nums.length ; i++) {
                prefix[i+1] = prefix[i] + (long) nums[i];
            }
        }

        public int sumRange(int left, int right) {
            long answer = prefix[right+1] - prefix[left];
            return (int) answer;

        }
    }
}
