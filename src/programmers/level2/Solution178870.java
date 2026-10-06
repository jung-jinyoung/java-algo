package programmers.level2;

/*
 * 전략: 투포인터 (가변 길이 슬라이딩 윈도우)
 *
 * [기존 풀이의 문제]
 * 시작점마다 합을 다시 계산하는 이중 반복문은 O(N²)이다.
 * 겹치는 구간을 반복 계산해 큰 입력에서 시간초과가 발생했다.
 *
 * [개선 방법]
 * 현재 구간의 합을 유지하며, 들어오는 값은 더하고 나가는 값은 뺀다.
 * 누적합처럼 계산 결과를 재사용하되, 별도 배열 없이 현재 합만 관리한다.
 *
 * 모든 원소가 양수이므로 다음 규칙으로 탐색할 수 있다.
 * - right 이동: 원소를 추가해 합을 늘린다.
 * - 합 > k: left를 이동해 합을 줄인다.
 * - 합 == k: 더 짧은 구간이면 정답을 갱신한다.
 *
 * 같은 길이에서는 갱신하지 않아 먼저 찾은 앞쪽 구간을 유지한다.
 *
 * [복잡도]
 * 시간 O(N): 두 포인터가 앞으로만 이동하며 각각 최대 N번 움직인다.
 * 공간 O(1): 현재 합, 인덱스, 정답만 저장한다.
 */


public class Solution178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        // 구간 길이는 배열 길이 이하이므로 int로 관리한다.
        long minLen = Integer.MAX_VALUE;
        long sum = 0 ;
        int left = 0;
        int n = sequence.length;

        for (int right = 0 ; right < n ; right++) {
            // 오른쪽 원소를 추가해 구간을 확장한다.
            sum += sequence[right];

            // 한 번 제거해도 합이 k보다 클 수 있으므로 while로 줄인다.
            while (sum > k) {
                sum -= sequence[left];
                left ++;
            }

            // 이 시점의 sum은 [left, right] 구간의 합이다.
            // left가 right + 1이면 빈 구간이며 sum은 0이다.
            if (sum == k){
                int l = right - left + 1;
                // left는 감소하지 않으므로 앞쪽 구간부터 발견한다.
                // 길이가 같으면 갱신하지 않아 시작 인덱스가 작은 답을 유지한다.
                if (l < minLen) {
                    minLen = l ;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}
