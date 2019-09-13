# SpringMVC

[TOC]


## 简介:

springMVC是一个web层mvc框架 ,  何谓MVC?

model   模型

view	 视图

controller 控制器



这是一种设计模式,将责任进行拆分 , 不同的组件负责不同的事情

好处:

- 结构清晰
- 更好维护( Old : 大量使用jsp的年代 ,  只应该负责显示就行了)

坏处:

- 更加复杂了

## 入门体验

1. 创建一个web项目
2. 编写web.xml,在其中注册一个特殊的servlet , 前端控制器
3. 编写一个springmvc的配置文件
    - 注册一个视图的解析器
4. 编写一个控制器
5. 编写一个结果页面

## 注解开发模式

​	基本上实现接口的方式已经是过去式了 , 采用注解开发很简单

- ==基本注解==

    - @Controller
    - @RequestMapping

- ==开发步骤==

    1. 记得配置一下基础扫描的包 , 这样配置的注解才会生效
    2. 在指定的类上面添加@Controller注解
    3. 添加@RequestMapping注解   ----   类似于前面的controller的那个名字(不同的requestHandler处理)

    当我们写上@Controller之后 , 就标记他为spring的一个组件,并且是控制器的组件 , 此时我们handlermapping会去扫描寻找扫描寻找Controller是否与之匹配 ,通过发现匹配就把这里处理的工作交给他.

    - 匹配的规则又是什么呢?

        具体的匹配就是通过请求的路径进行匹配的

        @RequestMapping(URI)

        此时就是通过这个URI进行匹配

        ==@RequestMapping==

        可以写在类上

        可以写在方法上(推荐使用二者结合方式)

        ```java
        @Controller
        @RequestMapping("/orders")
        public class OrderController {
        
            @RequestMapping("/addOrder")
            //这里的返回值为String,String就是逻辑的视图名称
            public String orderAdd(Model model){
        
                List<Order> orders = new ArrayList<>();
        
                Order order = new Order("1","平底锅",2432.1);
                Order order2 = new Order("2","大锄头",3306.0);
        
                orders.add(order);
                orders.add(order2);
                model.addAttribute("orders",orders);
        
                return "order";
            }
        }
        ```

        

## 转发与重定向

### forward和redirect的区别是什么？

### https://blog.csdn.net/weixin_37766296/article/details/80375106

- 一、**从地址栏显示来说：**
    - **forword是==服务器内部的重定向==，服务器直接访问目标地址的 url网址，把里面的东西读取出来，但是客户端并不知道，因此用forward的话，客户端浏览器的==网址是不会发生变化的==。**
    - **redirect是服务器根据逻辑，==发送一个状态码，告诉浏览器重新去请求那个地址，所以地址栏显示的是新的地址==。**
- 二、**从数据共享来说：**
    - **由于在==整个定向的过程中用的是同一个request==，因此forward会将request的信息==带到被重定向的jsp或者servlet中使用。即可以共享数据==**
    - **==redirect不能共享==**
- 三、**从运用的地方来说**
    - **==forword 一般用于用户登录的时候，根据角色转发到相应的模块==**
    - ==**redirect一般用于用户注销登录时返回主页面或者跳转到其他网站**==
- 四、**从效率来说：**
    - **==forword效率高，而redirect效率低==**
- 五、**从本质来说：**
    - ==**forword转发是服务器上的行为，而redirect重定向是客户端的行为**==
- 六、 **从请求的次数来说：**
    - ==**forword只有一次请求；而redirect有两次请求**==
- 转发到页面 :  默认到选项
- 重定向到页面 : redirect:path
- 转发到另外一个控制器 : forward:path

==重定向到jsp==

```java
    @RequestMapping("/request3")
    public String request3(HttpSession session){

        session.setAttribute("session","神庙逃亡,你妹呀,好想睡觉");
        return "redirect:/jsp/redirect.jsp";
    }
```



重定向到Controller

```java
    @RequestMapping("/request")
    public String webrequest(Model model){

        model.addAttribute("boy","boytest");

        return "redirect:/web/request";
    }
```



## 关于SpringMVC访问web元素

- request

- session

- application

    可以通过模拟的对象完成操作,也可以使用元素的ServletAPI完成 , 直接在方法当中入参即可.

