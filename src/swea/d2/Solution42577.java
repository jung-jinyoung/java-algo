package swea.d2;
/*
 * [전략]
 * - 모든 전화번호를 HashSet에 저장한다.
 * - 각 전화번호에서 자기 자신보다 짧은 접두어를 하나씩 만든다.
 * - 해당 접두어가 HashSet에 존재하면 false를 반환한다.
 *
 * [복잡도]
 * - 시간복잡도: O(N * L)
 * - 공간복잡도: O(N)
 *   N = 전화번호 개수, L = 전화번호 최대 길이
 */


import java.util.Set;
import java.util.HashSet;

public class Solution42577 {
    public boolean solution(String[] phone_book) {
        // 전화번호 저장
        Set<String> phoneSet = new HashSet<>();

        for (String phone : phone_book) {
            phoneSet.add(phone);
        }

        // 각 전화번호의 접두어 확인
        for (String phone : phone_book) {

            // 자기 자신 전체 길이는 제외
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);

                // 접두어가 실제 전화번호로 존재하는지 확인
                if (phoneSet.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
