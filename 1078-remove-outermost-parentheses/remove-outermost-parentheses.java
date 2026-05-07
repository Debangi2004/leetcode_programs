class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(counter > 0) sb.append(ch);
                counter++;
            }
            else if(ch == ')'){
                counter--;
                if(counter > 0) sb.append(ch);
            }
        }

        return sb.toString();
    }
}