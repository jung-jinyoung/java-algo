package programmers.level2;

/*
 * 전략: 고정 길이 슬라이딩 윈도우 + HashMap
 *
 * [반복 계산 줄이기]
 * 시작 날짜마다 10일치 수량을 새로 세는 대신,
 * 첫 구간을 계산한 뒤 나가는 물건은 빼고 들어오는 물건은 더한다.
 *
 * [물건별 수량 관리]
 * HashMap으로 물건 이름을 인덱스에 연결한다.
 * count[i]에는 현재 10일 구간에서 want[i]가 할인되는 횟수를 저장한다.
 * 원하는 물건이 아닌 경우 수량 갱신에서 제외한다.
 *
 * [복잡도]
 * N: discount 길이, M: want 길이, D: 할인 기간(10일)
 *
 * 시간 O(M + D + (N - D + 1) × M)
 * - 물건 인덱스 등록: O(M)
 * - 첫 구간 수량 계산: O(D)
 * - 각 구간의 수량 갱신: 평균 O(1), 가입 가능 여부 확인: O(M)
 * - D가 고정이고 N >= D이므로 전체 O(N × M)
 * - M도 고정된 작은 상한으로 제한된다면 N에 대해 O(N)
 *
 * 추가 공간 O(M): 물건별 인덱스와 현재 구간의 수량을 저장한다.
 * HashMap 조회는 평균 O(1)을 기준으로 한다.
 */

import java.util.Map;
import java.util.HashMap;

public class Solution131127 {
    private static final int DISCOUNT_DAY = 10;

    // 현재 구간에서 모든 물건의 필요 수량을 충족하는지 확인한다.
    public boolean canSign(int[] count, int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (count[i] < number[i]) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 물건 이름으로 count 배열의 위치를 찾기 위한 매핑
        Map<String, Integer> stuff = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            stuff.put(want[i], i);
        }

        int[] count = new int[want.length];

        // 첫 10일 구간의 물건별 수량을 계산한다.
        for (int j = 0; j < DISCOUNT_DAY; j++) {
            String d = discount[j];
            if (stuff.containsKey(d)) {
                count[stuff.get(d)]++;
            }
        }

        // 이동 전 첫 구간도 정답 후보에 포함한다.
        if (canSign(count, number)) {
            answer++;
        }

        for (int k = DISCOUNT_DAY; k < discount.length; k++) {
            // 이전 구간의 맨 앞 물건을 제거한다.
            String outStuff = discount[k - DISCOUNT_DAY];
            if (stuff.containsKey(outStuff)) {
                count[stuff.get(outStuff)]--;
            }

            // 새 구간의 맨 뒤 물건을 추가한다.
            String inStuff = discount[k];
            if (stuff.containsKey(inStuff)) {
                count[stuff.get(inStuff)]++;
            }

            // 현재 구간은 [k - DISCOUNT_DAY + 1, k]이며 길이는 10이다.
            if (canSign(count, number)) {
                answer++;
            }
        }

        return answer;
    }
}
