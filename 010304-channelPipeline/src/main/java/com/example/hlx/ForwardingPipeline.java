package com.example.hlx;

import lombok.NonNull;

public abstract class ForwardingPipeline <T> implements Pipeline<T> {
    
    private final String name;
    
    private final Pipeline<? super T> next;
    
    public ForwardingPipeline(@NonNull String name, @NonNull Pipeline<? super T> next) {
        this.name = name;
        this.next = next;
    }
    
    @Override
    public abstract void process(PipelineContext ctx, T t);
    
    @Override
    public void forward(PipelineContext ctx, T t) {
        next.process(ctx, t);
    }
    
    @Override
    public String toString() {
        return name + "->" + next.toString();
    }
}
