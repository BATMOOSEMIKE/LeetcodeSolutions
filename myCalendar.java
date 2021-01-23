class MyCalendar {

    TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        //this will hold all bookoings
        bookings = new TreeMap<Integer, Integer>();
    }

    //for a booking to be valid, the previous booking must end before or at the start and the next booking must start after or at end
    public boolean book(int start, int end) {
        if(bookings.containsKey(start)){
            return false;
        }
        else {
            boolean addable = false;
            //no previous events or events after
            if(bookings.lowerKey(start) == null && bookings.higherKey(start) == null){
                addable = true;
            }
            //no previous events
            else if(bookings.lowerKey(start) == null){
                int nextStart = bookings.higherKey(start);
                addable = (end <= nextStart);
            }
            //no events after
            else if(bookings.higherKey(start) == null){
                int prevStart = bookings.lowerKey(start);
                addable = (start >= bookings.get(prevStart));
            }
            else {
                int nextStart = bookings.higherKey(start);
                int prevStart = bookings.lowerKey(start);
                addable = (end <= nextStart) && (start >= bookings.get(prevStart));
            }

            if(addable){
                bookings.put(start, end);
            }
            return addable;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
