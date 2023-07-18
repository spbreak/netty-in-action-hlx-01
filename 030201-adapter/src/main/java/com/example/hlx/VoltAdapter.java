package com.example.hlx;

/**
 * Adapter 角色, 将 220V 电压转换成电脑需要的 5V 电压
 * 类适配器模式关键代码
 */
public class VoltAdapter extends Volt220 implements FiveVolt {
    @Override
    public int getVolt5() {
        return 5;
    }
}
