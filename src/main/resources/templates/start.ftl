<!DOCTYPE html>
<html>
<head>

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
     	<a class="navbar-brand" href="#">Brand</a>
     </div>
     <div class="navbar-inner">
     <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link </a></li>
        <li><a href="${springMacroRequestContext.contextPath}/calc">Run</a></li>
         <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
      </ul>
       
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link1</a></li>
        <#if name??>
            <li><a href="${springMacroRequestContext.contextPath}/login?logout">Пользователь:${name}</a></li>
            <li><a href="#">Something else here</a></li>
        </#if>
      </ul>
    </div>
  </div>
</nav>

<#if rest??>
<h2>${rest}</h2>
</#if>
</body>
</html>