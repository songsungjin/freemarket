<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>
<style>
html, body, div, span, applet, object, iframe, select, input, textarea, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, textarea, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
    font-weight: normal;
    color: #333;
    font-family: '돋움',Dotum,Arial;
}
user agent stylesheet
ul, menu, dir {
    display: block;
    list-style-type: disc;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    -webkit-padding-start: 40px;
}
ul {
    list-style: none;
}
.img_area {
    float: left;
    width: 750px;
    margin-left: 23%;
    display: inline-block;
    padding-bottom: 20px;
}
.main_img_card {
    background: url("//image.hellomarket.com/web/background/img_contents_card_bg.png") no-repeat;
    width: 230px;
    height: 305px;
    padding-right: 20px;
    margin-top: 20px;
    float: left;
}
.main_img_card .thumbnail_img {
    width: 228px;
    height: 228px;
    margin-left: 1px;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    z-index: -1;
    margin-top: 1px;
    background-image: url("//image.hellomarket.com/web/common/img_itemdetail_noimage_20160104.png");
    background-size: 228px 228px;
}
.main_img_card .item_title {
    width: 210px;
    height: 38px;
    margin: 9px 10px -3px 10px;
    display: block;
    font-size: 12px;
    color: #666;
    overflow: hidden!important;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-weight: bold;
}
.main_img_card .item_price {
    float: left;
    margin: 2px 10px 0 10px;
    overflow: hidden;
    font-size: 18px;
    font-weight: bold;
    color: #00aeff;
}
.main_img_card .item_time_ago {
    float: right;
    padding-right: 10px;
    color: #959595;
    font-size: 12px;
    padding-top: 5px;
}
</style>

<div class="img_area">
	<ul class="main_img_list" id="items">
		<c:forEach items="${salelist }" var="bbs" varStatus="vs">
			<li class="main_img_card">
					<a href="bbsdetail.do?seq=${bbs.seq }">
						<img class="thumbnail_img" id="lazyload" width="228" height="228" data-th-original="${item.imageUrl}" src="//img.hellomarket.com/images/2016/item/s4/09/04/22/0159_26799580_1.jpg" />
						<p></p>
						<span class="item_title">${bbs.title }</span>
						<span class="item_price">${bbs.id }</span>
						<span class="item_time_ago">${bbs.id }</span>
					</a>
			</li>
		</c:forEach>
	</ul>
</div>

<form name="frmForm2" id="_frmForm" method="get" action="bbswrite.do">
</form>

<script type="text/javascript">
$(document).ready(function() {
	$("._hover_tr").mouseover(function() {
		$(this).children().css("background-color", "#F0F5FF");		
	}).mouseout(function() {
		$(this).children().css("background-color", "#FFFFFF");
	});
});

$("#_btnAdd").click(function() {
	$("#_frmForm").attr({"target":"_self", "action":"bbswrite.do"}).submit(); // 현재 면에서 _self에서 bbswrite.do로 이동해라
});

$("#_btnSearch").click(function() {
	$("#_pageNumber").val(0);
	$("#_frmFormSearch").attr({"target":"_self", "action":"bbslistSearch.do"}).submit();
});

function goPage(pageNumber) {
	$("#_pageNumber").val(pageNumber);
	$("#_frmFormSearch").attr("target", "_self").attr("action", "bbslist.do").submit();
}

</script>
