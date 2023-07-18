package com.example.hlx;

public final class DemoPipeline extends OrdinaryPipeline<String> {
    
    public DemoPipeline(String name) {
        super(name);
    }
    
    @Override
    public void process(PipelineContext ctx, String s) {
        System.out.println("process");
        // TODO
    }
}
