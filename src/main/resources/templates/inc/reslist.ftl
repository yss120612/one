<div class="row">
<div class="col-md-12">
<form id="userform" method="get" action="">
<table class="table table-bordered">
<thead>
<tr>
<th>Дата</th>
<th>ФИО</th>
<th>СНИЛС</th>
<th>Пенсия</th>
<th>Право</th>
<th>Расчет/Разъяснения</th>
<tr>
</thead>
<tbody>
<#list qlist as qi>
<tr>
<td>${qi.queryDate}</td>
<td>${qi.fio}</td>
<td>${qi.snils}</td>
<td>${qi.pensyaStr}</td>
<td>${qi.pravoStr}</td>
<td>
<#if qi.pravoStr!="-">
<a type="button" id="btn_load_${qi.id?string["0"]}" class="btn btn-info btn-mini" href="${springMacroRequestContext.contextPath}/load/${qi.id?string["0"]}" title="загрузить данные"><i class="glyphicon glyphicon-open-file" ></i></a>
<a type="button" id="btn_edit_${qi.id?string["0"]}" class="btn btn-info btn-mini" target="_blank" href="${springMacroRequestContext.contextPath}/pdf/2/${qi.id?string["0"]}" title="разъяснения"><i class="glyphicon glyphicon-hand-up" ></i></a>
<a type="button" id="btn_del_${qi.id?string["0"]}"  class="btn btn-info btn-mini" target="_blank" href="${springMacroRequestContext.contextPath}/pdf/1/${qi.id?string["0"]}" title="расчеты"><i class="glyphicon glyphicon-list-alt" ></i></a>
<#else>
<a type="button" id="btn_del_${qi.id?string["0"]}"  class="btn btn-danger btn-mini" target="_blank" href="${springMacroRequestContext.contextPath}/pdf/1/${qi.id?string["0"]}" title="разъяснения"><i class="glyphicon glyphicon-hand-up" ></i></a>
</#if>
</td>
</tr>
</#list>
</tbody>
</table>
<input id="userid" name="userid" type="hidden" value=""/>
</form>
</div>
</div>
