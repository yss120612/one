<div class="row">
<div class="col-md-6 col-md-offset-3">
<form id="userform" method="post" action="${springMacroRequestContext.contextPath}/calc">
 <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Расчет пенсии</div>
                    </div>
<div style="padding:15px;">                
<div class="control-group">
                            <label for="login-username">Введите СНИЛС</label>   	
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-hand-right" aria-hidden="true"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="snils" value="" placeholder="000-000-000 00">                                        
                            </div>
                       </div>
                     
<button type="submit" id="btn_calc"  class="btn btn-info btn-mini"><i class="glyphicon glyphicon-flash"></i> Расчитать</button>
<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
</div>
 </div>
</form>
</div>
</div>