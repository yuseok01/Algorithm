import java.util.*;


public class Hash3 {
    static class solution{
        public int solution(String[][] clothes) {
            /**
             * 풀이법
             * 조합 2가지 * 2가지 = 4가지
             */
            int answer = 1;
            HashMap<String,Integer> hash = new HashMap<>();
            for(int i = 0 ; i < clothes.length ; i++){
                hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1],0)+1);
            }
            for(String key : hash.keySet()){
                answer *= (hash.get(key)+1);
            }
            answer -=1;

            return answer;

        }
    }
}
