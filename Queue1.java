import java.util.*;
public class Queue1 {

    /**
     * 프로그래머스 같은 의상은 싫어 문제
     * 풀이 법
     * 1. 많이 재생된 장르 먼저 수록
     * 2. 장르 내에서 가장 많이 재생된 장르
     * 3. 장르 내에서 재생횟수가 같다면 고유번호가 낮은 노래 먼저
     */
    static class solution{
        public int[] solution(int []arr) {

            Queue<Integer> q = new LinkedList<>();

            int tmp = arr[0];
            q.add(arr[0]);
            for(int i = 0 ; i < arr.length ; i++){
                if( arr[i] !=tmp){
                    q.add(arr[i]);
                    tmp =  arr[i];
                }
            }
            return q.stream().mapToInt(i->i).toArray();

        }
    }
}