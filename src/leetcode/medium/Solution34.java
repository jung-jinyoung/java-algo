package leetcode.medium;

class Solution34 {
    // target 이상인 범위를 찾아 시작 인덱스 left를 반환하는 함수
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length ;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target을 초과하는 시작 인덱스를 찾는 함수
    public int upperBound(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length ;

        while (left < right) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        // 정답 배열 초기화
        int[] answer = new int[2];
        // 이상, 초과 시작 인덱스 찾기
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        // 시작 인덱스를 확인 : 타겟이 아니거나, 못찾았으면 [-1, -1 반환]
        if (lower == nums.length || nums[lower] != target) {
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }

        answer[0] = lower;
        answer[1] = upper - 1; // 초과 바로 앞까지가 범위이기 때문

        return answer;

    }
}