## 注解详解

### RequestMapping

- value写的是路径 , 是一个数组形式 , 可以匹配多个路径
- path 是value的别名 , 所以二者人选其一 , 他们的作用是一样的
- method 是可以指定访问的请求的类型 , 比如get post 它也可以写成一个数组的形式.

```java

```

- params 可以指定参数,你还可以限定参数的特征 , 必须对于某个值 , 不等于某个值也行
- headers 能够影响浏览器的行为
- consumers 消费者 , 媒体类型 , 可以限定必须为application / json;charset=UTF-8
- produces 产生的响应的类型

### 关于请求路径的问题

springmvc 支持 ant 风格

- localhost/web/m2==?==    任意的字符 , 斜杠除外
- localhost/web/m1==*==    0-n个字符 , 任意个字符都可以 , 斜杠除外
- localhost/web/m1/==**==   支持任意层路径    /m1** 这样的效果等同于m1后面的任意多个字符

### @Getmapping 与 @Postmapping...... 

- ==getmapping== ：限定了只支持get请求
- ==postMapping== : 限定了只支持post请求

### 对于非get post请求的支持

对于非get post请求的支持 , 需要有额外的内容添加 , 要增加一个过滤器来额外处理

- 过滤器

- 返回的不再是页面而是数据

    ```xml
        <!--注册一个支持所有http请求类型的过滤器-->
        <filter>
            <filter-name>hiddenHttpMethodFilter</filter-name>
            <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>hiddenHttpMethodFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
    ```

- 表单提交里面还有添加一个隐藏的参数

    name = “_method”      value = “DELETE”

    

### ==@Responsebody==

- 返回数据的 , 一般情况下返回json格式

    ```java
    //@Controller
    @RestController // == @Controller+@ResponseBody  当整个Controller都是用于返回json的时候使用
    @RequestMapping("/json")
    public class JsonController {
    
        @RequestMapping("/m1")
        //    @ResponseBody
        public Order m1() {
    
            Order order = new Order("1", "leike", 12.3);
    
            return order;
        }}
    ```

    

### ==@ModelAttribute==

- 使用方式一      如果某些对象从头到尾每次请求当中都要存在 , 不消失  , 就适合这么用.

    ```java
    @Controller
    @RequestMapping("/user")
    public class UserController2 {
    
        // 在controller里面的任意一个处理具体方法之前都会执行
        @ModelAttribute
        public User init(){
            System.out.println("进入init...");
            User u = new User();
            u.setName("王菲");
            return u;
        }
    
        @RequestMapping("/login")
        public String login(Model model){
            System.out.println(model.containsAttribute("u"));
            System.out.println(model.containsAttribute("user"));
            System.out.println(model.containsAttribute("2345632"));
            return "/msg";
        }
    
    }
    ```

- 使用方式二

    ```java
        @ModelAttribute
        public void init(Model model){
            System.out.println("进入init...");
            User u = new User();
            u.setName("王菲");
            model.addAttribute("user",u);
        }
    ```

- 使用方式三    如果没有传递这个model过来 , name方法上加了@Modelattribute的  为你提供 , 如果你传了则用传过来的值

    ```java
        @ModelAttribute
        public void init(Model model){
            System.out.println("进入init...");
            User u = new User();
            u.setName("王菲");
            model.addAttribute("user",u);
        }
        @RequestMapping("/login")
        public String login(@ModelAttribute("user") User user){
            System.out.println(user);
    //        System.out.println(model.containsAttribute("u"));
    //        System.out.println(model.containsAttribute("user"));
    //        System.out.println(model.containsAttribute("2345632"));
            return "/msg";
        }
    ```

    

### ==@SessionAttributes==

- 这个用在类上面 , 他会将模型自动填充到会话里面去

### ==@SessionAttribute==

- 要求当前这次访问当中的会话里面必须要有某个对象

### ==@RequestParam==

### ==@RequestBody==

- json数据 , 不是通过form表单传递

- ajax({

    ​	data :

    }) 

### ==@InitBinder==

数据转换 , 将日期转换处理

### ==@PathVariable==

- restful风格
- 详情参考罗伊菲尔丁在他的博士论文.

![](C:\Users\leike\Documents\我的md笔记\images\PathVariable方式请求.png)

