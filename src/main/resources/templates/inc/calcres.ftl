<div class="row">
<div class="col-md-12">
<h2 class="col-md-offset-1">Результаты расчета пенсии для СНИЛС ${man.SNILS}</h2>
<div class="col-md-10 col-md-offset-1">
 <table class="table table-striped table-bordered">
                        <thead>
                          <tr>
                            <th>Наименование</th>
                            <th>Значение</th>
                          </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>СНИЛС</td>
                            <td>${man.SNILS}</td>
                        </tr>
                        <tr>
                            <td>ФИО</td>
                            <td>${man.family} ${man.name} ${man.otch}</td>
                        </tr>
                        <tr>
                            <td>Пол</td>
                            <td>${man.sex}</td>
                        </tr>
                        
                        <tr>
                            <td>Дата рождения</td>
                            <td>${man.birthDayStr}</td>
                        </tr>
                        
                        <tr>
                            <td>Дата права</td>
                            <td>${man.datePravStr}</td>
                        </tr>
                        
                        <tr>
                            <td>Общий стаж</td>
                            <td>${man.periodAll}</td>
                        </tr>
                        
                        <tr>
                            <td>Пенсия страховая</td>
                            <td>${man.pensiyaStr}</td>
                        </tr>
                        <tr>
                            <td>Фиксированная часть</td>
                            <td>${man.fixStr}</td>
                        </tr>
                        
                        <tr>
                            <td>Пенсия</td>
                            <td>${man.summStr}</td>
                        </tr>
                        
                        </tbody>                        
                    </table>
</div>
</div>
</div>
<div class="col-md-10 col-md-offset-1">
<a type="button" class="btn btn-default" target="_blank" href="${springMacroRequestContext.contextPath}/pdf/1/${userid?string["0"]}">Расчет</a>
<a type="button" class="btn btn-default" target="_blank" href="${springMacroRequestContext.contextPath}/pdf/2/${userid?string["0"]}">Разъяснения</a>
</div>
</div>

<br>
${res}
