# universe
study

## 2022-07-20
### double,float 精度问题。
主要是因为计算机是二进制保存数据的，所以会被截断。所以浮点数类型这个需要特别注意一下。推荐使用`BigDecimal`来进行浮点数的计算，要记住这个scale,保留几位小数的。
这一部分主要涉及到，十进制如何转换二进制（除二取余），二进制如何转换十进制（n*2n次方 后相加）。 小数点如何表示为二进制。 0.1 为什么不准确

### 如何计算一个字符串所占的字节数呢？ 
这需要看字符编码。`str.getBytes("编码").length;`
### java 基本数据类型 
byte:1 short:1 char int:4 long float double boolean 基本类型所占字节数? 大小也需要确定一下。
### algorithm module init

## 2022-07-21
### 适配器模式
需要有一个被适配的类,目标接口，组装类。组装类需要implement 接口，然后继承被适配类完成适配工作组装目标接口和需要被适配的类。 
### 建造者模式
可以自定义链式调用来赋值。然后内部定义一个Builder类，类里写一些规则，记性参数的隐藏设置和校验等操作。
### 代理模式
分为动态代理和静态代理。 原始方法调用前后添加一些操作， 
- cglib 动态代理：使用Ehancer.create(Class,CallBack) callback函数 可以是methodIncepter.incepter和invocationHandler的invoke方法
- jdk 动态代理。需要定义一个接口，使用Proxy.newProxyInstance(Class,classLoader,interface,InvocationHandle)强转为定义的接口。传入一个回调函数 InvocationHandler

## 2022-07-22
### Java 异常相关，
必须有athrow 字节码指令才会抛出异常。finally 里有return 的时候没有 athrow指令，所以不会抛异常，return的必须是finally里的

## 2022-07-23
### Spring Boot 自动装配机制。
主要是@SpringBootApplication 注解中的@EnableAutoConfiguration。该注解中`@Import(AutoConfigurationImportSelector.class)` AutoConfigurationImportSelector中会自动扫描 `MEAT-INF/spring.factories` 下的所有类。后续还会判断这些自动注入的类的条件，进行一些过滤 比如`@Conditional`相关的注解。 

由此可以推断出自己如何实现一个 starter。步骤如下：
1. 创建一个starter项目
2. 创建配置类。定义bean
3. 在META-INF包下创建一个文件`spring.factories` 将2 的配置类的全限定名写入进去

> @AutoConfiguration Spring Boot 2.7 需要特别注意：
> 自动配置类 META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports 放在这，之前的spring.factories 也适用。
> 还添加了 @AutoConfiguration 注解，里面有一些属性 after，befrore等等。以替代之前的注解 @AutoConfigureAfter 等等。@AutoConfiguration(before = Thread.class,after = ThreadPoolExecutor.class)

## 2022-07-26
### init elasticsearch module
solve the problem:1: gradle kotlin build is different from normal gradle 2:TestClass path

## 2022-08-10
### Spring Event Demo。
主要步骤如下
1. 创建事件，继承`ApplicationEvent`
2. 创建监听者，实现接口 `ApplicationListener<T>` 泛型是步骤一注册的事件。
3. 使用`applicationContext.publishEvent(T t)` 发布事件。事件发布后对应的监听事件也会触发


## 2022--8-12
### Spring 事务相关
#### Spring 事务的实现原理。
**基于aop实现**。**依赖于数据库事务**。主要分为两个部分
1. Bean得初始化阶段，创建代理对象
Spring在初始化bean得时候会遍历容器内所有得BeanPostProcessor 实现类，并执行其`postProcessAfterInitialization()`方法，在执行到 `AbstractAutoProxyCreator#postProcessAfterInitialization` 会遍历容器中得所有切面，查找与当前bean 相匹配得切面，
如果事务属性的切面那就查找 `@Transational`注解及其属性值，然后根据得到得漆面创建一个代理对象。
2. 在执行目标方法得时候进行事务增强操作
通过代理Bean 调用方法，会触发对应得aop拦截增强器，主要类 `TransactionalInceptor`在invoke 方法得时候通过`TransactionAspectSupport#invokeWithinTransaction` 方法进行事务处理。包括开启事务，执行目标方法，事务提交，异常回归。

#### Spring 事务什么时候会失效呢？
根据上述得Spring事务得原理可窥一二。(代理方法)(本质还是Spring事务)(事务传播由ThreadLocal实现) 所以失效原因就好找了。
1. 数据库存储引擎不支持事务
2. 注解中值得设置，尤其注意rollback，propagation得设置。 `rollbackFor=Exception.class`和不加得区别。

<img height="600" src="https://chunyizanchi.oss-cn-beijing.aliyuncs.com/life/spring-transaction.png" width="1000"/>

## 2022-08-13
### 初始化了一下项目

## 2022-08-13
### maven 父子间依赖问题， 
scope 的几种属性： compile runtime, provide,test,system。 默认是 compile。

