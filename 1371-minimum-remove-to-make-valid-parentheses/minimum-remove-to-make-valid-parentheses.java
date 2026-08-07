class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(char c : s.toCharArray()) {
            if(!stack.empty() && s.charAt(stack.peek()) == '(' && c == ')') 
                    stack.pop();
            else if(c == '(' || c == ')') stack.push(count);

            sb.append(c);
            count++;
        }
        while(stack.size() > 0){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}