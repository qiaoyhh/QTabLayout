## QTabLayout

### 效果

![](https://github.com/qiaoyhh/QTabLayout/blob/master/app/src/main/res/mipmap-xxhdpi/qtabtayout.gif)

### 本库目前主要功能

一、实现TabLayout指示线过渡动画，仿照UC浏览器、新浪微博。

二、实现TabLayout固定指示线长度，默认为所有Tab项中最短的长度。

三、实现Tab逐渐改变颜色。

一、在app目录的build.gradle中增加配置

```
gradle
    dependencies {
        implementation 'com.github.qiaoyhh:QTabLayout:1.0'
    }
```


二、XML文件中使用
```
 <com.qyh.qtablayoutlib.QTabLayout
        android:id="@+id/tablayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ffffff"
        app:q_tabIndicatorAnimation="true"
        app:q_tabIndicatorColor="#ee8200"
        app:q_tabSelectedTextColor="#ee8200"
        app:q_tabTextColor="#000000"
        app:q_tabIndicatorWidth="20dp"
        app:q_tabTextSize="15sp" />
```

### 主要属性：

| 属性                  | 含义                              | 
| ------------------------------| ------------------------| 
| q_tabIndicatorAnimation       | 是否使用指示器过渡动画	      | 
| q_tabIndicatorChangeColor     | 是否使用tab文字颜色渐变     |  
| q_tabIndicatorColor           | 指示器颜色                |  
| q_tabIndicatorWidth           | 指示器长度                |  
| q_tabSelectedTextColor        | tab选中文字颜色	          | 
| q_tabTextColor                | tab默认文字颜色           | 
| q_tabTextSize                 | tab默认文字大小           | 
 



