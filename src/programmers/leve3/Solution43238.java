package programmers.leve3;

/*
 * 풀이 전략
 * - 모든 사람의 심사를 끝낼 수 있는 최소 시간을 이진탐색한다.
 * - times를 정렬하고, 가장 빠른 심사관 혼자 n명을 처리하는 시간을
 *   탐색 범위의 상한으로 설정한다.
 * - 후보 시간 mid에서 처리 가능한 인원은
 *   각 심사관의 (mid / time)을 합산하여 계산한다.
 * - 처리 가능한 인원이 n 이상이면 정답 후보로 저장하고
 *   더 짧은 시간을 탐색한다. 부족하면 더 긴 시간을 탐색한다.
 * - 시간이 늘수록 처리 가능한 인원은 줄어들지 않으므로
 *   이진탐색으로 첫 번째 가능한 시간을 찾을 수 있다.
 *
 * 내가 놓쳤던 부분
 * - long right = times[0] * n으로 작성하면 두 피연산자가 int이므로
 *   곱셈이 int로 먼저 수행되어 오버플로가 발생할 수 있다.
 * - 결과를 long 변수에 저장해도 이미 발생한 오버플로는 복구되지 않는다.
 * - (long) times[0] * n처럼 곱셈 전에 형변환해야 한다.
 * - 시간과 누적 인원은 값이 커질 수 있으므로 long을 사용한다.
 *
 * 복잡도
 * - K: 심사관 수, T: 탐색 상한인 (가장 빠른 심사 시간 × n)
 * - 시간 복잡도: O(K log K + K log T)
 *   정렬에 O(K log K), 이진탐색은 O(log T)번 반복하며
 *   각 반복에서 최대 K명의 심사관을 확인한다.
 * - 탐색 자체의 추가 공간 복잡도: O(1)
 *   일정한 개수의 변수만 사용한다.
 *   Arrays.sort(int[])의 내부 정렬 공간은 별도로 고려한다.
 */

import java.util.Arrays;

public class Solution43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;

        // 시간 이진 탐색
        long left = 0 ;
        long right = (long) times[0] * n ; // 가장 빠른 심사관의 소요 시간
        answer = right ;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            // 현재 mid 시간 기준으로 가능한 인원수 확인
            long count = 0 ;
            for (int time : times) {
                count += mid / time;

                // 이미 입국 심사가 가능하다면 ?
                if (count >= n) {
                    break;
                }
            }
            if (count >= n) {
                // mid 시간으로 가능하다면
                answer = mid ;
                right = mid - 1; // 더 빠른 시간 탐색
            } else {
                // 불가능할 경우 더 긴 시간 탐색
                left = mid + 1;
            }
        }
        return answer;
    }
}