## 2022-08-14
### 泛型的协变和逆变。 
`<? extends T>` 表示 ? 类型需要是 T 类型的子类型。 `<? super T>` 表示 ? 类型需要是 T 类型的超类。
还需要回顾一下泛型擦除。
PECS : producer extends consumer super

## 2022-08-17
### 泛型擦除，jvm层面将类型擦除掉了。


## 2022-08-18
### init netty module

### maven 相关。
`<dependencyManagement>` 标签得作用：统一依赖管理。

`<dependencyManagement>` 和`<dependencies>` 得区别：
1. 所有声明在 `<dependencies>` 得依赖都会自动被子module 引用。
2. `<dependencyManagement>` 只是声明依赖，不自动实现引入。只有子 module 声明了相同依赖并且没指定版本，才会从父 module中引入该依赖，并且 version 和 scope 都读自父module

### 初始化 BaseRequest,BaseResponse

### mp 的save 方法多次调用了实体类的get方法。


## 2022-08-20
### 观察者模式
1

## 2022-08-25
### Spring中如何正确关闭线程池？
这里需要考虑的是我们一般在项目中如何定义一个线程池，大部分都会说直接@Bean 定义一个线程池，然后在使用该线程池的类中，自动注入。
这里就需要考虑几个问题了，
1. 线程池如何关闭？ shutDown,shutDownNow, awaitTermination
2. 线程池如何感知Spring Shutdown Hook将要被执行？
3. 如何让线程池先于Spring Shutdown Hook关闭？

线程池的销毁和Spring Bean生命周期中Bean的销毁的异同点。
两种方式销毁线程池。
1. 一个是自定义的线程池，需要再创建一个Bean，在该Bean中注入我们自定义的线程池对象，然后维护一个@Destory 注解来确定销毁Bean的方法
2. 使用ThreadPoolTaskExecutor ,在类中设置一个属性 `threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);` 保证在销毁之前要shutdown 线程池。然后定义一个Bean 监听 closeContextEvent 事件，来进行shut down线程池
3. 实现Lifecycle接口，并在其stop方法中关闭线程池

使用ThreadPoolTaskExecutor 有意思的一点。set方法可以设置阻塞队列的长度，但是不能显示的指定一个阻塞队列。如果指了长度，默认创造一个linkedBlockQueue,否则创建一个 SynchronousQueue
补充：
Spring boot，容器关闭会调用 AbstractApplicationContext方法的 doClose 方法 主要代码如下
```java
protected void doClose() {
		// Check whether an actual close attempt is necessary...
		if (this.active.get() && this.closed.compareAndSet(false, true)) {

            // Publish shutdown event.发布事件，所以我们需要定义一个该事件的监听者
            publishEvent(new ContextClosedEvent(this));
            
			// Stop all Lifecycle beans, to avoid delays during individual destruction.
            this.lifecycleProcessor.onClose();
            
			// Destroy all cached singletons in the context's BeanFactory.
			destroyBeans();

			// Close the state of this context itself.
			closeBeanFactory();
            
			// Let subclasses do some final clean-up if they wish...
			onClose();

			// Reset local application listeners to pre-refresh state.
			if (this.earlyApplicationListeners != null) {
				this.applicationListeners.clear();
				this.applicationListeners.addAll(this.earlyApplicationListeners);
			}

			// Switch to inactive.
			this.active.set(false);
		}
	}
```
所以 综上加上代码，应该就好理解了，还是要注意一下 spring 的生命周期。 容器初始化和容器销毁分别做了什么

## 2022-08-28
### aop

## 2022-08-31
### init rocketmq-producer module and rocketmq-consumer module
配置很恶心，多模块下的maven依赖还是要好好解决一下


## 2022-09-01
### 搭建dubbo demo
依赖版本问题很恶心，以后先注意这一点，先不考虑配置问题
高版本的dubbo的一些注解和低版本不一样 @Service -> @DubboService   @Reference-> @@DubboReference  @EnableDubbo
-Dzookeeper.sasl.client=false  关闭zk安全验证


## 2022-09-15
### 职责链模式
首先定义一个抽象类Handler。里面定义一个两个方法，一个是处理对象的抽象方法，一个是添加Handler实现类的方法。 在使用上可以需要注意add的顺序，然后在调用处理方法 [validateHandlerTest](design/src/main/java/com/cyzc/designpattern/chainPattern/validateHandlerTest/TestDemo.java)
github 相对路径写法

## 2022-09-25
### HashedWheelTimer 类实现定时任务

## 2022-11-02
### 字符串 hashcode 计算问题
先看一段代码：
```java
System.out.println("Aa ="+"Aa".hashCode());
System.out.println("BB ="+"BB".hashCode());

public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
        h = 31 * h + val[i];
        }
        hash = h;
        }
        return h;
        }
```
直接说结论：字符串类型计算hashcode，满足第一个字符串的第一个字母的ASCII码值减去第二个字符串的第一个字母的ASCII码值=1，第二个字符串的第二个字母减去第一个字符串的第二个字母=31 那么这两个字符串的hashcode一定相等。
常见的ASCII码值：A：65 a:97
