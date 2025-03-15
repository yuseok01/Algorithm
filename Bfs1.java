import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs1 {
    static boolean visited[];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int n = Integer.parseInt(br.readLine().trim());
        int [][] computers = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < n; j++){
                computers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    solution(n,computers);



    }

    private static void solution(int n, int[][] computers) {
        int result = 0 ;
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                result++;
                bfs(0, n, computers);
            }
        }
        System.out.println(result);

    }

    private static void bfs(int depth, int n, int[][] computers) {
        queue.add(depth);
        visited[depth] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && computers[cur][j] == 1){
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
