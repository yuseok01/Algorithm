import java.io.*;
import java.util.*;

public class Dfs2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: numbers 배열 입력 받기
        int[] numbers = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        // 두 번째 줄: target 값 입력 받기
        int target = Integer.parseInt(br.readLine());

        // Solution 클래스 인스턴스 생성 후 실행
        Solution sol = new Solution();
        int result = sol.solution(numbers, target);

        // 결과 출력
        System.out.println(result);
    }
}

// Solution 클래스 (Dfs2 내부에서 작동 가능)
class Solution {
    static int count;

    public int solution(int[] numbers, int target) {
        count = 0; // count 초기화
        dfs(0, 0, numbers, target);
        return count;
    }

    public void dfs(int depth, int sum, int[] number, int target) {
        if (depth == number.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum + number[depth], number, target);
        dfs(depth + 1, sum - number[depth], number, target);
    }
}
