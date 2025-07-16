class Solution {
    public String reverseWords(String s) {
        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Use StringBuilder for efficient reversal
        StringBuilder reversed = new StringBuilder();
        
        // Add words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        
        return reversed.toString();
    }
}
