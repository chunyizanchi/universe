## 2022-07-20
1. double,float 精度问题,主要是因为计算机是二进制保存数据的，所以会被截断。所以浮点数类型这个需要特别注意一下。推荐使用`BigDecimal`来进行浮点数的计算，要记住这个scale,保留几位小数的。
2. 如何计算一个字符串所占的字节数呢？ 这需要看字符编码。str.getBytes("编码").length;
3. java 基本数据类型 byte:1 short:1 char int:4 long float double boolean 基本类型所占字节数? 大小也需要确定一下。
4. algorithm module init

## 2022-07-21
1. 适配器模式:需要有一个被适配的类,目标接口，组装类。组装类需要implement 接口，然后继承被适配类完成适配工作组装目标接口和需要被适配的类。
2. 建造者模式:可以自定义链式调用来赋值。然后内部定义一个Builder类，类里写一些规则，记性参数的隐藏设置和校验等操作。
3. 代理模式:分为动态代理和静态代理。 原始方法调用前后添加一些操作，
   - cglib 动态代理：使用Ehancer.create(Class,CallBack) callback函数 可以是methodIncepter.incepter和invocationHandler的invoke方法
   - jdk 动态代理。需要定义一个接口，使用Proxy.newProxyInstance(Class,classLoader,interface,InvocationHandle)强转为定义的接口。传入一个回调函数 InvocationHandler
    
## 2022-07-22
1. Java 异常相关，必须有athrow 字节码指令才会抛出异常。finally 里有return 的时候没有 athrow指令，所以不会抛异常，return的必须是finally里的

## 2022-07-23
1. Spring Boot 自动装配机制。主要是@SpringBootApplication 注解中的@EnableAutoConfiguration。该注解中`@Import(AutoConfigurationImportSelector.class)`AutoConfigurationImportSelector中会自动扫描 MEAT-INF/spring.factories 下的所有类。后续还会判断这些自动注入的类的条件，进行一些过滤 比如@Conditional相关的注解。由此可以推断出自己如何实现一个 starter。步骤如下
   1. 创建一个starter项目
   2. 创建配置类。定义bean
   3. 在META-INF包下创建一个文件`spring.factories` 将2 的配置类的全限定名写入进去
> @AutoConfiguration Spring Boot 2.7 需要特别注意：自动配置类 META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports 放在这，之前的spring.factories 也适用。还添加了 @AutoConfiguration 注解，里面有一些属性 after，befrore等等。以替代之前的注解 @AutoConfigureAfter 等等。@AutoConfiguration(before = Thread.class,after = ThreadPoolExecutor.class)

## 2022-07-26
1. init elasticsearch module。 solve the problem:1: gradle kotlin build is different from normal gradle 2:TestClass path

## 2022-08-10
1. Spring Event Demo。主要步骤如下
   1. 创建事件，继承`ApplicationEvent`
   2. 创建监听者，实现接口 `ApplicationListener<T>` 泛型是步骤一注册的事件。
   3. 使用`applicationContext.publishEvent(T t)` 发布事件。事件发布后对应的监听事件也会触发


## 2022--8-12
1. Spring 事务相关