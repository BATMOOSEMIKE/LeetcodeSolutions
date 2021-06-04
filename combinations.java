class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> acc = new ArrayList<List<Integer>>();

        findCombos(n, k, new ArrayList<Integer>(), acc);
        return acc;
    }

    //if n == k then just fill lacc with all numbers in n and add lacc to acc
    //if k = 0 then just add lacc to acc
    //otherwise, we can include or exclude the number n
    //if we include, then update lacc by adding n and fill the rest with n-1, k-1
    //if we exclude, then don't change lacc and fill the rest with n-1, k
    public void findCombos(int n, int k, List<Integer> lacc, List<List<Integer>> acc){
        if(k == 0){
            acc.add(lacc);
        }
        else if(n == k){
            for(int i = 1; i <= n; i++){
                lacc.add(i);
            }
            acc.add(lacc);
        }
        else {
            List<Integer> lacc1 = new ArrayList<Integer>(lacc);
            lacc1.add(n);
            findCombos(n-1,k-1,lacc1,acc);
            findCombos(n-1,k,lacc,acc);
        }
    }
}
