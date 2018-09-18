﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Gentelella Alela! |</title>


<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="../build/css/custom.min.css" rel="stylesheet">

<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<!--             <div class="page-title">
              <div class="title_left">
                <h3>Invoice <small>Some examples to get you started</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div> -->

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							입고 리스트 내역 <small>현재 선택한 입고 리스트의 상세 내역 페이지 입니다.</small>
						</h2>
						<!--                     <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul> -->
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<!-- 최상단 부분 날짜와 입고 상품 내역이 시작되는 부분  -->
						<section class="content invoice">
							<!-- title row -->
							<div class="row">
								<div class="col-xs-12 invoice-header">
									<h1>
										<i class="fa fa-globe">입고 상품 내역</i> 
										<small class="pull-right">
											날짜:${vo.supply_date}
										</small>
									</h1>
								</div>
								<!-- /.col -->
							</div>
							<!-- 상단부분 입고되어 온곳부터 입고 편의점 정보 출력 부분 + 수불 바코드 출력 부분  -->
							<div class="row invoice-info">
								<div class="col-sm-4 invoice-col">
									From
									<address>
										<strong>gogoCVS</strong>
										<br>관리자(본사)
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									To
									<address>
										<strong>${supplyMemInfo.mem_cvs_name}</strong> 
										<br>${supplyMemInfo.mem_addr}  <!-- 편의점 주소 -->
										<br>Phone: ${supplyMemInfo.mem_cvs_tel}	<!-- 편의점 연락처 -->
										<br>담당자 : ${supplyMemInfo.mem_name}	<!-- 점주 이름 -->
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									<b>수불바코드 : ${vo.supply_bcd}</b> <br> <br> <br>
									<br>
								</div>
								<!-- /.col -->
							</div>
							<!-- 상단 부분 끝 -->
							<!-- /.row -->

							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 -->
							<div class="row">
								<div class="col-xs-12 table">
									<table class="table table-striped">
										<thead>
											<tr><th>번호</th>
												<th style="width: 20%">상품이름</th>
												<th style="width: 30%">상품코드</th>
												<th style="width: 30%">비고</th>
												<th>수량</th>
												<th>가격</th>
												<th>합계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${prodList}" var="vo">
												<tr>
													<td>${vo.rnum}</td>
													<td>${vo.prod_name}</td> <!-- 상품이름 -->
													<td>${vo.prod_id}</td>	<!-- 상품코드 -->
													<td>${vo.splylist_info}</td>				<!-- 비고 -->
													<td>${vo.splylist_sum}</td>	<!-- 수량 -->
													<td>￦${vo.prod_price}</td>	<!-- 가격 -->
													<td>￦${vo.splylist_sum * vo.prod_price}</td>	<!-- 합계 -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="text-center" id="page">
										<ul class="pagination">${pageNavi}</ul>
									</div> 
								</div>
							</div>
							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 끝-->
							
							<!-- 하단 부분 -->
							<div class="row">
								<!-- 조계환 왼쪽 하단 입고 상태를 보여주는 부분 -->
								<div class="col-xs-6">
									<p class="lead">
										<c:set var="kind" value="${vo.supply_state}"/> <!-- 처리상태 예)12=입고처리 11=결제 10=발주 -->
											<c:choose>
												<c:when test="${vo.supply_state == 12 }">
													입고상태
													<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
													입고가 완료되었습니다.
												</p>
												</c:when>
												<c:otherwise>
										    		입고상태
												<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
													입고가 완료 되지 않았습니다. 입고를 확인하여 주세요.
													<a href="javascript:popupOpen();" > 바코드 확인창 </a>
												</p>
										   		</c:otherwise>
											</c:choose>
									</p>
								</div>
								<!-- 조계환 왼쪽 하단 입고 상태를 보여주는 부분 끝-->
								<!-- 명세서 부분 -->
								<div class="col-xs-6">
									<p class="lead">명세서</p>
									<div class="table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%">합계 :</th>
													<td>￦${sum}</td>
												</tr>
												<tr>
													<th>세금(10%)</th>
													<td>￦${sum/10}</td>
												</tr>
												<tr>
													<th>배송비:</th>
													<td>￦5000</td>
												</tr>
												<tr>
													<th>총합계:</th>
													<td>￦${sum + (sum/10) + 5000}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- 명세서 부분 끝 -->
							</div>
							<!-- 하단 부분 끝-->

							<!-- this row will not appear when printing -->
							<div class="row no-print">
								<div class="col-xs-12">
									<button class="btn btn-default" onclick="window.print();">
										<i class="fa fa-print"></i> Print
									</button>
									<button class="btn btn-success pull-right">
										<i class="fa fa-credit-card"></i> Submit Payment
									</button>
									<button class="btn btn-primary pull-right"
										style="margin-right: 5px;">
										<i class="fa fa-download"></i> Generate PDF
									</button>
								</div>
							</div>
							<!-- 최하단 부분 끝 -->
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->

<!-- footer content -->
<footer>
	<div class="pull-right">
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
	</div>
	<div class="clearfix"></div>
</footer>
<!-- /footer content -->

<!-- jQuery -->
<script src="../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="../build/js/custom.min.js"></script>

<script type="text/javascript">
function popupOpen(){
	var popUrl = "http://localhost:8180/cvs/barcode";	//팝업창에 출력될 페이지 URL

	var popOption = "width=1500, height=900, resizable=, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

		window.open(popUrl,"",popOption);
	}
</script>