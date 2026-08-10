class MedianFinder {
    private PriorityQueue<Integer> pqMin;
    private PriorityQueue<Integer> pqMax;

    public MedianFinder() {
        this.pqMin = new PriorityQueue<>(Collections.reverseOrder());
        this.pqMax = new PriorityQueue<>();
    }

    public void addNum(int num) {
        pqMin.offer(num);
        pqMax.offer(pqMin.poll());
        if(pqMax.size() > pqMin.size()) {
            pqMin.offer(pqMax.poll());
        }
    }

    public double findMedian() {
        if(pqMin.size() > pqMax.size()) return pqMin.peek();
        return (pqMin.peek() + pqMax.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */