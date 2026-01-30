class MedianFinder {

    // Max-heap → stores the smaller half of numbers
    // The largest of the smaller half is at the top
    PriorityQueue<Integer> left;

    // Min-heap → stores the larger half of numbers
    // The smallest of the larger half is at the top
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // Max-heap (reverse order) for left side
        left = new PriorityQueue<>(Collections.reverseOrder());

        // Min-heap for right side
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Always add to left (max-heap) first
        left.offer(num);

        // Step 2: Move the largest element from left → right
        // This ensures every element in left <= every element in right
        right.offer(left.poll());

        // Step 3: Balance sizes
        // We allow left to have either equal elements OR 1 extra
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        // Case 1: Even total elements → median is average of two middle values
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        // Case 2: Odd total elements → left heap has the extra element
        else {
            return left.peek();
        }
    }
}
