package swea.d2;

/*
 * [전략]
 * - 0~100점의 등장 횟수를 count 배열에 저장한다. (인덱스 -> 점수 역할)
 * - 최대 등장 횟수를 구한 뒤, 100점부터 역순 탐색한다.
 * - 최대 등장 횟수와 같은 첫 점수를 출력해 동률일 경우 큰 점수를 선택하기 위함
 *
 * [복잡도]
 * - 시간복잡도: O(N)
 * - 공간복잡도: O(1)  // 점수 범위가 0~100으로 고정
 */


import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Solution1204 {
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("input/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // tc 입력 처리
            int tc = Integer.parseInt(br.readLine());
            // 0~100 인덱스 -> 점수 횟수 저장 배열 초기화
            int[] count = new int[101];
            String[] scores = br.readLine().split(" ");
            int max_cnt = 0 ;
            for(String s : scores){
                // 점수 정수형 변환 후 값 저장
                int sc = Integer.parseInt(s);
                count[sc]++;
                // 최댓값 갱신
                if(max_cnt < count[sc]){
                    max_cnt = count[sc];
                }
            }

            // 내림차순으로 Max_cnt 조회 (동일할 경우 점수가 큰 값이 정답이기 대문)
            for(int i = 100 ; i >= 0 ; i--){
                if(count[i] == max_cnt){
                    // 최빈수일경우 해당 인덱스 == 점수 출력
                    System.out.println("#"+tc+" "+i);
                    break;
                }
            }
        }
    }
}
