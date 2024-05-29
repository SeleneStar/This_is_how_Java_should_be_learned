
静态语句允许早于构造方法。
![static.png](test1static1/static.png)

无论有多少个对象，静态的都只进行一次
![static2.png](test2static2/static2.png)

虽然静态类遭遇构造方法，但是该类被使用，这个类的静态方法才会使用，否则```import java.*```的时候，那就会输出很多不知来头的输出。
![static3.png](test3static3/static3.png)

只声明不使用也不可以
![static3.png](test4static4/static4.png)

