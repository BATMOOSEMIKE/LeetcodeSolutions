class Solution {
    public String defangIPaddr(String address) {
        String result = "";

        for(int i = 0; i < address.length(); i++){
            if(address.substring(i,i+1).equals(".")){
                result += "[.]";
            }
            else{
                result += address.substring(i,i+1);
            }
        }

        return result;
    }
}
