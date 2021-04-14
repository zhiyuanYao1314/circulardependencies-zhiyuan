



# 运行
运行com/example/circulardependencieszhiyuan/test/MainStart.main方法



# 原理0 在不考虑效率和代理类的情况下，一个缓存instanceMap即可， 步骤如下：
    1. getBean从map中获取， 获取到了直接返回；
    2. 获取不到，加锁instanceMap, 然后实例化放入map中；
    3. 初始化，属性赋值，再次调用getBean进入1；B在初始化属性A的时候，已经可以从instanceMap中获取到了
    4. 直接结束；

# 原理1 不需要创建代理的情况下：

1. A中有B， B中有A；
2. 在容器中有instanceMap和earlyInstanceMap两个map， 第一个map存储最终可以使用的实例，第二个map存储实例化但没有初始化的对象

3. 在轮流扫描beanDefinition创建bean实例的时候，
    1. 先通过instanceMap直接获取， 获取到，说明已经创建过，直接返回；
    2. 没有获取到，从二级缓存earlyInstanceMap中获取，获取到就返回，
    3. 二级缓存中还是没有获取到，标记正在创建，然后实例化并且放入earlyInstanceMap实例中，
    3. 然后进行初始化，autowired属性赋值，再次进入getBean中，从1开始；
    4. 创建完成，放入一级缓存， 如果二级缓存中有，就删除。


# 原理2， 创建代理的情况下，流程： 
查看循环依赖流程图.png 

