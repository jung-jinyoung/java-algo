package programmers.level2;
/*
 * 전략
 *
 * 1. 모든 전화번호를 HashSet에 저장한다.
 * 2. 각 전화번호를 앞에서부터 한 글자씩 잘라 접두어를 만든다.
 * 3. 자기 자신과 동일한 전체 문자열은 검사하지 않는다.
 * 4. 생성한 접두어가 HashSet에 존재하면 다른 전화번호가
 *    해당 번호의 접두어라는 뜻이므로 false를 반환한다.
 * 5. 모든 전화번호의 접두어를 검사해도 일치하는 번호가 없으면
 *    true를 반환한다.
 *
 * 시간 복잡도: O(N * L^2)
 * - N은 전화번호의 개수이고, L은 가장 긴 전화번호의 길이이다.
 * - 전화번호마다 최대 L개의 접두어를 검사한다.
 * - substring으로 길이 i의 문자열을 만들고 해시값을 계산하는 데
 *   최대 O(L)이 필요하므로 전체 최악 시간 복잡도는 O(N * L^2)이다.
 *
 * 공간 복잡도: O(N * L)
 * - N개의 전화번호를 HashSet에 저장한다.
 * - 저장되는 모든 전화번호의 최대 문자 수는 N * L이다.
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
