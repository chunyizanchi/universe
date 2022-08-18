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
#### init netty module