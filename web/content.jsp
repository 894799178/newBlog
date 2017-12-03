<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="gb2312">
    <title>杨青个人博客 - 一个站在web前端设计之路的女技术员个人博客网站</title>
    <meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
    <meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
    <link href="css/base.css" rel="stylesheet">
    <link href="css/about.css" rel="stylesheet">
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
        <div class="banner">
            <p data-scroll-reveal="enter top over 2s">我们不停的翻弄着回忆，却再也找不回那时的自己</p>
            <p data-scroll-reveal="enter left over 2s after 1s">人生，是一场盛大的遇见。若你懂得，就请珍惜。</p>
            <p data-scroll-reveal="enter bottom over 2s after 2s">无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候.</p>
        </div>
        <div class="memorial_day">
            <div class="time_axis"></div>
            <ul>
                <li class="n1"><a href="/">1</a>
                    <div class="dateview">2017</div>
                </li>
                <li class="n2"><a href="/">2</a>
                    <div class="dateview">2017-01-12</div>
                </li>
                <li class="n3"><a href="/">3</a>
                    <div class="dateview">2017-06-08</div>
                </li>
                <li class="n4"><a href="/">4</a>
                    <div class="dateview">2017-08-08</div>
                </li>
                <li class="n5"><a href="/">5</a>
                    <div class="dateview">2017-09-08</div>
                </li>
            </ul>
        </div>
        <div class="about left">
            <h2>知识积累</h2>
            <ul>
                    ${sessionScope.str}
            </ul>
        </div>
    </div>
    </aside>
</article>
<footer> Emmmm <a href="/">一条小咸鱼~</a> </footer>
<script>
    if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
        (function(){
            window.scrollReveal = new scrollReveal({reset: true});
        })();
    };
</script>
</body>
</html>
