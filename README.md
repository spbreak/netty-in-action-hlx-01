# netty学习笔记

### 040301 Netty所提供的内置传输
![image](./file/image/040301.png)

### 040501 应用程序的最佳传输
![image](./file/image/040501.png)

### 050101 用户空间与内核空间
#### 以32位操作系统, 最大寻址空间为4G的进程空间为例
![image](./file/image/05010101.png)
#### CPU指令
![image](./file/image/05010102.png)
#### 如何从用户空间进入内核空间
![image](./file/image/05010103.png)
#### 应用程序如何读磁盘数据
![image](./file/image/05010104.png)
#### Linux体系结构
![image](./file/image/05010105.png)
#### 直接缓冲区和非直接缓冲区
![image](./file/image/05010106.png)
#### ByteBuf的三种使用模式
1. 堆内存(非直接缓冲区)
2. 堆外内存(直接缓冲区)
3. 复合缓冲区
--
![image](./file/image/05010107.png)
#### Java的ByteBuffer(流InputStream)单索引 
Netty的ByteBuf双索引
![image](./file/image/05030102.png)
#### Netty的discardReadByte与clear区别(clear并不会直接清空数据)
![image](./file/image/05030101.png)

#### 派生缓冲区(共享内部存储)
![image](./file/image/05030103.png)

#### set/get
    get() 和 set() 操作, 从给定的索引开始, 并且保持索引不变
    read() 和 write() 操作, 从给定的索引开始, 并且会根据已经访问过的字节数对索引进行调整

#### Channel 生命周期
![image](./file/image/06010101.png)

#### ChannelHandler 生命周期
![image](./file/image/06010102.png)

    在 ChannelHandler 被添加到 ChannelPipeline 中或者被从 ChannelPipeline 中移除时会调用这些操作
    当某个 ChannelInboundHandler 的实现重写 channelRead() 方法时,
    它将负责显式地释放与池化的 ByteBuf 实例相关的内存
    -- ReferenceCountUtil.release()
    SimpleChannelInboundHandler 会自动释放资源
    所以不应该存储指向任何消息的引用供将来使用, 因为这些引用都将会失效
### 资源管理
    class ResourceLeakDetector : 诊断潜在的 (资源泄漏) 问题
泄漏检测级别
![image](./file/image/06010103.png)

    修改netty泄漏检测级别
    java -Dio.netty.leakDetectionLevel=ADVANCED

### 出站方向释放资源
![image](./file/image/06010104.png)

### 修改ChannelPipeline
![image](./file/image/06010105.png)

###  Channel/ChannelPipeline/ChannelHandler以及ChannelHandlerContext之间关系
![image](./file/image/06010106.png)

###  通过 Channel 或者 ChannelPipeline 进行的事件传播
![image](./file/image/06010107.png)

###  通过 ChannelHandlerContext 触发的操作的事件流
![image](./file/image/06010108.png)

###  处理入站异常
![image](./file/image/06010109.png)

###  处理出站异常
![image](./file/image/06010110.png)

###  基本的线程池化模型
![image](./file/image/070201.png)
```
虽然池化和重用线程相对于简单地为每个任务都创建和销毁线程是一种进步,
但是它并不能消除由上下文切换所带来的开销, 其将随着线程数量的增加很快变得明显,
并且在高负载下愈演愈烈
```
###  Netty Reactor 线程模型
![image](./file/image/070202.png)

###  Netty EventLoop 实现原理
![image](./file/image/070203.png)

###  Netty EventLoop 事件处理机制
![image](./file/image/070204.png)

###  Netty EventLoopGroup
![image](./file/image/070205.png)

###  JDK 的任务调度API
![image](./file/image/070301.png)

###  使用 ScheduledExecutorService 在 60 秒的延迟之后执行一个任务
![image](./file/image/070302.png)

###  使用 EventLoop 调度任务
![image](./file/image/070303.png)

###  使用 ScheduledFuture 取消任务
![image](./file/image/070304.png)

###  EventLoop 的执行逻辑
![image](./file/image/070305.png)

###  非阻塞传输(如NIO和AIO)的EventLoop分配方式
![image](./file/image/070306.png)

###  阻塞传输(如OIO)的EventLoop分配方式
![image](./file/image/070307.png)

###  Netty 的 Bootstrap 引导类 引导客户端
![image](./file/image/080101.png)

###  Netty 的 Bootstrap 引导类 引导服务端
![image](./file/image/080102.png)

###  不同 Channel 间共享 EventLoop
![image](./file/image/080103.png)

###  Netty 的Channel和属性
![image](./file/image/080104.png)

###  Netty 的 关闭释放资源
![image](./file/image/080105.png)

###  sync与syncUninterruptibly
![image](./file/image/080106.png)

###  Netty 的 EmbeddedChannel
![image](./file/image/090101.png)

###  SSL/TLS 保护加密
![image](./file/image/110101.png)

###  HTTP 解码器/编码器和编解码器
![image](./file/image/110102.png)

![image](./file/image/110103.png)

###  WebSocket
![image](./file/image/110104.png)

###  空闲的连接和超时
![image](./file/image/110105.png)