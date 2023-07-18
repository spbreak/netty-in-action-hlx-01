package com.example.hlx;

import org.junit.Test;

import java.util.function.Function;

public class testFunction {
    
    @Test
    public void testFunction() {
        Function<Integer, Integer> triangle = arg -> arg * 3;
        Function<Integer, Integer> square = arg -> arg * arg;
        int result1 = triangle.apply(1);
        int result2 = square.apply(1);
    }
}
