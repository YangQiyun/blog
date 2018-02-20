<!DOCTYPE HTML>
<html>
	<head>
        <title>Future Imperfect by HTML5 UP</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]>
        <script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 9]>
        <link rel="stylesheet" href="assets/css/ie9.css"/><![endif]-->
        <!--[if lte IE 8]>
        <link rel="stylesheet" href="assets/css/ie8.css"/><![endif]-->




    </head>
	<body >

		<!-- Wrapper -->
			<div id="wrapper">
<#include "../common/header.ftl">
                <!-- Main -->
					<div id="main">

						<!-- 文章预览 -->

                        <#list articleList as article>


                        <article class="post">
                                <div class="title">
                                    <h2><a href="#">${article.articleTitle}</a></h2>
                                    <p>${article.articleDescription}</p>
                                </div>
                             <footer >
                                 <ul class="actions ">
                                     <li><a href="/article/${article.articleId}" class=" button small-caps">Continue Reading</a></li>
                                 </ul>
                                <ul class="stats ">
                                    <li><a href="#">${article.articleType}</a></li>
                                    <li><a href="#" class="icon fa-heart">${article.articleScn}</a></li>
                                    <li><a href="#" class="icon fa-comment">${article.articleRvn}</a></li>
                                </ul>
                            </footer>
                        </article>
                        </#list>

                    </div>
    <!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/skel.min.js"></script>
    <script src="assets/js/util.js"></script>
    <!--[if lte IE 8]>
    <script src="assets/js/ie/respond.min.js"></script><![endif]-->
    <script src="assets/js/main.js"></script>
    <script src="assets/js/my.js"></script>
    </body>
</html>