### ==@RestController==--返回json数据时候用

- 相当于于@Controller+@ResponseBody

## 关于静态资源访问的问题

由于我们的servlet设置乐URL匹配方式为 ==/== 所以 , 他将我们的静态资源也当做了一个后台的请求

比如http://localhost:8080/springMVC/static/css/index.css

- 它尝试去匹配一个static/css/index.css的Controller的RequestMapping的组合 , 因为没有 , 所以404 .
- 解决方式很多 , 最简单的 , 让springmvc单独处理 , 将这些交给容器的默认servlet处理 , 就不让DispatcherServlet来处理.

解决方式一   在springMVC配置文件中加入

```xml
<!--默认的servlet处理者
    只加这个的话相当于全部让他处理了-->
<mvc:default-servlet-handler/>
<!-- 为了让controller生效,要加这个注解驱动-->
<mvc:annotation-driven/>
```

解决方式二   通过映射关系描述 , 一 一 对编写规则	

```xml
<mvc:resources mapping="/static/css/*" location="/static/css/"/>
<!-- 为了让controller生效,要加这个注解驱动-->
<mvc:annotation-driven/>
```

解决方式三  自行在web.xml定义映射规则

## 关于post请求中文乱码问题解决

添加一个过滤器即可 , springMVC提供了一个非常好的字符编码过滤器 , 所以我们注册即可(建议放在所有过滤器最前面) . 

```xml
<filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <!-- 指定字符编码 -->
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```



## 关于form表单提交数据的方式

### 方式一    通过属性名字进行绑定

- 通过属性的名称就行绑定 , 可以完成数据传递 .

- 页面当中表单元素的name值要和后台的形参名字保持一致 . 

- 如果有多个 , 多个形参按名字绑定即可 , 当传入的值较多的时候.

    ```html
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>user_put</title>
    </head>
    <body>
        <form action="${ctx}/user/put/" method="post">
            <input type="hidden" name="_method" value="put">
            <input type="text" name="name">
            <br>
            <input type="password" name="password">
            <input type="submit" value="提交">
        </form>
    </body>
    </html>
    ```

    ```java
    @Controller
    @RequestMapping("/user")
    public class UserController {
    
        @PutMapping("/put")
        //需要额外的json包支持
        @ResponseBody
        public String put(String name,String password){
    
            System.out.println(name+"   "+psword);
    //        Map<String, String> map = new HashMap<>();
    //        map.put("msg","ok");
    
            return "ok";
        }
    }
    ```

    

### 方式二  利用@RequestParam

- jsp页面不变

- 后台

    ```java
    @Controller
    @RequestMapping("/user")
    public class UserController {
    
        @PutMapping("/put")
        //需要额外的json包支持
        @ResponseBody
        public String put(@RequestParam("name") String name,@RequestParam("password") String psword){
    
            System.out.println(name+"   "+psword);
    //        Map<String, String> map = new HashMap<>();
    //        map.put("msg","ok");
    
            return "ok";
        }
    }
    ```

### 方式三 直接使用pojo形式传递

- jsp页面不变

- 后台

    ```java
        @PutMapping("/put1")
        //需要额外的json包支持
        @ResponseBody
        public String put(User user){
    
            System.out.println(user);
    //        Map<String, String> map = new HashMap<>();
    //        map.put("msg","ok");
            return "ok";
        }
    ```

### 方式四 -- 关于form表单提交日期格式数据问题的处理

1. 处理日期 ( 没有时间 )

    ```java
    @InitBinder("user")
    public void init(WebDataBinder dataBinder) {
        //这里指定什么格式 , 前台就只能传什么格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
    @PutMapping("/put2")
    //需要额外的json包支持
    @ResponseBody
    public String put2(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "ok";
    }
    //通过initBinder指定了user名字和modelAttribute里面user绑定
    
    ```

2. 不指定名字,根据数据类型一样可以分析解析转换成功

3. 在属性上面添加注解 

    ```java
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    
    ```

## json数据交互

### 额外依赖

