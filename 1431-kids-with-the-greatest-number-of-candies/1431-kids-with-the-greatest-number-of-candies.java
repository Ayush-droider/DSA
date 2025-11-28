class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> list = new ArrayList<>();

        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }

        return list;
    }
}
