package com.example.hlx;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;

public class Teststack {
    
    @Test
    public void testStack() {
        Pipeline<String> pipeline = 
                new StackPipelineBuilder<String>()
                .add(next -> new F("1", next))
                .add(next -> new F("2", next))
                .end(new E("3"));
        Assert.assertEquals("1->2->3", pipeline.toString());
    }
    
    
    private final class F extends ForwardingPipeline<String> {
        public F(
                @NonNull String name,
                @NonNull Pipeline<? super String> next
        ) {
            super(name, next);
        }

        @Override
        public void process(PipelineContext ctx, String s) {
            // TODO
        }
    }
    
    private final class E extends EndPipeline<String> {
        public E(String name) {
            super(name);
        }

        @Override
        public void process(PipelineContext ctx, String s) {
            // TODO
        }
    }
    
    
}
