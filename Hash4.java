import java.util.*;
public class Hash4 {

    /**
     * 프로그래머스 의상 문제
     * 풀이 법
     * 1. 많이 재생된 장르 먼저 수록
     * 2. 장르 내에서 가장 많이 재생된 장르
     * 3. 장르 내에서 재생횟수가 같다면 고유번호가 낮은 노래 먼저
     */
    static class solution{
        public int[] solution(String[] genres, int[] plays) {
            ArrayList<Integer> answer = new ArrayList<>();
            HashMap <String , Integer> count = new HashMap<>();
            //장르, 재생횟수
            HashMap <String , HashMap<Integer,Integer>> repository = new HashMap<>();
            //장르, <고유번호 , 재생횟수>

            for(int i = 0 ; i < genres.length ; i++){
                if(!count.containsKey(genres[i])){//처음 들어온 장르라면
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(i,plays[i]);
                    repository.put(genres[i], map); //장르,<0번째,몇번>
                    count.put(genres[i],plays[i]); // 장르, 몇번
                }
                else{//있는 장르라면
                    repository.get(genres[i]).put(i,plays[i]); //장르 이름에 또 넣기
                    count.put(genres[i],count.get(genres[i])+plays[i]);//누적합해주기
                }
            }
            List<String> keySet = new ArrayList(count.keySet()); //key 다넣기 list에
            Collections.sort(keySet,(s1,s2) -> count.get(s2) - (count.get(s1)));
            //plays가 많은 것부터 앞으로  양수가 되게끔 처리

            for(String key : keySet) { //play수가 많은 장르 부터 처리
                HashMap<Integer, Integer> map = repository.get(key); //고유번호,재생횟수
                List<Integer> genre_key = new ArrayList<>(map.keySet()); //모든 고유번호

                Collections.sort(genre_key ,(s1,s2) -> map.get(s2)- (map.get(s1)));
                //재생횟수 많은것 부터
                answer.add(genre_key.get(0)); //고유번호 넣기
                if(genre_key.size() >1)
                    answer.add(genre_key.get(1));

            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
