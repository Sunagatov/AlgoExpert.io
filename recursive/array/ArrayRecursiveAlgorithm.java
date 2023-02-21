package com.zufar.algorithm.recursive.array;

import java.util.Arrays;

public class ArrayRecursiveAlgorithm {



    public Integer getArraySum(Integer[] array) {
        if (array.length == 0)
            return 0;
        else return array[0] + getArraySum(Arrays.copyOfRange(array, 1, array.length));
    }

}
