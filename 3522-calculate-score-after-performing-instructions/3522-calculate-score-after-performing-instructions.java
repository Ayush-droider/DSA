class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int i = 0;
        boolean[] vis = new boolean[instructions.length];
        long score = 0;

        while (i >= 0 && i < instructions.length && !vis[i]) {

            vis[i] = true;

            if (instructions[i].equals("jump")) {
                i += values[i];
            } else {
                score += values[i];
                i++;
            }
        }

        return score;
    }
}