<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
  
<html>
<head>
</head>
<body>


<!--  	ABAIXO SÓ UM ADMIN VÊ -->	
	<mtw:hasAuthorization group="GRUPO_ADMINISTRADOR"><!-- também pode definir mais de um grupo -->
		<div class="row mtbox">
			<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
				<div class="box1">
					<span class="li_user"></span>
					<h3>933</h3>
				</div>
				<p>Inscritos no Evento</p>
			</div>
			<div class="col-md-2 col-sm-2 box0">
				<div class="box1">
					<span class="li_calendar"></span>
					<h3>+48</h3>
				</div>
				<p>Dias Para começar</p>
			</div>
			<div class="col-md-2 col-sm-2 box0">
				<div class="box1">
					<span class="li_banknote"></span>
					<h3>23</h3>
				</div>
				<p>You have 23 unread messages in your inbox.</p>
			</div>
			<div class="col-md-2 col-sm-2 box0">
				<div class="box1">
					<span class="li_data"></span>
					<h3>22%</h3>
				</div>
				<p>Pagantes</p>
			</div>
	<!-- 		<div class="col-md-2 col-sm-2 box0"> -->
	<!-- 			<div class="box1"> -->
	<!-- 				<span class="li_news"></span> -->
	<!-- 				<h3>+10</h3> -->
	<!-- 			</div> -->
	<!-- 			<p>More than 10 news were added in your reader.</p> -->
	<!-- 		</div> -->
			
	
		</div>
		<!-- /row mt -->
	    
	</mtw:hasAuthorization>


</body>
</html>