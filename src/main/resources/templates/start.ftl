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
<title>Insert title heree</title>
</head>
<body style="background-color: #CCCCCC">

<nav class="navbar navbar-default navbar-static-top">
  <div class="container">

     <div class="navbar-header">
     	<a class="navbar-brand <#if page=="home">disabled</#if>" href="${springMacroRequestContext.contextPath}/">Brand</a>
     </div>
     <div class="navbar-inner">
     <ul class="nav navbar-nav">
        <li ><a href="#">Link </a></li>
        <li <#if page=="calc">class="active"</#if> ><a href="${springMacroRequestContext.contextPath}/calc">Run</a></li>
     </ul>
       
       <#if radmin??>
       ${radmin?c}
       </#if>
       
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

<#if rest??>
<h4>${rest}</h4>
</#if>
<#if err??>
<h3 class="danger">${err}</h3>
</#if>
<#if page=="ulist">
UsersList
<div class="row">
<div class="col-md-6">
<table class="table table-bordered">
<thead>
<th>id</th>
<th>Логин</th>
<th>Доступ</th>
<th>Роли</th>
</tr>
<#list users as user>
<tr>
<td>${user.id}</td>
<td>${user.username}</td>
<td>
<#if user.enabled>
<i class="glyphicon glyphicon-ok"></i>
<#else>
<i class="glyphicon glyphicon-cancel"></i>
</#if>
</td>
<td>
${user.authorities}

</td>
</thead>
<tbody>
</#list>
</tbody>
</table>
</div>
</div>
</#if>
</body>
</html>