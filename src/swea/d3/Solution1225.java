package swea.d3;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution1225 {
    private static final int TEST_CASE_COUNT = 10 ;
    private static final int PASSWORD_LENGTH = 8 ;

    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();


        for (int tc = 1; tc <= TEST_CASE_COUNT; tc++) {
            // 테스트 케이스 번호
            int T =  Integer.parseInt(br.readLine());

            int[] numbers = new int[PASSWORD_LENGTH];
            int min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 8개의 숫자를 확인 후 최솟값 구하기
            for (int i = 0 ; i < PASSWORD_LENGTH ; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                min = Math.min(min, numbers[i]);
            }

            int repeatCount = (min - 1 ) / 15;
            int reduction = repeatCount * 15 ;


            Deque<Integer> queue = new ArrayDeque<>();

            // 공통으로 감소시킬 수 있는 값을 먼저 차감한다.
            for (int number : numbers) {
                queue.offer(number - reduction);
            }

            int decrease = 1;

            while (true) {
                // 큐의 맨 앞 숫자를 꺼내 감소시킨다.
                int number = queue.poll() - decrease;

                // 0 이하가 되면 0으로 바꾸어 맨 뒤에 넣고 종료한다.
                if (number <= 0) {
                    queue.offer(0);
                    break;
                }

                // 아직 양수라면 맨 뒤에 다시 넣는다.
                queue.offer(number);

                // 감소량은 1 → 2 → 3 → 4 → 5 → 1 순서로 반복한다.
                decrease++;

                if (decrease > 5) {
                    decrease = 1;
                }
            }

            output.append('#')
                    .append(T);

            // 큐에 저장된 최종 암호를 앞에서부터 출력한다.
            while (!queue.isEmpty()) {
                output.append(' ')
                        .append(queue.poll());
            }

            output.append('\n');



        }

        System.out.print(output);


    }
}
