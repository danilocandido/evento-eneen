<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>

  
<html>
<head>
	<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--external css-->
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    
        <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" type="text/css">
</head>
<body>


	<div id="login-page">
	  	<div class="container">
	  	
	  		  <mtw:form action="LoginAction.execute.mtw" method="post" klass="form-login">
<!-- 		      <form class="form-login" action="index.html"> -->
		        <h2 class="form-login-heading">Entrar Agora</h2>
		        <div class="login-wrap">
				<!-- Se o cadastro é feito sem ser por um admin então o usuario é um participante -->
		        	<mtw:input name="login" klass="form-control" extra="placeholder=Login#autofocus"/>
		            <br>
		            <mtw:input name="senha" type="password" klass="form-control" extra="placeholder=Password#autofocus"/>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Esqueceu a senha?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> ENTRAR</button>
		            <hr>
		            
		            <div class="login-social-link centered">
		            <p>ou você pode logar pelo facebook</p>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		            </div>
		            <div class="registration">
		                Você não tem uma conta?<br>
		                <a class="" href="UsuarioAction.cadastroSemAutenticar.mtw">
		                    Criar uma
		                </a>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
<!-- 		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade"> -->
<!-- 		              <div class="modal-dialog"> -->
<!-- 		                  <div class="modal-content"> -->
<!-- 		                      <div class="modal-header"> -->
<!-- 		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
<!-- 		                          <h4 class="modal-title">Forgot Password ?</h4> -->
<!-- 		                      </div> -->
<!-- 		                      <div class="modal-body"> -->
<!-- 		                          <p>Enter your e-mail address below to reset your password.</p> -->
<!-- 		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix"> -->
		
<!-- 		                      </div> -->
<!-- 		                      <div class="modal-footer"> -->
<!-- 		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button> -->
<!-- 		                          <button class="btn btn-theme" type="button">Submit</button> -->
<!-- 		                      </div> -->
<!-- 		                  </div> -->
<!-- 		              </div> -->
<!-- 		          </div> -->
		          <!-- modal -->
		
<!-- 		      </form>	 -->
		      </mtw:form>  	
	  	
	  	</div>
	  </div>
	
	<!-- js placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
        <script>
        $.backstretch("${pageContext.request.contextPath}/img/login-bg.jpg", {speed: 500});
    </script>

</body>
</html>