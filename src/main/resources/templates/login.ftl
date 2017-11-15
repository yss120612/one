<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.2.1.min.js"></script>

<meta charset="UTF-8">
<title>Insert title heree</title>
</head>
<body style="background-color: #CCCCCC">

<!--h1>Yaaaa ${springMacroRequestContext}</h1>
<h2 class="warning"></h2-->

<div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Вход в систему</div>
                        <!--div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div-->
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
						 <#if error??><div id="error" class="alert alert-danger" role="alert">${error}</div></#if>
						 <#if messa??><div id="logout" class="alert alert-success" role="alert">${messa}</div></#if>	                            
                        <form id="loginform" class="form-horizontal" role="form" action="${springMacroRequestContext.contextPath}/login" method="post">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="имя пользователя"  onChange="onCh()">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group" >
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="пароль"  onChange="onCh()">
                                    </div>
                                <div width="100%" style="border-top: 1px solid#888; padding-top:15px">
                                </div>    

                                
                            

								<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-3 controls">
                                      <!--a id="btn-login" href="#" class="btn btn-success">Войти  </a-->
                                      <button type="submit" id="btn-login" class="btn btn-success btn-block"><i class="glyphicon glyphicon-log-in"></i>   Войти</button>
                                    </div>
                                </div>
                            </form>     



                        </div>                     
                    </div>  
        </div>
        
    </div>
    
<script language="Javascript">
function onCh()
{
$('#error,#logout').hide();
}
</script>

</body>
</html>