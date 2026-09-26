class MedianFinder {

    PriorityQueue<Integer> left;   // max heap
    PriorityQueue<Integer> right;  // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        left.offer(num);

        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2;
        }

        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */