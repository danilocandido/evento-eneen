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
    
    <script type="text/javascript">
    
    	function callAction() {
			
			var estadoID = jQuery("select[name='estadoID']").val();
			console.log(estadoID);
			
			$("select[name='municipioID']").empty(); //reseta as opções
			
			
            $.ajax({
                url: "UsuarioAction.carregarMunicipios.mtw?estadoID="+estadoID,
                contentType: "application/json; charset=utf-8",
                type: 'POST',
                success: function(data){
                	//cria as opções na raça
					$.each(data, function(key, value){
					    $("select[name='municipioID']").append("<option value='"+key+"'> "+value+" </option>");
					});
					console.log(data);
                },
                error: function(xhr, status, error) {
                    alert(xhr.responseText);
                    alert('there is some problem in updating data');

                }
 			});

		}
	</script>
    
</head>
<body>


	<div id="login-page">
	  	<div class="container">
	  	
	  		  <mtw:form action="UsuarioAction.salvar.mtw" >
		        <h2 class="form-login-heading">Cadastro de Usuario</h2>
		        <div class="login-wrap">
		
					<mtw:input name="id" type="hidden" value="${id}"/>
					<mtw:input name="semAutenticar" type="hidden" value="true"/> <!-- usado no p redirecinar na action -->
					<mtw:input name="grupoUsuarioEnum" type="hidden" value="GRUPO_PARTICIPANTE"/>
					<mtw:input name="ehAdmin" type="hidden" value="false"/>
					
					<mtw:label value="Nome:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="nome"  klass="form-control"/> <br/>
					
					<mtw:label value="Email:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="email"  klass="form-control"/> <br/>
					
					<mtw:label value="Cpf:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="cpf"  klass="form-control"/> <br/>
					
					<mtw:label value="Rg:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="rg"  klass="form-control"/> <br/>
					
					<mtw:label value="Telefone:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="telefone"  klass="form-control"/> <br/>
					
					<mtw:label value="Telefone:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="telefoneEmergencia"  klass="form-control"/> <br/>
					
					<mtw:label value="Estado:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:select name="estadoID" list="estados" klass="form-control" extra="onchange=callAction();"/>
					
					<mtw:label value="Municipio:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:select name="municipioID" id="id_municipios" list="municipios" klass="form-control"/>
					
					<mtw:label value="Universidade:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="universidade"  klass="form-control"/> <br/>
					
					<mtw:label value="senha:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="senha" type="password"  klass="form-control"/> <br/>
					
					<mtw:label value="Confirmar senha:" klassStyle="col-sm-2 col-sm-2 control-label" />
					<mtw:input name="senhaConfirmacao" type="password"  klass="form-control"/> <br/>
					
					
					<input type="submit" value="Salvar" class="btn btn-success"/>
		
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