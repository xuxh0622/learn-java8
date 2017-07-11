#### 从外部迭代到内部迭代

> 只要调用List或Set的stream就能得到流。

```java
/**
 * artist -> artist.from("London")使用Predicate接口类
 * filter不产生新集合，为惰性求值方法
 * count会从Stream产生值得方法叫做及早求值方法
 */ 
long count = allArtists.stream()
  			.filter(artist -> artist.from("London"))
  			.count();
```

#### 常用的流操作

> `collect(toList())`由Stream里的值生成一个列表，是一个及早求值操作。

```java
List<String> collected = Stream.of("a","b").collect(Collectors.toList());
assertEquals(asList("a", "b"), collected);
```

> `Map`可以将一种类型的值转换成另外一种类型，将一种流转为另一种流。

```java
//string -> string.toUpperCase()使用Function接口
List<String> collected = Stream.of("a","b")
  						.map(string -> string.toUpperCase())
  						.collect(Collectors.toList());
```

> `filter`遍历数据并检查其中元素

```java
//artist -> artist.from("London")使用Predicate接口类
long count = allArtists.stream()
  			.filter(artist -> artist.from("London"))
  			.count();
```

> `flatMap`方法可用Stream替换值，将多个Stream练成一个。

```java
//numbers -> numbers.stream()使用Function接口，返回Stream
List<Integer> together = Stream.of(asList(1,2), asList(3,4))
  						.flatMap(numbers -> numbers.stream())
  						.collect(Collectors.toList());
```

> `max`和`min`，在Stream中求最大值和最小值。

```java
Track shortTrack = tracks.stream()
  				   	.min(track -> track.getLength())
  					.get();
```

##### 通用模式

> 原始`reduce`模式

```java
Object accumulator = initialValue;
for(Object element : collection){
  accumulator = combine(accumulator, element); //这个方法比较大小，然后赋值
}
//通过reduc求和,0作为初始值，然后最新acc是上一轮acc+element之和
int count = Stream.of(1, 2, 3)
  			.reduce(0, (acc, element) -> acc + element);
```

##### 整合操作

```java
//找出某张专辑所有乐队的国籍
Set<String> origins = album.getMusicians()
					.filter(artist -> artist.getName().startsWith("The"))
					.map(artist -> artist.getNationality())
					.collect(toSet());
```

##### 重构遗留代码

```java
//找出曲目长度大于一分钟的歌曲名称--45
Set<String> trackNames = albums.stream()
  						.flatMap(album -> album.getTracks().stream())
  						.filter(track -> track.getLength() > 60)
  						.map(track -> track.getName())
  						.collect(Collectors.toSet());
```



