import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {

    /**
     * 프로그래머스 기능 개발  문제
     * 풀이 법
     * 1.그냥 돌림
     * 마지막 남은 업무 처리 해야함
     */
    static class solution{
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> answer = new ArrayList<>();
            Queue<Integer> progress = new LinkedList<>();
            Queue<Integer> speed = new LinkedList<>();
            for(int i = 0 ; i < progresses.length ; i ++ ){
                progress.add(progresses[i]);
                speed.add(speeds[i]);
            }
            int cnt = 0;
            while(!progress.isEmpty()){
                if(progress.peek() >= 100){
                    cnt ++;
                    progress.poll();
                    speed.poll();
                }
                else if(cnt!= 0){
                    answer.add(cnt);
                    cnt = 0 ;
                    dayAfter(progress, speed);
                }
                else{
                    dayAfter(progress, speed);
                }
            }
            if (cnt > 0) {
                answer.add(cnt);
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
        static void dayAfter(Queue<Integer> progress, Queue<Integer> speed){
            int size = progress.size();
            for(int i = 0 ; i< size; i++) {
                int tmpP = progress.poll();
                int tmpS = speed.poll();
                progress.add(tmpP + tmpS);
                speed.add(tmpS);
            }
        }
    }
}