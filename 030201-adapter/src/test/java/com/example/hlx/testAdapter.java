package com.example.hlx;

import org.junit.Test;

public class testAdapter {
    
    @Test
    public void testAdapter() {
        // 类适配器模式
        VoltAdapter adapter = new VoltAdapter();
        System.out.println("输出电压 : " + adapter.getVolt220());
        System.out.println("输出电压 : " + adapter.getVolt5());
        
    }
}
