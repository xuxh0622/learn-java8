##### 并行流操作`parallelStream`

> 数据并行化是指将数据分成块，为每块数据分配单独的处理单元。

```java
//计算专辑曲目长度
albums.parallelStream().flatMap(Album::getTracks)
  						.mapToInt(Track::getLength)
  						.sum();
```

