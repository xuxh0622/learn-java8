##### 方法引用

```java
//artist -> artist.getName()
Artist::getName
//(name, nationality) -> new Artist(name, nationalty)
Artist::new
String[]::new
```

##### 元素顺序`sorted`

```java
new HashSet<>(asList(4,2,1,1)).stream().sorted().collect(Collectors.toList());
```

##### 使用收集器

> collect里面的一些函数

```java
//找出成员最多的乐队
artists.collect(maxBy(comparing(artist -> artist.getMembers().count())))
```

##### 数据分块`partitioningBy`

```java
//将艺术家组成的流分成乐队和独唱歌手两部分
Map<Boolean,List<Artist>> result = artists
  								.collect(partitioningBy(artist -> artist.isSolo()))
```

##### 数据分组`groupingBy`

```java
//使用主唱对专辑分组，接受Predicate对象将数据分成true、false分组
albums.collect(groupingBy(album -> album.getMainMusician()))
```

##### 字符串`joing`

```java
//生成艺术家字符串"[John, Paul]"，提供分隔符、前缀、后缀
artists.stream().map(Artist::getName).collect(Collectors.joing(", ", "[". "]"))
```

##### 使用收集器

> 下游收集器

```java
//使用收集器计算每个艺术家的专辑数，使用下游另一个收集器收集每块中元素
Map<Boolean,Long> result = artists.collect(partitioningBy(artist -> artist.isSolo(),Collectors.counting()))
Map<Boolean,List<String>> =  artists.collect(partitioningBy(artist -> artist.isSolo(),Collectors.mapping(artist -> artist.getName(), Collectors.toList())))
```

