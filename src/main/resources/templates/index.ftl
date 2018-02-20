<!DOCTYPE HTML>
<html>
	<head>
		<title>CLOUD BLOG</title>
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
	<body>

		<!-- Wrapper -->
			<div id="wrapper">
				<#include "common/header.ftl">


				<!-- Main -->
					<div id="main">

						<!-- 文章预览 -->
						<#list articleInfoPage.content as article>

							<article class="post">
								<header>
									<div class="title">
										<h2><a href="/article/${article.getArticleId()}">${article.articleTitle}</a></h2>
										<p>${article.articleDescription}</p>
									</div>
								</header>
								<p>${article.articleShort!}</p>
								<footer>
									<ul class="actions">
										<li><a href="/article/${article.getArticleId()}" class="button big">Reading</a></li>
									</ul>
									<ul class="stats">
										<li>${article.createTime}</li>
										<li><a href="#" class="icon fa-heart">${article.articleScn}</a></li>
										<li><a href="#" class="icon fa-comment">${article.articleRvn}</a></li>
									</ul>
								</footer>
							</article>

						</#list>


						<!-- 翻页设置 -->
                        <ul class="test pull-right">


							<#if currentPage lte 1>

							    <li class="disabled"><a href="#">上一页</a> </li>
							<#else >
								<li><a href="javascript:void(0);" onclick="post('/',{page:${currentPage - 1},size:${size}})">上一页</a></li>
							</#if>
							<#list 1..articleInfoPage.getTotalPages() as i>
								<#if currentPage == i>
								    <li class="disabled"><a href="#">${i}</a></li>
								<#else >
									<li><a href="javascript:void(0);" onclick="post('/',{page:${i},size:${size}})">${i}</a></li>
								</#if>
							</#list>
							<#if currentPage gte articleInfoPage.getTotalPages()>
                        	<li class="disabled"><a href="#">下一页</a></li>
							<#else>
                       		 <li><a href="javascript:void(0);" onclick="post('/',{page:${currentPage + 1},size:${size}})">下一页</a></li>
							</#if>

                        </ul>
					</div>

				<!-- Sidebar -->
					<section id="sidebar">

						<!-- 个人标题部分 -->
							<section id="intro">
								<a href="#" class="logo"><img src="blog/images/head.png" alt="" /></a>
								<header>
									<h2>CLOUD </h2>
									<p>在你想要放弃的时候，想想是什么让你当初坚持走到了这里。</p>
								</header>
							</section>

						<!-- 主推文章 -->
							<section>
                                <h2>置顶博文</h2>
								<div class="mini-posts">
									<!-- Mini Post -->
										<article class="mini-post">
											<header>
												<h3><a href="/article/${homeArticle.articleId}">${homeArticle.articleTitle}</a></h3>
												<time class="published" datetime="2015-10-20">October 20, 2017</time>
											<!--	<a href="#" class="author"><img src="images/avatar.jpg" alt="" /></a> -->
											</header>
											<a href="#" class="image"><img src="${homeArticle.articlePicture!}" alt="" /></a>
										</article>
								</div>
							</section>


                        <!-- 标签 -->
                       		 <section>
                                 <h2 >Tags</h2>
								 <div id="tag_cloud-3" class="widget widget_tag_cloud">
                           		 <div class="tagcloud">
									 <#list allType as type>
									      <a href="/Tag/${type}">${type}</a>
									 </#list>
								 </div>
                        </div>
                            </section>

                        <!-- 关于 http://www.cssmoban.com/ -->
                        <section class="blurb">
                            <h2>About</h2>
                            <p>第二名就意味着你是头号输家！<br>
                                Second place means you is the number one loser!</p>
                            <ul class="actions">
                                <li><a href="https://v.qq.com/x/cover/i0bre9971701sow/q001827eh3f.html" class="button">Learn More</a></li>
                            </ul>
                        </section>

						<!-- 联系方式 -->
							<section id="footer">
								<ul class="icons ">
									<li><a href="mailto:837167592@qq.com" class="fa-envelope"><span class="label">Email</span></a></li>
									<li><a href="http://wpa.qq.com/msgrd?v=3&uin=837167592&site=qq&menu=yes" class="fa-qq"><span class="label">QQ</span></a> </li>
								</ul>
							</section>

					</section>

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