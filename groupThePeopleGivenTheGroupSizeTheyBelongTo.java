//Important takeaways: use the specific formatting for stacks (specifying Integer)
//to avoid casting problems later on

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, Stack<Integer>> people = new HashMap<Integer, Stack<Integer>>();

        for(int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if(people.containsKey(size)) {
                Stack<Integer> myStack = people.get(size);
                myStack.push(i);
                people.put(size, myStack);
            }
            else {
                Stack<Integer> newStack = new Stack<Integer>();
                newStack.push(i);
                people.put(size, newStack);
            }
        }


        List<List<Integer>> groups = new ArrayList<List<Integer>>();

        people.forEach((size, stack) -> {
            int numGroups = stack.size()/size;
            for(int i = 0; i < numGroups; i++) {
                List<Integer> curGroup = new ArrayList<Integer>();
                for(int j = 0; j < size; j++) {
                     curGroup.add(stack.pop());
                }
                groups.add(curGroup);
            }
        });

        return groups;

    }
}
