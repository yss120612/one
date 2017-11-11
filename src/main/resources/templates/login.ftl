<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Yaaaa</h1>
<h2 class="warning"></h2>

<div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Вход в систему</div>
                        <!--div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div-->
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="имя пользователя">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group" >
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="пароль">
                                    </div>
                                <div width="100%" style="border-top: 1px solid#888; padding-top:15px">
                                </div>    

                                
                            


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <a id="btn-login" href="#" class="btn btn-success">Войти  </a>
                                    </div>
                                </div>
                            </form>     



                        </div>                     
                    </div>  
        </div>
        
    </div>
    


</body>
</html>