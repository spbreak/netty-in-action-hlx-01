package com.example.hlx;

import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public final class StackPipelineBuilder <T> {

    private final Deque<Function<Pipeline<? super T>, ? extends Pipeline<T>>> stack =
            new ArrayDeque<>();
    
    public StackPipelineBuilder<T> add(
            @NonNull Function<
                    Pipeline<? super T>,
                    ? extends ForwardingPipeline<T>
                    > factory) {
        stack.push(factory);
        return this;
    }
    
    public Pipeline<T> end(@NonNull EndPipeline<T> endPipeline) {
        if (stack.isEmpty()) {
            return endPipeline;
        }
        
        Pipeline<T> p = endPipeline;
        while (!stack.isEmpty()) {
            p = stack.pop().apply(p);
        }
        return p;
    }
    
}
