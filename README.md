# SpringMVC



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
- 

### ==@ModeraAttribute==

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

### ==@PathVariable==

- restful风格
- 详情参考罗伊菲尔丁在他的博士论文.

![](C:\Users\leike\Documents\我的md笔记\images\PathVariable方式请求.png)



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

    
