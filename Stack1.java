import java.util.Stack;

public class Stack1 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>() ;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i)=='('){
                stack.add('(');
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

}
