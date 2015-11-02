package com.example;

import java.io.IOException;


public class MessingAround {

    public static void main(String[] args) throws IOException, InterruptedException {

        factorialRec(1,2000);
    }


    public static int factorialRec(final int factorial, final int number) {
        if (number == 1) return factorial;
        else
            return number * factorialRec(factorial*number, number - 1);

    }

}
