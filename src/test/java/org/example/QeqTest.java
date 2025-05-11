package org.example;

import org.junit.Assert;
import org.junit.Test;

public class QeqTest {

    @Test
    public void calcTest(){
        double[] result = new Qeq(4, 4, 0).calc();
        Assert.assertArrayEquals(new double[]{0,-1}, result, 0);
        result = new Qeq(4,0,0).calc();
        Assert.assertArrayEquals(new double[]{0}, result, 0);
        result = new Qeq(1,1,1).calc();
        Assert.assertArrayEquals(new double[]{}, result, 0);
    }
}
