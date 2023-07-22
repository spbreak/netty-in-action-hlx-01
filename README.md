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
