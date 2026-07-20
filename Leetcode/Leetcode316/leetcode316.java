class Solution {
    public String removeDuplicateLetters(String s) {
        char[] S = s.toCharArray();
        int[] word = new int[26];
        for (char c : S) {
            word[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder(26);
        boolean[] inAns = new boolean[26];
        for (char c : S) {
            word[c - 'a']--;
            if (inAns[c - 'a']) {
                continue;
            }
            while (!ans.isEmpty() && c < ans.charAt(ans.length() - 1) && word[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                inAns[ans.charAt(ans.length() - 1) - 'a'] = false; // 标记栈顶不在 ans 中
                ans.deleteCharAt(ans.length() - 1);
            }
            ans.append(c);
            inAns[c - 'a'] = true;
        }
        return ans.toString();
    }
}