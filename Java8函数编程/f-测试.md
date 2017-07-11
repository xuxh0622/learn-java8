##### 解决方案`peak`

> 可以查看每个值，同时能继续操作流。

```java
Set<String> nationalities = album.getMusicians()
  							.filter(artist -> artist.getName().stratsWith("The"))
  							.peek(artist -> System.out.println("not found"))
  							.collect(Collectors.<String>toSet());
```

