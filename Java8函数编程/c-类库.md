##### 基本类型

```java
//如果方法返回类型是基本类型用带To的方法T->ToLongFunction->long
//如果参数是基本类型用不带To的方法，long->LongFunction->T
//mapToInt方法返回IntStream
album.getTracks().mapToInt(track -> track.getLength())  
  				 .summaryStatistics();
```

##### @FuctionalInterface注释

##### Optional

```java
Optional emptyOptional = Optional.empty();  //初始化空值
Optional alsoEmpty = Optional.ofNullable(null);  //初始化空值
assertFalse(alsoEmpty.isPresent());  //判断是否有值
assertEquals("b", alsoEmpty.orElse("b"));  //为空设置被选值
assertEquals("c", alsoEmpty.orElseGet(() -> "c"));  //为空设置被选值
```



