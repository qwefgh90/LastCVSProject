<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /**
* @Class Name : board.jsp
*
* @author 조계환
* @since 2018. 9. 05
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
*
* </pre>
*/ -->
<style>
.result_search .service {
	overflow: hidden;
}

.service .result_txt {
	overflow: hidden;
	margin-bottom: 15px;
}

.service .result_txt h4 {
	background: url("../images/icon/bullet_purple.png") no-repeat 0 0;
	float: left;
	font-size: 1.231em;
	font-weight: normal;
	padding-left: 17px;
}

.service .result_txt p {
	float: right;
}

.service .result_txt span {
	color: #782d91;
	text-decoration: underline;
}

.service .list_service {
	overflow: hidden;
	margin-bottom: 25px;
}

.service .list_service ul {
	overflow: hidden;
	border-top: 2px solid #1e1e1e;
	border-bottom: 1px solid #dadada;
	height: 140px;
}

.service .list_service ul li {
	background: url("../images/common/bg_diagonal_228.gif") repeat-x 0 0;
	display: block;
	float: left;
	border-left: 1px solid #dadada;
	height: 140px;
	width: 119px;
}

.service .list_service ul li:first-child {
	border-left: none;
}

.list_service .group_service {
	overflow: hidden;
	margin: 0 auto;
	padding-top: 20px;
	width: 70px;
}

.list_service .group_service a {
	display: block;
	overflow: hidden;
	text-align: center;
}

.list_service .group_service .emblem {
	margin-bottom: 14px;
	height: 65px;
	width: 65px;
}

.list_service .group_service .emblem.on img {
	margin-top: -66px;
}

.list_service .group_service .text {
	letter-spacing: -1px;
	line-height: 1em;
}

#demoFont {
	font-family: "Arial Black", Gadget, sans-serif;
	font-size: 15px;
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
	text-align: center;

}

#demoFonts {
	font-family: Gadget, sans-serif;
	font-size: 13px;
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
	text-align: center;

}

.services{

	text-align: center;
}

.search {
	text-align: right;
}

.searchs {
	padding: 5px;
	margin: 0px;
}
</style>

<link href="/css/login/common/JKH.css" rel="stylesheet">

<script>
$(function() {
	$("#click").on("click", function() {
		$("#bd_id").val($(this).data("no"));
		$("#frm").submit();
	});


	$("#eventDetali").on("click",function(){
		$()
	});

	$("#search").on("click",function(){ // 제목 / 제목+내용 / 내용 / 작성자 중 선택 후 검색창을 누른다.
		alert($("#i option:selected").val());
		alert($("#i_search").val());
		$("#boardGo").submit(); // 검색 결과로 이동한다.
	});

});	
</script>

<!-- products-breadcrumb -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/user/main' />">Home</a><span>|</span></li>
			<li>공지사항</li>
		</ul>
	</div>
</div>
<!-- //products-breadcrumb -->

<!-- banner -->

<form action="/board/view" method="post" id="frm">
	<input type="hidden" name="bd_id" id="bd_id">
</form>



<div class="banner">
		<!-- services -->
		<div class="services">
			<h3>이벤트&행사</h3>
				<form action="/board/eventSearch" id="boardGo" method="post">
				<div class="search">
					<select id="i" name="i">
						<option value="1">제목</option>
						<option value="2">내용</option>
						<option value="3">제목+내용</option>
						<option value="4">작성자</option>
					</select>
					<input name="i_search" id="i_search" type="text">
					<button id="search" type="button" class="btn btn-default">검색</button>
					<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${bd_kind_id}"> 
				</div>
				</form>
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr >
									<th id="demoFont">번호</th>
									<th id="demoFont">제목</th>
									<th id="demoFont">작성자</th>
									<th id="demoFont">작성일</th>
									<th id="demoFont">조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${boardpage}" var="vo">
									<c:if test="${vo.bd_del=='N'}">
										<tr data-no="${vo.tot_cnt}" id="click">
											<td id="demoFonts">${vo.tot_cnt}</td>
											<td id="demoFonts">${vo.bd_title}</td>
											<td id="demoFonts">${vo.mem_id}</td>
											<td id="demoFonts">${vo.bd_date}</td>
											<td id="demoFonts">${vo.bd_views}</td>
										</tr>
									</c:if>

									<c:if test="${vo.bd_del=='Y'}">
										<tr data-no="${vo.tot_cnt}">
											<td id="demoFonts">${vo.tot_cnt}</td>
											<td id="demoFonts">삭제된 게시물 입니다</td>
											<td id="demoFonts">${vo.mem_id}</td>
											<td id="demoFonts">${vo.bd_date}</td>
											<td id="demoFonts">${vo.bd_views}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
						
					</div>
						<div class="text-center" id="page">
							<ul class="pagination">${pageNavi}</ul>
						</div>
				</div>
				<div class="col-md-10 w3ls_service_grid_left">
				<div class="search">
				</div>							
			</div>
		</div>

<!-- //services -->
<div class="clearfix"></div>
