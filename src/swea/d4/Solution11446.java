package swea.d4;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Solution11446 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input/input.txt"));

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            long maxCandy = 0;
            long[] candies = new long[n];

            for (int i = 0; i < n; i++) {
                candies[i] = Long.parseLong(st.nextToken());
                maxCandy = Math.max(candies[i], maxCandy);
            }

            // 가방 개수 이진탐색
            long left = 1;
            long right = maxCandy;
            long answer = 0;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = 0;

                for (long candy : candies) {
                    sum += candy / mid;

                    if (sum >= m) {
                        break;
                    }
                }

                if (sum >= m) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append("#").append(tc).append(" ")
                    .append(answer).append("\n");
        }

        System.out.print(sb);
    }
}