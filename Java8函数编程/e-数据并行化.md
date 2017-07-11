##### 并行流操作`parallelStream`

> 数据并行化是指将数据分成块，为每块数据分配单独的处理单元。

```java
//计算专辑曲目长度
albums.parallelStream().flatMap(Album::getTracks)
  						.mapToInt(Track::getLength)
  						.sum();
```

## 并行化数组操作

> 对数组并行操作，脱离流框架也可以使用Lambda表达式。

- `parallelPrefix`：任意给定一个函数，计算数组的和
- `parallelSetAll`：使用Lambda表达式更新数组元素

```java
//给数组每个元素赋值，当前序号
double[] values = new double[size];
Arrays.parallelSetAll(values,i -> i);
```

- `parallelSort`：并行化对数组元素排序



