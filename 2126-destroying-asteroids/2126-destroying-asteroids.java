class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int m : asteroids) {
            if (m > currMass) return false;
            currMass += m;
        }
        return true;
    }
}