1、启动参数：
java -jar -Xms2400m -Xmx2400m -Xmn800m -XX:+UseG1GC -XX:ParallelGCThreads=8 -XX:ConcGCThreads=8 
  gateway-server-0.0.1-SNAPSHOT.jar
默认GC线程数 = 物理核心*5/8+3 = 16*5/8+3 = 13
本次GC线程数设置为8

2、执行命令：jmap -heap 2728:
Attaching to process ID 2728, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 25.191-b12

using thread-local object allocation.
Garbage-First (G1) GC with 8 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 2516582400 (2400.0MB)
   NewSize                  = 838860800 (800.0MB)
   MaxNewSize               = 838860800 (800.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 2400
   capacity = 2516582400 (2400.0MB)
   used     = 28835832 (27.49999237060547MB)
   free     = 2487746568 (2372.5000076293945MB)
   1.1458330154418945% used
G1 Young Generation:
Eden Space:
   regions  = 3
   capacity = 854589440 (815.0MB)
   used     = 3145728 (3.0MB)
   free     = 851443712 (812.0MB)
   0.36809815950920244% used
Survivor Space:
   regions  = 25
   capacity = 26214400 (25.0MB)
   used     = 26214400 (25.0MB)
   free     = 0 (0.0MB)
   100.0% used
G1 Old Generation:
   regions  = 0
   capacity = 1635778560 (1560.0MB)
   used     = 0 (0.0MB)
   free     = 1635778560 (1560.0MB)
   0.0% used

16198 interned Strings occupying 2191200 bytes.

