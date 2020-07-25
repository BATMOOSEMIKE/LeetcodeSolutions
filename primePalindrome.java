/*
This solution is a brute force algorithm, skipping all numbers of digit length 8
and using other mathematical tricks to beat the runtime requirements.
I will try to write a smarter solution where I iterate through all palindromes instead
*/
class Solution {
    public int primePalindrome(int N) {
        boolean found = false;
        int ourNumber = N;

        if(N == 1 || N ==2) {
            return 2;
        }
        if(N == 3) {
            return 3;
        }
        if(N == 4 || N == 5) {
            return 5;
        }
        if(N == 6 || N == 7) {
            return 7;
        }
        if(N == 8 || N == 9) {
            return 11;
        }

        while(ourNumber < 200000000) {
            if(countDigits(ourNumber) == 8) {
                ourNumber = 99999999;
            }
            if(isPalindrome(ourNumber) && isPrime(ourNumber)) {
                return ourNumber;
            }
            ourNumber++;
        }

        return 10;

    }

    public static boolean isPrime(int n) {
        if(n % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countDigits(int n) {
        int count = 0;
        while(n > 0){
            count++;
            n /= 10;
        }
        return count;
    }

    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int num = n;
        while(n > 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return (reverse == num);
    }

}
