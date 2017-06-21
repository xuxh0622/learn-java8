#### 第一个Lambda表达式

> 参数用用括号扩着，然后表达式用大括号扩着。

```java
Runnable multiStatement = (Long x,Long y) -> {
  System.out.println("hello");
}
```

#### 引用值，而不是变量

> 参数实质引用final变量。

#### 函数接口

> 只有一个抽象方法的接口，用作Lambda表达式的类型。

#### 类型推断

```java
//Predicate接口的源码，接受一个对象，返回一个boolean值
public interface Predicate<T>{
  boolean test(T t);
}
public interface Function<T,R>{
  R apply(T t);
}
```

