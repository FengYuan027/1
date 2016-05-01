/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

public class MovingAverage {
    private int size;
    private int currentSize;
    private int currentSum;
    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MovingAverage(int _size) {
        size = _size;
        currentSize = 0;
        currentSum = 0;
        deque = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (currentSize == size && size > 0) {
            currentSum -= deque.pollFirst();
            currentSize--;
        }
        if (currentSize < size) {
            deque.addLast(val);
            currentSum += val;
            currentSize++;
        }
        return currentSize > 0 ? (double)currentSum/currentSize : 0.0;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
