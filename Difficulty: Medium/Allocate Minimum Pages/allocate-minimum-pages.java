class Solution {
    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int start = 0;
        int end = 0;
        for (int pages : arr) {
            start = Math.max(start, pages);
            end += pages;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canAssign(arr, k, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canAssign(int[] arr, int k, int maxPages) {
        int students = 1;
        int pages = 0;
        for (int book : arr) {
            if (pages + book <= maxPages) {
                pages += book;
            } else {
                students++;
                pages = book;
            }
        }
        return students <= k;
    }
}