```xml
    <!--json依赖-->
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.9.1</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.9</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.9.9</version>
    </dependency>
<!-- https://mvnrepository.com/artifact/net.sf.json-lib/json-lib -->
<dependency>
    <groupId>net.sf.json-lib</groupId>
    <artifactId>json-lib</artifactId>
    <version>2.4</version>
    <classifier>jdk15</classifier>
</dependency>
<!--添加处理json为javabean-->
<!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-core-asl -->
<dependency>
    <groupId>org.codehaus.jackson</groupId>
    <artifactId>jackson-core-asl</artifactId>
    <version>1.9.13</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
<dependency>
    <groupId>org.codehaus.jackson</groupId>
    <artifactId>jackson-mapper-asl</artifactId>
    <version>1.9.13</version>
</dependency>
<!--添加处理json为javabean ==end== -->

```

另外记得添加

```xml
	<!--激活springmvc消息转换功能-->
    <mvc:annotation-driven/>

```

### JSON数据返回前台以及如何解析

#### Json后台返回

- 返回POJO

    ```java
    @RequestMapping("/m1")
    //    @ResponseBody
    public Order m1(){
    
        Order order = new Order("1", "leike", 12.3);
    
        return order;
    }
    
    ```

    

- 返回Map

    ```java
    @RequestMapping("/m2")
    //    @ResponseBody
    public Map<String,Object> m2(){
    
        Map<String, Object> map = new HashMap<>();
        Order order = new Order("1", "lk", 12.3);
        Order order1 = new Order("2", "lk2", 12.3);
        Order order2 = new Order("3", "lk3", 12.3);
    
        map.put("1",order);
        map.put("2",order1);
        map.put("3",order2);
    
        return map;
    }
    
    ```

    

- 返回List

    ```java
    @RequestMapping("/m3")
    //    @ResponseBody
    public List<Order> m3(){
    
        List<Order> list = new ArrayList<>();
        Order order = new Order("1", "lk", 12.3);
        Order order1 = new Order("2", "lk2", 12.3);
        Order order2 = new Order("3", "lk3", 12.3);
    
        list.add(order);
        list.add(order1);
        list.add(order2);
        return list;
    }
    
    ```

    

- 返回数组

    ```java
    @RequestMapping("/m4")
    //    @ResponseBody
    public Order[] m4() {
    
        Order[] list = {new Order("1", "lk", 12.3),
                        new Order("2", "lk2", 12.3),
                        new Order("3", "lk3", 12.3)};
    
        return list;
    }
    
    ```

    

#### Json前台解析

- 解析返回的pojo

    ```js
    $('#b1').click(function () {
        $.ajax({
            url:'${ctx}/json/m1',
            type:'post',
            success:function (data) {
                alert(data.name);
                alert(data.id);
                alert(data.price);
            }
        })
    })
    
    ```

- 解析返回的Map

    同上

- 解析返回的List

    ```js
    $('#b3').click(function () {
        $.ajax({
            url: '${ctx}/json/m3',
            type: 'post',
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    alert(data[i].name);
                }
            }
        })
    })
    
    ```

- 解析数组

    同上

### JSON数据如何使用Ajax提交到后台,后台如何解析

- 设置请求格式为json

```js
contentType:"application/json;charset=utf-8"

```

- 前台写法  --  发送一个pojo

    ```js
    $(function () {
        $('#b').click(function () {
            var obj={
                id:'1',
                name:'爷们',
                price:'22.1'
            }
            $.ajax({
                url:'${ctx}/json2/add',
                type:'post',
                contentType: "application/json",
                data:JSON.stringify(obj),
                succese:function (data) {
                    alert(data);
                }
            })
        })
    })
    
    ```

    

- 后台写法

    ```java
    @Controller
    @RequestMapping("/json2")
    public class JsonController2 {
    
        @RequestMapping("/add")
        @ResponseBody
        public String add(@RequestBody Order order){
            System.out.println(order);
            return "ok";
        }
    }
    
    ```

    ps : 一定要记得添加@requestBody,否则无法解析

