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