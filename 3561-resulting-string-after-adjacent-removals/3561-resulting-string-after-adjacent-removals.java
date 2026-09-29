class Solution {
    public String resultingString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (sb.length() == 0) {
                sb.append(curr);
            } 
            else {
                char last = sb.charAt(sb.length() - 1);

                int diff = Math.abs(curr - last);

                if (diff == 1 || diff == 25) {
                    sb.deleteCharAt(sb.length() - 1);
                } 
                else {
                    sb.append(curr);
                }
            }
        }

        return sb.toString();
    }
}