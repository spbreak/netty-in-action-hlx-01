package com.example.hlx;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OrdinaryPipelineTest {
    
    @Test
    public void test() {
        Pipeline<?> pipeline = 
                OrdinaryPipeline.getInstance(
                        Arrays.asList(
                                new DemoPipeline("1"), 
                                new DemoPipeline("2"), 
                                new DemoPipeline("3")
                        )
                );
        Assert.assertEquals("1->2->3", pipeline.toString());
    }
}
