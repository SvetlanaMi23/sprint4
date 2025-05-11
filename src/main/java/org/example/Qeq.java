package org.example;

import java.util.Arrays;

public class Qeq {
    public static void main(String[] args) {
        Qeq q= new Qeq(4, 4, 0);
        double[] result = q.calc();
//        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(new Qeq(4, 0, 0).calc()));
        System.out.println(Arrays.toString(new Qeq(2, 3, 0).calc()));
        System.out.println(Arrays.toString(new Qeq(1, 1, 1).calc()));
    }

    double a;
    double b;
    double c;

    Qeq(double aa, double bb, double cc) {
        this.a = aa;
        this.b = bb;
        this.c = cc;
    }

    public double[] calc() {
        double D = b * b - (4 * a * c);

        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            return new double[]{x1,x2};
        } else if (D == 0) {
            double x = -b / (2 * a);
            return new double[]{x};
        } else {
            return new double[]{};
        }
    }
}