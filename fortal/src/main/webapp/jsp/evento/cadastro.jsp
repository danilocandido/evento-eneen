<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
  
<html>
<head>
	
	<script type="text/javascript">
	jQuery(function($){
		
		  $("#id_dataInicioInscricao").mask("99/99/9999");
	});
	
	</script>
</head>
<body>
<mtw:form action="EventoAction.salvar.mtw" style="form-panel">

	<mtw:outError>
    	<font color="red" class="alert alert-danger"> <b><mtw:out /><b/> </font>
    	<br/><br/>
	</mtw:outError>

	<mtw:if test="inabilitaForm" negate="true">
	
		<h4 class="mb"><i class="fa fa-angle-right"></i> Cadastro de Eventos</h4>
		
		<mtw:input name="id" type="hidden" value="${id}"/>
		
		<mtw:label value="Descrição:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="descricao"  klass="form-control"/> <br/>
		
		<mtw:label value="Tipo/Valor da Inscricao:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:checkboxes name="tipoInscricao" list="tipoInscricoes"  klass="check" /><br/><br/>
	
		<mtw:label value="Data de Inicio do Evento:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="dataInicio" klass="form-control" style="width:150px" /> <br/>
		
		<mtw:label value="Data de Fim do Evento:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="dataFim" klass="form-control" style="width:150px" /> <br/>
		
		<mtw:label value="URL Site:" klassStyle="col-sm-2 col-sm-2 control-label"/>
		<mtw:input name="urlSite" klass="form-control"/> <br/>
		
		<mtw:label value="E-mail:" klassStyle="col-sm-2 col-sm-2 control-label"/>
		<mtw:input name="email" id="id_email" klass="form-control"/> <br/>
		
		<mtw:label value="Limite de Participantes:" klassStyle="col-sm-2 col-sm-2 control-label"/>
		<mtw:input name="limite" id="id_email" klass="form-control"/> <br/>
		
		<mtw:label value="Data de Inicio do Periodo da Inscricao:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="dataInicioInscricao" id="id_dataInicioInscricao" klass="form-control" style="width:150px" /> <br/>
		
		<mtw:label value="Data do Fim do Periodo de Inscrição:" klassStyle="col-sm-2 col-sm-2 control-label" />
		<mtw:input name="dataFimInscricao" klass="form-control" style="width:150px" /> <br/>
		
		<mtw:if test="editando" value="true">
			<mtw:label value="Status:" klassStyle="col-sm-2 col-sm-2 control-label" />
			<mtw:select name="statusEventoEnum" list="statusEventoEnums" klass="form-control" /> <br/>
		</mtw:if>
		
		<input type="submit" value="Salvar" class="btn btn-success"/>
		
	</mtw:if>

</mtw:form>
</body>
</html>