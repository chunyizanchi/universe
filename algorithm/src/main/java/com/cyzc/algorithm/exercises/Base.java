package com.cyzc.algorithm.exercises;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/14 23:18]
 */
public class Base {

    public static void main(String[] args) {

    }




    public static double sqrt(double c){
        if (c<0) return Double.NaN;
        double err=1e-15;
        double t=c;
        while (Math.abs(t-c/t)>err*t)
            t=(c/t+t)/2.0;
        return t;
    }

}
