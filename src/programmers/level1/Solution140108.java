package programmers.level1;

public class Solution140108 {
    public int solution(String s) {
        int answer = 0;

        char[] chars = s.toCharArray();
        char x = chars[0];

        int cntX = 1;
        int notX = 0;

        for (int i = 1; i < chars.length; i++) {
            // 새로운 문자열 조각 시작
            if (cntX == 0) {
                x = chars[i];
                cntX = 1;
                continue;
            }

            if (chars[i] == x) {
                cntX++;
            } else {
                notX++;
            }

            // x와 x가 아닌 문자의 수가 같으면 분리
            if (cntX == notX) {
                answer++;
                cntX = 0;
                notX = 0;
            }
        }

        // 횟수가 같아지기 전에 문자열이 끝난 경우
        if (cntX > 0) {
            answer++;
        }

        return answer;
    }
}
