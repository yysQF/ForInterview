<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="loginOut">${sessionScope.customer.name }&nbsp;退出</a>|</li>
                <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="#"><img src="images/logo.png"></a>
    	<div class="h3_center">
        	<div class="search_box">
            	<input type="text"/>
                <span>搜索</span>
            </div>
            <p>
            	<c:forEach items="${applicationScope.category }" var="cate">
            		<a href="#">${cate.name }</a>|
            	</c:forEach>
            </p>
        </div>
        <div class="h3_right">
        	<div class="myyy">
            	个人信息
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
            	去购物车结算
                <span class="sj_right"></span>
            </div>
        </div>
    </div>
    <!--头部导航-->
    <div class="nav_top">
    	<div class="nav_top_center">
            <div>
                全部图书分类
            </div>
            <ul>
            	<c:forEach items="${applicationScope.category }" var="cate">
            		<li><a href="#">${cate.name }</a></li>
            	</c:forEach>
            </ul>
        </div>
    </div>

    <!--内容-->
    <div class="container4">
    	<!--热卖-->
    	<div class="c4_b1">
        	<ul class="c4_b1_boxes">
            	<li>
                	<img src="images/hot_1.png">
                    <div class="c4_b1_box_txt">
                    	<p>Java疯狂讲义 </p>
                        <h1>活动价：<b>￥69</b></h1>
                        <h2><a href="viewBook.html">立即抢购</a></h2>
                    </div>
                </li>
                <li>
                	<img src="images/hot_1.png">
                    <div class="c4_b1_box_txt">
                    	<p>Java疯狂讲义 </p>
                        <h1>活动价：<b>￥69</b></h1>
                        <h2><a href="viewBook.html">立即抢购</a></h2>
                    </div>
				</li>
                <li>
                	<img src="images/hot_1.png">
                    <div class="c4_b1_box_txt">
                    	<p>Java疯狂讲义 </p>
                        <h1>活动价：<b>￥69</b></h1>
                        <h2><a href="viewBook.html">立即抢购</a></h2>
                    </div>
				</li>
                <li>
                	<img src="images/hot_1.png">
                    <div class="c4_b1_box_txt">
                    	<p>Java疯狂讲义 </p>
                        <h1>活动价：<b>￥69</b></h1>
                        <h2><a href="viewBook.html">立即抢购</a></h2>
                    </div>
				</li>
            </ul>
        </div>
        <div class="c4_b2">
<!-- 由表查询得 -->
            <h1 class="c4_b2_x">
            	<a href="#">${sessionScope.fatherName } &nbsp;&nbsp;></a>
                <span><a href="#">${sessionScope.kidName }</a></span>
            </h1>

            <ul class="c4_b2_y">
            	<li>
                	<span class="search_key">价格：</span>
                    <span class="search_val">0-99</span>
                    <span class="search_del"></span>
                </li>
                <li>
                	<span class="search_key">出版社：</span>
                    <span class="search_val">清华出版社</span>
                    <span class="search_del"></span>
                </li>
            </ul>
        </div>
        <div class="c4_b3">
        	<h1></h1>
        	<div>
            	<ul class="c4_b3_search">
                	<li class="c4_b3_name">价格：</li>
                    <li class="c4_b3_vals">
                        <a href="searchBySpace?count=0">0-599</a>
                        <a href="searchBySpace?count=1">600-999</a>
                        <a href="searchBySpace?count=2">1000-1599</a>
                        <a href="searchBySpace?count=3">1600-1999</a>
                        <a href="searchBySpace?count=4">2000-2999</a>
                        <a href="searchBySpace?count=5">3000-3999</a>
                        <a href="searchBySpace?count=6">4000-4999</a>
                        <a href="searchBySpace?count=7">5000-5999</a>
                        <a href="searchBySpace?count=8">6000-6490</a>
					</li>
                </ul><ul class="c4_b3_search">
                	<li class="c4_b3_name">出版社：</li>
                    <li class="c4_b3_vals">
                        <a href="#">清华出版社</a>
                        <a href="#">清华出版社</a>
						<a href="#">清华出版社</a>
						<a href="#">清华出版社</a>
						<a href="#">清华出版社</a>
						<a href="#">清华出版社</a>
					</li>
                </ul>
            </div>
        </div>
    	<div class="c4_b4">
        	<div class="c4_b4_x">
            	<ul class="c4_b4_nav">
                	<li class="current"><a href="#">默认</a></li>
                    <li><a href="#">销量</a></li>
                    <li><a href="#">价格</a></li>
                    <li><a href="#">新品</a></li>
                </ul>
                <div class="c4_b4_search">
                	<input type="text"/><span>确认</span>
                </div>
                <div class="c4_b4_pages">

                </div>
				<div class="clear"></div>
            </div>
             <div class="c4_b4_y">
            	<ul>
                    <li><input type="checkbox"> 仅显示有货</li>
                </ul>
            </div>
       	</div>
<!-- 由表查询--商品列表 -->
        <div class="c4_b5">
        	<div class="c4_b5_content">
            	<ul class="c4_b5_c_boxes">
                	<c:forEach items="${sessionScope.books }" var="book">
                		<li class="c4_b5_c_box">
                		<!--图片 跳转详细-->
                    	<div class="c4_b5_c_box_pic">
                        	<div class="c4b5_pic_view">
                            	<a href="bookList?bookId=${book.bookId}"><img src="images/list_p1.png"></a>
                            </div>
                        </div>
                		 <!--价钱 跳转详细-->
                        <div class="c4_b5_c_box_txt">
                        	<h1>￥ ${book.price }</h1>
                        	<h2><a href="#!">${book.name }</a></h2>
                        </div>
                         <!--购买等操作-->
                        <div class="c4b5_el">
                        	<div class="c4b5_el_x">
                            	<span class="wjx01"></span>
                            </div>
                        </div>
                         <ul class="c4b5_option">
                                <li class="shopcar_box"><span class="shopcar01"></span><a href="shopCart.html">加入购物车</a></li>
                        </ul>
                        </li>
                	</c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a>
           	</p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>

</body>
</html>

</body>
</html>