package my.study.algorithm;

/**
 * Created by xpcomrade on 2016/7/19.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (质数-素数). <br/>
 */
public class Prime {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {

            System.out.println(i + " is prime -> " + isPrime(i));
        }
    }
    //checks whether an int is prime or not.
    static boolean isPrime(int n) {
        if (n == 1) return false;
        //check if n is a multiple of 2
        if (n != 2 && n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; Math.pow(i, 2d) <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
