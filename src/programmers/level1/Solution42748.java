package programmers.level1;

/*
 * [풀이 전략]
 * 각 command는 [i, j, k] 형태로 주어진다.
 *
 * 1. Arrays.copyOfRange()를 사용해 array의 i번째부터 j번째까지 잘라
 *    새로운 배열을 만든다.
 *    - 배열의 인덱스는 0부터 시작하므로 시작 위치는 i - 1
 *    - copyOfRange의 끝 인덱스는 포함하지 않으므로 j를 그대로 사용
 *
 * 2. 잘라낸 배열을 Arrays.sort()로 오름차순 정렬한다.
 *
 * 3. 정렬된 배열의 k번째 값을 answer에 저장한다.
 *    - 배열의 인덱스는 0부터 시작하므로 k - 1 위치에 접근한다.
 *
 * 위 과정을 모든 command에 대해 반복한다.
 *
 * [시간복잡도]
 * commands의 개수를 M, 각 command에서 잘라낸 배열의 최대 길이를 N이라고 하면
 *
 * - 배열 복사: O(N)
 * - 배열 정렬: O(N log N)
 * - k번째 값 조회: O(1)
 *
 * 하나의 command를 처리하는 비용은 O(N log N)이고,
 * 이를 M번 반복하므로 전체 시간복잡도는 O(M * N log N)이다.
 *
 * [공간복잡도]
 * 각 command마다 최대 N개의 원소를 가지는 sliced 배열을 생성하므로
 * 추가 공간복잡도는 O(N)이다.
 *
 * 반환값인 answer 배열까지 포함하면 O(N + M)이다.
 */


import java.util.Arrays;

public class Solution42748 {
    public int[] solution(int[] array, int[][] commands) {
        // 정답 개수
        int n = commands.length;
        int[] answer = new int[n]; // 정답 개수 만큼 길이 초기화
        for (int i = 0 ; i < n ; i++) {
            int[] command = commands[i];
            // copyOfRange(arr, s, t) -> s ~ t-1 까지 슬라이싱하여 새로운 배열 반환
            int[] sliced = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            // 슬라이싱한 배열 오름차순 정렬
            Arrays.sort(sliced);
            // k번째 수 정답에 반영
            answer[i] = sliced[command[2]-1];
        }

        return answer;
    }
}

