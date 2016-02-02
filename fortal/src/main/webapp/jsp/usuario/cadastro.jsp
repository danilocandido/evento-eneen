<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
  
<html>
<head>
</head>
<body>
<mtw:form action="UsuarioAction.salvar.mtw" style="form-panel">

	<mtw:outError>
    	<font color="red" class="alert alert-danger"> <b><mtw:out /><b/> </font>
    	<br/><br/>
	</mtw:outError>

	
		<h4 class="mb"><i class="fa fa-angle-right"></i> Cadastro de ${grupoUsuarioDescricao}</h4>
		
		<mtw:input name="id" type="hidden" value="${id}"/>
		<mtw:input name="ehAdmin" type="hidden" />
		
		<mtw:label value="Nome Completo:" klassStyle="col-sm-2 col-sm-2 control-label" />
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
		<mtw:select name="estadoID" list="estados" klass="form-control"/>
		
		<mtw:label value="Municipio:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:select name="municipioID" list="municipios" klass="form-control"/>
		
		<mtw:label value="Universidade:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="universidade"  klass="form-control"/> <br/>
		
		<mtw:label value="senha:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="senha" type="password"  klass="form-control"/> <br/>
		
		<mtw:label value="Confirmar senha:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="senhaConfirmacao" type="password"  klass="form-control"/> <br/>
		
		
		<input type="submit" value="Salvar" class="btn btn-success"/>
		

</mtw:form>
</body>
</html>