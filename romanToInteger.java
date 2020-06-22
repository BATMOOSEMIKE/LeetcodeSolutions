class Solution {
    public int romanToInt(String s) {
        int counter = 0;

        int i = s.length()-1;

        //Get all trailing Is first
        while(i >= 0 && s.charAt(i) == 'I') {
            i--;
            counter += 1;
        }

        //Process V,X
        while(i >= 0 && (s.charAt(i) == 'V' || s.charAt(i) == 'X' || s.charAt(i) == 'I')) {
            char cur = s.charAt(i);
            if(cur == 'V') {
                counter += 5;
            }
            if(cur == 'X') {
                counter += 10;
            }
            if(cur == 'I') {
                counter--;
            }
            i--;
        }

        //Process L,C
        while(i >= 0 && (s.charAt(i) == 'L' || s.charAt(i) == 'C' || s.charAt(i) == 'X')) {
            char cur = s.charAt(i);
            if(cur == 'L') {
                counter += 50;
            }
            if(cur == 'C') {
                counter += 100;
            }
            if(cur == 'X') {
                counter -= 10;
            }
            i--;
        }

        //Process D,M
        while(i >= 0 && (s.charAt(i) == 'M' || s.charAt(i) == 'D' || s.charAt(i) == 'C')) {
            char cur = s.charAt(i);
            if(cur == 'M') {
                counter += 1000;
            }
            if(cur == 'D') {
                counter += 500;
            }
            if(cur == 'C') {
                counter -= 100;
            }
            i--;
        }

        return counter;
    }
}
