<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="mtw" uri="http://www.mentaframework.org/tags-mtw/"%>
  
<html>
<body>
  <mtw:out value="msg" />
  
  <mtw:list value="lista">
  	<mtw:loop var="li">
  		<mtw:out value="li.descricao" />
  	</mtw:loop>
  </mtw:list>
  
</body>
</html>