- 发送一组pojo

    - 前台

        ```js
        $('#b2').click(function () {
            var obj1={
            id:'1',
                name:'爷们',
            price:'22.1'
            }
            var obj2={
                id:'2',
            name:'爷们2',
                price:'22.13'
            }
            var arr = new Array();
            arr.push(obj1);
            arr.push(obj2);
            $.ajax({
                url:'${ctx}/json2/addList',
                type:'post',
                contentType: "application/json",
                data:JSON.stringify(arr),
                success:function (data) {
                    if (data.code == 2000){
                        alert("成功了");
                    }
                }
            })
        })
        
        ```

    - 后台

        ```java
        @RequestMapping("/addList")
        @ResponseBody
        public Map<String,Integer> addList(@RequestBody List<Order> orders){
            System.out.println(orders);
            Map<String,Integer> map = new HashMap<>();
            map.put("code",2000);
            return map;
        }
        
        ```

## xml数据交互

对于很多第三方开发 , 还是有很多会采用xml作为数据交互 , 比如微信.

1. 添加额外的依赖

    ```xml
    <dependency>
       <groupId>com.fasterxml.jackson.dataformat</groupId>
        <artifactId>jackson-dataformat-xml</artifactId>
        <version>2.9.9</version>
    </dependency>
    
    ```

2. 方法返回数据类型定义

    ```java
    //描述生产的类型 , 返回类型的描述 , 返回什么数据
    @RequestMapping(value = "/m1",produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User m1(){
        // 希望springmvc将数据转换为xml形式user
        User user = new User("好","11",null);
    
        return user;
    }
    
    ```

## 文件上传

### apache 上传组件方案---单文件上传

- 添加依赖

    ```xml
    <!--文件上传依赖-->
    <dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>1.3.3</version>
    </dependency>
    
    ```

- 在springmvc中注册一个文件上传解析器

    ```xml
    <!--文件上传解析器,
            id必须是multipartResolver原因是源码写死为这个名字-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!--定义最大长度的大小 总的  单位为  bytes-->
        <property name="maxUploadSize" value="10241024"/>
        <!--指定上传编码-->
        <property name="defaultEncoding" value="UTF-8"/>
        <!--指定单个文件最大上传大小-->
        <property name="maxUploadSizePerFile" value="2000000"/>
    </bean>
    
    ```

- 准备一个上传的页面

    ```xml
    <form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="file">
        <br>
            <input type="submit" value="提交">
    </form>
    
    ```

    

- 后台处理程序

    ```java
    //入参就可以代表上传的文件
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, Model model) {
        /**
             * 1.传到那里去
             * 2. 传什么东西
             * 3. 传的细节
             */
        // 1.不为空才上传
        if (!multipartFile.isEmpty()) {
            //2.获取原始的文件名
            String originalFilename1 = multipartFile.getOriginalFilename();
            //3. 先截取源文件的文件名前缀 , 不带后缀
            String fileNamePrefix = originalFilename1.substring(0, originalFilename1.lastIndexOf("."));
            //4. 加工处理文件名 , 将原文件名+时间戳
            String newfileNamePrefix = fileNamePrefix+new Date().getTime();
            System.out.println(new Date().getTime());
            //5. 得到新文件名
            String newFilename = newfileNamePrefix+originalFilename1.substring(originalFilename1.lastIndexOf('.'));
            //6. 构建文件对象
            File file = new File(uploadPath + newFilename);
            //7.上传
            try {
                multipartFile.transferTo(file);
                model.addAttribute("fileName",newFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "file/uploadSuc";
    }
    
    ```

### 多文件上传

- 配置同上

- 前台

    ```html
    多些几个<input>就完事
    
    ```

- 后台

    ```java
    把MultipartFile换成MultipartFile[]
    遍历这个数组
    完事
    
    ```

## 文件下载

```java
@Controller
@RequestMapping("/download")
public class DownloadController {

    private static String parentPath = "D:"+ File.separator;

    @RequestMapping("/down")
    @ResponseBody
    public String down(HttpServletResponse response){
        //        response.setCharacterEncoding("UTF-8");
        //通过输出流写到客户端 , 浏览器
        // 1 获取我就爱你下载名
        String filename = "夜景.jpg";
        // 2 构建一个文件对象,通过Paths工具类获取一个Path对象
        Path path = Paths.get(parentPath, filename);
        // 3 判断它是否存在
        if (Files.exists(path)){
            //存在则开始下载
            //通过response设定他的响应的类型
            // 4 获取文件的后缀
            String fileSuffix = filename.substring(filename.lastIndexOf(".")+1);
            // 5 设置contenType , 只有指定它才能去下载
            response.setContentType("application/"+fileSuffix);
            // ISO8859-1
            try {
                response.addHeader("Content-Disposition","attachment; filename="+new String(filename.getBytes("UTF-8"),"ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 6 通过Path写出去 -- end
            try {
                Files.copy(path,response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return "未找到资源文件";
        }
        return "ok";
    }
}

```

