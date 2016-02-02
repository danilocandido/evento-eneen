<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
<%-- <%@ taglib prefix="display" uri="http://displaytag.sf.net"  %> --%>
  
<html>
<head>
</head>
<body>

<div class="row mt">
    <div class="col-md-12">
        <div class="content-panel">
	            	<table class="table table-striped table-advance table-hover">
	            		<thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Descrição</th>
                                  <th class="hidden-phone"><i class="fa fa-question-circle"></i> Data de Inicio</th>
                                  <th><i class="fa fa-bookmark"></i> Data Final</th>
                                  <th><i class=" fa fa-edit"></i> Status</th>
                                  <th><i class="fa fa-question-circle"></i> Ações</th>
                                  <th></th>
                              </tr>
                        </thead>
        	<mtw:list value="lista">
        		<mtw:loop var="elementoAtual">
                        <tbody>
                              <tr>
                                  <td><a href="EventoAction.cadastro.mtw?id=${elementoAtual.id}">${elementoAtual.descricao}</a></td>
                                  <td class="hidden-phone">${elementoAtual.dataInicio}</td>
                                  <td>${elementoAtual.dataFim} </td>
                                  <mtw:if test="elementoAtual.statusEventoEnum.descricao" value="Ativo">
	                                  <td><span class="label label-success">Ativo</span></td>
                                  </mtw:if>
							 <!--   ELSE    -->
                                  <mtw:if test="elementoAtual.statusEventoEnum.descricao" value="Inativo">
	                                  <td><span class="label label-danger">Inativo</span></td>
                                  </mtw:if>
                                  
                                  
                                  <td>
                                      <a href="EventoAction.cadastro.mtw?id=${elementoAtual.id}" title="Editar" class="btn btn-primary btn-xs">
                                      	<i class="fa fa-pencil"></i>
                                      </a>
                                      <button class="btn btn-danger btn-xs" title="Exluir"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                         </tbody>
        		</mtw:loop>
        	</mtw:list>
               
            </table>
        </div><!-- /content-panel -->
    </div><!-- /col-md-12 -->
</div><!-- /row -->
	
</body>
</html>