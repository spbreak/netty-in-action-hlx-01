package com.example.hlx;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * 传递到管道的上下文
 */
@Getter
@Setter
public class PipelineContext {

    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }

}