## 拦截器

- springmvc提供了拦截器 , 类似于过滤器 , 他将在我们的请求距离处理之前先做检查 , 有权决定 , 接下来是否继续 , 对我们的请求进行加工,

- 可以设计多个拦截器

- 通过实现HandlerInterceptor , 这是一个接口

    定义了非常重要的三个方法

    - 前置处理
    - 后置处理
    - 完成处理

### 案例一

拦截器实现方法耗时统计与警告.



后台代码

```java
package com.leike.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 18:52
 */

/**
 * 方法耗时统计拦截器
 */
public class MethodTimerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(MethodTimerInterceptor.class);


    //前置功能 , 开始 - 结束 , 两个点减法得到耗时
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 定义开始时间
        long start = System.currentTimeMillis();
        //2 将其存到请求域当中
        request.setAttribute("start",start);
        // 返回true , 才会找到下一个拦截器 , 如果没有下一个拦截器 , 则去Controller
        LOGGER.info(request.getRequestURI()+",请求到达");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 1取出start
        long start = (long) request.getAttribute("start");
        // 2得到end
        long end = System.currentTimeMillis();
        // 3记录一下耗时
        long spendTime = end - start;
        if (spendTime >= 1000){
            LOGGER.warn("方法耗时严重 , 请及时处理,耗时: "+spendTime+"毫秒");
        }else {
            LOGGER.info("方法耗时:"+spendTime+"毫秒,速度正常");
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}


```

springmvc的配置

```xml
<mvc:interceptors>
    <mvc:interceptor>
        <!--
                /* 的写法只能拦截/name的方法 , 只能由一层 , 不是多层拦截
            -->
        <mvc:mapping path="/**/*"/>
        <bean class="com.leike.interceptors.MethodTimerInterceptor">
        </bean>
    </mvc:interceptor>
</mvc:interceptors>

```

### 案例二

会话拦截器 , 做用户检查



后台代码 

```java
package com.leike.interceptors;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 21:34
 */

import com.leike.pojo.Use;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会话拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(SessionAttributes.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object use = request.getSession().getAttribute("SESSION_USER");
        if (use == null){
            LOGGER.warn("你不具备权限 , 请先登录");
            return false;
        }
        if (use instanceof Use){
            Use u = (Use) use;
            u.setPwd(null);
            request.getSession().setAttribute("SESSION_USER",u);
            LOGGER.info(u.getName()+"处于登录状态 , 可以执行操作");
            return true;
        }else {
            LOGGER.warn("请不要搞事 , 请先登录");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}

```

springmvc配置

```xml
<mvc:interceptor>
    <!--
                只想拦截/user/**/*
                还需要开放登录权限
            -->
    <mvc:mapping path="/**/*"/>
    <!--排除登录的这个URI-->
    <mvc:exclude-mapping path="/use/login"/>
    <bean class="com.leike.interceptors.SessionInterceptor">
    </bean>
</mvc:interceptor>

```

将其配置在mvc:interceptors节点之下即可

## 拦截器执行器顺序的问题

- 如果有n个拦截器 , 并且都能拦截到某个URL的时候 , 执行顺序问题.

- 在springmvc当中拦截器定义的顺序是有关系的 , 配在前面的优先拦截,按照顺序来.

    i1

    i2

    i3

    前置处理 i1>i2>i3

    后置处理 i3>i2>i1

### 拦截器与过滤器的比较

- 相似点

    都有优先处理请求的权利 , 可以决定是否将请求转移到实际处理的控制器处 , 都可以对请求或者会话当中数据进行加工

- 不同点

    - ==拦截器==可以做前置处理 , 也可以做后置处理 , 还可以完成后处理 , 控制的更细一些,==过滤器==只负责前面的行为而已
    - 过滤器优先执行 .
    - 过滤器是servlet规范里面的组件.
    - 拦截器都是框架自己额外添加的组件.

