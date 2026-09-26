package swea.d2;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
public class Solution1989 {
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("input/1989_input.txt"));

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            String s = br.readLine();
            boolean answer = true;
            for(int i = 0 ; i < s.length()/2 ; i ++){
                if(s.charAt(i) != s.charAt(s.length()-i-1)){
                    answer = false;
                    break;
                }
            }
            if(answer){
                System.out.println("#"+test_case+" 1");
            } else {
                System.out.println("#"+test_case+" 0");
            }



        }
    }
}
