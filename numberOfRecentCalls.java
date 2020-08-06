//O(N) where N is number of pings, because .add(), .peek() and .size() are all O(1) time

class RecentCounter {

    Queue<Integer> validPings;

    public RecentCounter() {
        validPings = new LinkedList<Integer>();
    }

    public int ping(int t) {
        validPings.add(t);
        while(validPings.peek() != null && validPings.peek() < t-3000) {
            validPings.remove();
        }
        return validPings.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
