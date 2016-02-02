<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
  
<html>
<head>
	<mtw:inputDateConfig/>
</head>
<body>
<mtw:form action="TipoInscricaoAction.salvar.mtw" style="form-panel">

	<h4 class="mb"><i class="fa fa-angle-right"></i> Cadastro Tipo Inscrição</h4>
	
	<mtw:input name="id" type="hidden" value="${id}"/>
	
	<mtw:label value="Descrição:" klassStyle="col-sm-2 col-sm-2 control-label" />
	<mtw:input name="descricao"  klass="form-control"/> <br/>
	
	<mtw:label value="Valor" klassStyle="col-sm-2 col-sm-2 control-label" />
	<mtw:input name="valor"  klass="form-control" style="width: 100px"/> <br/>

	
	<input type="submit" value="Salvar" class="btn btn-success"/>
	
	<%@ include file="lista.jsp"%>

</mtw:form>
</body>
</html>