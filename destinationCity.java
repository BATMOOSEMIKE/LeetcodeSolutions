//O(N^2) where N is the length of paths

class Solution {
    public String destCity(List<List<String>> paths) {
        List<String> destinations = new ArrayList<String>();
        List<String> origins = new ArrayList<String>();

        for(List<String> curPath : paths) {
            origins.add(curPath.get(0));
            destinations.add(curPath.get(1));
        }

        String result = "";

        for(String city: destinations){
            if(origins.indexOf(city) == -1){
                result = city;
                break;
            }
        }

        return result;
    }
}
