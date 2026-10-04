package swea.d3;

/*
 * [풀이 전략]
 * 각 dump에서 필요한 정보는 현재 최소 높이와 최대 높이뿐이므로,
 * 매번 전체 배열을 정렬하지 않고 높이별 상자 개수를 카운팅 배열로 관리한다.
 *
 * heights[h] = 높이가 h인 상자의 개수
 *
 * 한 번의 dump마다 최대 높이의 상자 하나를 낮추고,
 * 최소 높이의 상자 하나를 높인 뒤 최소/최대 높이를 갱신한다.
 *
 * [시간복잡도]
 * 상자 개수를 N, dump 횟수를 D라고 하면
 * - 초기 높이 정보 구성: O(N)
 * - dump 수행: O(D)
 *
 * 따라서 전체 시간복잡도는 O(N + D),
 * 높이 범위가 1~100으로 고정되어 있으므로 추가 공간복잡도는 O(1)이다.
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1208 {

    // 테스트 케이스 10개 고정
    private static final int TEST_CASE = 10;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("input/input.txt"));

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TEST_CASE; tc++) {

            // 덤프 횟수 입력
            int dumps = Integer.parseInt(br.readLine());

            // heights[h] = 높이가 h인 상자의 개수
            int[] heights = new int[101];

            // 현재 최대/최소 높이
            int maxHeight = 0;
            int minHeight = Integer.MAX_VALUE;

            // 상자 높이 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                int h = Integer.parseInt(st.nextToken());

                heights[h]++;

                maxHeight = Math.max(maxHeight, h);
                minHeight = Math.min(minHeight, h);
            }

            // 주어진 dump 횟수만큼 평탄화 진행
            for (int d = 0; d < dumps; d++) {

                // 최대 높이와 최소 높이의 차이가 1 이하라면
                // 더 이상 평탄화할 필요가 없음
                if (maxHeight - minHeight <= 1) {
                    break;
                }

                // 가장 높은 상자 하나를 한 칸 아래로 이동
                heights[maxHeight]--;
                heights[maxHeight - 1]++;

                // 가장 낮은 상자 하나를 한 칸 위로 이동
                heights[minHeight]--;
                heights[minHeight + 1]++;

                // 기존 최대 높이의 상자가 더 이상 없다면
                // 최대 높이를 한 단계 낮춤
                if (heights[maxHeight] == 0) {
                    maxHeight--;
                }

                // 기존 최소 높이의 상자가 더 이상 없다면
                // 최소 높이를 한 단계 높임
                if (heights[minHeight] == 0) {
                    minHeight++;
                }
            }

            int answer = maxHeight - minHeight;

            // 출력 형식 : #테스트케이스 정답
            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(answer)
                    .append("\n");
        }

        System.out.print(sb);
    }
}