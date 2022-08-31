##使用@AutoConfigureBefore、@AutoConfigureAfter、@AutoConfigureOrder三大注解控制自动配置执行顺序的正确姿势

##要想达到预期效果，正确姿势只需要下面两步：
* 把A_SonConfig和B_ParentConfig挪动到Application扫描不到的包内，切记：一定且必须是扫描不到的包内
* 当前工程里增加配置META-INF/spring.factories，内容为(配置里Son和Parent前后顺序对结果无影响)
* 对于三大注解的正确使用姿势是应该是：请使用在你的自动配置里（一般是你自定义starter时使用），而不是使用在你业务工程中的@Configuration里，因为那会毫无效果。

### 三个注解的解析都是交给AutoConfigurationSorter来排序、处理的，做法类似于AnnotationAwareOrderComparator去解析排序@Order注解。核心代码如下：
class AutoConfigurationSorter {
	
	// 唯一给外部调用的方法：返回排序好的Names，因此返回的是个List嘛（ArrayList）
	List<String> getInPriorityOrder(Collection<String> classNames) {
		...
		// 先按照自然顺序排一波
		Collections.sort(orderedClassNames);
		// 在按照@AutoConfigureBefore这三个注解排一波
		orderedClassNames = sortByAnnotation(classes, orderedClassNames);
		return orderedClassNames;
	}
	...
}

此排序器被两个地方使用到：

* AutoConfigurationImportSelector：Spring自动配置处理器，用于加载所有的自动配置类。它实现了DeferredImportSelector接口：这也顺便解释了为何自动配置是最后执行的原因~
* AutoConfigurations：表示自动配置@Configuration类。

这个排序的“解析/排序”过程还是比较复杂的，点到为止，观其大意即可。你可以简单粗暴的记住结论：@AutoConfigureBefore、@AutoConfigureAfter、@AutoConfigureOrder这三个注解只能作用于自动配置类，而不能是自定义的@Configuration配置类。

