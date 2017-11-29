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
                    <#if titleform??>
                        <div class="panel-title">${titleform}</div>
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
						 
                        <form id="userform" class="form-horizontal" role="form" method="post">
                        
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
                             <label for="login-password-new2">Пароль повтор</label>
                             <div style="margin-bottom: 25px" class="input-group" >
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="password2" type="password" class="form-control" name="password2" placeholder="пароль еще раз"  onChange="onCh()">
                             </div>
                            </div>
                            
							<div class="control-group">                                    
							 <div class="form-check">
    							<label class="form-check-label"><input type="checkbox" name="access" id="access" class="form-check-input"> Доступ</label>
  							 </div>
  							 </div>
                            
                             <div class="control-group">
    							<label for="uroles">Роли (Shift+click)</label>
    							<select multiple class="form-control" id="uroles" name="uroles">
    							<#list roles as r>
      								<option>${r.authority}</option>
      							</#list>  
    							</select>
  							  </div>
                            
                                                        
                            
                                <div width="100%" style="border-top: 1px solid#888; margin-top:15px"></div>    

								<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
								
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-4 controls">
                                    <#if action=="add">
                                      	<button type="button" id="btn-adduser" class="btn btn-success"><i class="glyphicon glyphicon-floppy-saved" onclick="onClc(1)"></i>Добавить</button>
                                     <#else> 
                                     	<button type="button" id="btn-edituser" class="btn btn-success"><i class="glyphicon glyphicon-floppy-saved" onclick="onClc(2)"></i>Принять</button>
                                     </#if>
                                     	<button type="cancel" id="btn-cancel" class="btn btn-default"><i class="glyphicon glyphicon-remove" onclick="onClc(3)"></i>Отмена</button>
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

function onClk(v)
{
if (v==1)
{
$("#userform").attr("action","${springMacroRequestContext.contextPath}/useradd");
$("#userform").submit(); 
}
else if (v==2)
{
$("#userform").attr("action","${springMacroRequestContext.contextPath}/useredit");
$("#userform").submit(); 
}
else if (v==3)
{
window.location ="${springMacroRequestContext.contextPath}/userlist";
}

}


</script>
</body>
</html>