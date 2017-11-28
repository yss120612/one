<!DOCTYPE html>
<html>
<head>

<#if apage??>
<#assign page= apage>
<#else>
<#assign page="home">
</#if>

    
<link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/bootstrap.min.js"></script>


<meta charset="UTF-8">
<#if title??>
<title>${title}</title>
</#if>
</head>
<body style="background-color: #CCCCCC">



<nav class="navbar navbar-default navbar-static-top">
  <div class="container">

     <div class="navbar-header">
     	<a class="navbar-brand <#if page=="home">disabled</#if>" href="${springMacroRequestContext.contextPath}/">Brand</a>
     </div>
     <div class="navbar-inner">
     <ul class="nav navbar-nav">
        <li ><a href="${springMacroRequestContext.contextPath}/test">Test </a></li>
        <li <#if page=="calc">class="active"</#if> ><a href="${springMacroRequestContext.contextPath}/calc">Run</a></li>
     </ul>
    
       
       <ul class="nav navbar-nav">
        <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Администрирование <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li <#if page=="ulist">class="active"</#if> ><a href="${springMacroRequestContext.contextPath}/userslist">Пользователи</a></li>
                        <li><a href="${springMacroRequestContext.contextPath}/roleslist">Роли</a></li>
                     </ul>
        </li>                
      </ul>
      
       
       <#if name??>
       <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Пользователь:${name} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${springMacroRequestContext.contextPath}/login?logout">Выйти</a></li>
                        <li><a href="${springMacroRequestContext.contextPath}/chgpwd">Сменить пароль</a></li>
                     </ul>
        </li>                
      </ul>
      </#if>
    </div>
  </div>
</nav>

<div class="container">


<#if rest??>
<div class="alert alert-info" role="alert">
<h4>${rest}</h4>
</div>
</#if>

<#if err??>
<div class="alert alert-danger">
<h3>${err}</h3>
</div>
</#if>

<#if page=="ulist">
<#include "/inc/ulist.ftl">
</#if>

</div>
</body>
</html>