<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.blog.domain.Content" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="gb2312">
<title>一条小咸鱼</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="test" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
</head>
<body>
<header>
  <div class="logo" data-scroll-reveal="enter right over 1s"><a href="/"><img src="images/logo.png"></a></div>
  <nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s"><a href="index.jsp">
      <span>首页</span><span class="en">Home</span></a>
      <a href="about.jsp"><span>关于我</span><span class="en">About</span></a>
      <a href="manshenghuo.jsp"><span>慢生活</span><span class="en">Life</span></a>
      <a href="learn.jsp"><span>碎言碎语</span><span class="en">Doing</span></a>
      <a href="edit.jsp"><span>知识填充</span><span class="en">fill</span></a>
      <a href="learn.jsp"><span>学无止境</span><span class="en">Learn</span></a>
      <a href="gbook.jsp"><span>留言</span><span class="en">Saying</span></a></nav>
</header>
<article>
  <div class="container">
    <div class="blog" data-scroll-reveal="enter top" >
      <figure>
        <ul>
          <a href="/"><img src="images/t01.jpg"><span></span></a>
        </ul>
        <p><a href="/">灯具公司复古风格PSD设计稿</a></p>
        <figcaption>此模板为PSD设计稿，复古风格。首页主要突出产品，以及公司简介。手绘灯作为头部背景图片，这个比较特别。html可以做出灯一闪一闪的效果，或者说旁边有个按钮...</figcaption>
      </figure>
      <figure>
        <ul>
          <a href="/"><img src="images/t02.jpg"><span></span></a>
        </ul>
        <p><a href="/">个人博客模板古典系列之――江南墨..</a></p>
        <figcaption>一共是四个页面，首页，图文列表，图片列表，文字内容。此模板风格为中国古典风格，山水画墨迹成就一幅江南墨卷。页面首页设计较为简单，突出文章重点。图文列表显示...</figcaption>
      </figure>
      <figure>
        <ul>
          <a href="/"><img src="images/t03.jpg"><span></span></a>
        </ul>
        <p><a href="/">美丽的茧</a></p>
        <figcaption>让世界拥有它的脚步，让我保有我的茧。当溃烂已极的心灵再不想做一丝一毫的思索时，就让我静静回到我的茧内，以回忆为睡榻，以悲哀为覆被，这是我唯一的美丽。</figcaption>
      </figure>
    </div>
      <% int i =0;%>
   <ul class="cbp_tmtimeline">
       <c:forEach  items="${sessionScope.list}" var="data">
           <%  List briefContents = (List)session.getAttribute("briefContents"); %>
                    <li>
						<time class="cbp_tmtime" ><span>${data.monthday}</span> <span>2017</span></time>
						<div class="cbp_tmicon"></div>
						<div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s" >
                            <h2>${data.title}</h2>
                            <p><span class="blogpic"><a href="/"><img src="images/t03.jpg"></a></span><%=briefContents.get(i)+"....."%></p>
                            <a href="/Watch?id=${data.id}" target="_blank"  class="readmore">阅读全文&gt;&gt;</a>
						</div>
                    </li>
           <%i++;%>
       </c:forEach>
   </ul>
  </div>
</article>
<footer>
aaaaa <a href="/">adasdasd-1</a>
</footer>
<script>

</script> 
</body>
</html>
