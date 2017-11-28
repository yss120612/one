<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${springMacroRequestContext.contextPath}/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                    <#if name??>
                        <div class="panel-title">Смена пароля пользователя ${name}</div>
                    </#if>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        
						<#if messa??>
						 <div id="ok" class="alert alert-success" role="alert">${messa}</div>
						  <form id="chgpassOKform" class="form-horizontal" role="form" action="${springMacroRequestContext.contextPath}/" method="post">
						   <div style="margin-bottom: 25px" class="input-group" >
						    <button type="submit" id="btn-login" class="btn btn-success btn-block"><i class="glyphicon glyphicon-ok"></i> OK </button>
						    <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
						   </div>
						  </form>
						<#else>                        
                        
                        
						 <#if error??><div id="error" class="alert alert-danger" role="alert">${error}</div></#if>
						 
                        <form id="chgpassform" class="form-horizontal" role="form" action="${springMacroRequestContext.contextPath}/chgpwd" method="post">
                        
                            <div class="control-group">
                             <label for="login-password-old">Логин</label>
                             <div style="margin-bottom: 25px" class="input-group" >
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="username" type="text" class="form-control" name="username" placeholder="логин"  onChange="onCh()">
                             </div>
                            </div>
                            
                            <div class="control-group">
                             <label for="login-password-new">Пароль</label>
                             <div style="margin-bottom: 25px" class="input-group" >
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="password" type="password" class="form-control" name="password" placeholder="пароль"  onChange="onCh()">
                             </div>
                            </div>
                                    
							<div class="control-group">
							 <label for="roles">Роли</label>                                    
                             <div style="margin-bottom: 25px" class="input-group" >
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="roles" type="list" class="form-control" name="roles" placeholder="роли"  onChange="onCh()">
                             </div>
                            </div>
                            
                            <div class="form-check">
    						<label class="form-check-label">
      						<input type="checkbox" class="form-check-input">
      						Доступ
    						</label>
  							</div>
                            
                            <div class="form-group">
    							<label for="exampleSelect1">Example select</label>
    							<select class="form-control" id="exampleSelect1">
    							<#list roles as r>
							      <option>${r}</option>
							    </#list>  
    							</select>
  							</div>
                            
                            
                                <div width="100%" style="border-top: 1px solid#888; padding-top:15px"></div>    

								<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-4 controls">
                                      <button type="submit" id="btn-login" class="btn btn-success btn-block"><i class="glyphicon glyphicon-random"></i> Сменить пароль</button>
                                    </div>
                                </div>
                                
                            </form>  
                         </#if>      
                        </div>                     
                    </div>  
        </div>
</div>
    
<script language="Javascript">
function onCh()
{
$('#error').hide();
}
</script>
</body>
</html>