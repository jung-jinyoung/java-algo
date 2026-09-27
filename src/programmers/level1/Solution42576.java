package programmers.level1;

/*
 * [전략]
 * - 참가자 이름을 key, 참가 횟수를 value로 HashMap에 저장한다.
 * - 완주자 목록을 순회하며 해당 이름의 횟수를 1씩 감소시킨다.
 * - 최종적으로 값이 0보다 큰 참가자가 완주하지 못한 참가자이다.
 *
 * [복잡도]
 * - 시간복잡도: O(N)
 * - 공간복잡도: O(N)
 *   N = 참가자 수
 */

import java.util.Map;
import java.util.HashMap;

public class Solution42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참가자 정보 저장 해시맵 초기화
        // key -> 참가자 이름
        // value -> 정수 (동명이인 처리 위함)
        Map<String, Integer> participants = new HashMap<>();

        // 참가자 정보 저장
        for(String p : participant){
            // 동명이인이 없으면 0, 있으면 해당 등록 횟수 가져오기
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }
        // 완주한 참가자 처리
        for (String c : completion){
            participants.put(c, participants.get(c) -1);
        }
        // 0이 아닌 참가자일 경우 완주하지 못한 참가자 -> answer 처리
        for (String p : participant){
            if(participants.get(p) > 0){
                answer = p;
                break;
            }
        }
        return answer;
    }
}
