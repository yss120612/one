<?xml version="1.0" encoding="UTF-8"?>
<report xmlns="http://www.eclipse.org/birt/2005/design" version="3.2.23" id="1">
    <property name="createdBy">Eclipse BIRT Designer Version 4.7.0.v201706222054</property>
    <list-property name="userProperties">
        <structure>
            <property name="name">Data Cube - Набор данных1.Набор данных1.x</property>
            <property name="type">integer</property>
            <property name="isVisible">false</property>
        </structure>
        <structure>
            <property name="name">Data Cube - Набор данных1.Набор данных1.y</property>
            <property name="type">integer</property>
            <property name="isVisible">false</property>
        </structure>
        <structure>
            <property name="name">Data Cube.Набор данных1.x</property>
            <property name="type">integer</property>
            <property name="isVisible">false</property>
        </structure>
        <structure>
            <property name="name">Data Cube.Набор данных1.y</property>
            <property name="type">integer</property>
            <property name="isVisible">false</property>
        </structure>
    </list-property>
    <property name="Data Cube - Набор данных1.Набор данных1.x">135</property>
    <property name="Data Cube - Набор данных1.Набор данных1.y">80</property>
    <property name="Data Cube.Набор данных1.x">135</property>
    <property name="Data Cube.Набор данных1.y">80</property>
    <list-property name="propertyBindings">
        <structure>
            <property name="name">odaDriverClass</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaURL</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaUser</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaAutoCommit</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaIsolationMode</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaPassword</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">odaJndiName</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">OdaConnProfileName</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">OdaConnProfileStorePath</property>
            <property name="id">1166</property>
        </structure>
        <structure>
            <property name="name">queryTimeOut</property>
            <property name="id">1380</property>
            <expression name="value" type="javascript">300</expression>
        </structure>
    </list-property>
    <property name="units">in</property>
    <property name="iconFile">/templates/blank_report.gif</property>
    <property name="layoutPreference">auto layout</property>
    <property name="bidiLayoutOrientation">ltr</property>
    <property name="imageDPI">96</property>
    <parameters>
        <scalar-parameter name="P_god" id="1489">
            <text-property name="promptText">Введите интересующий Вас год</text-property>
            <property name="valueType">static</property>
            <property name="isRequired">true</property>
            <property name="dataType">float</property>
            <property name="distinct">true</property>
            <list-property name="selectionList">
                <structure>
                    <property name="value">2010</property>
                    <property name="label">2010</property>
                </structure>
                <structure>
                    <property name="value">2011</property>
                    <property name="label">2011</property>
                </structure>
                <structure>
                    <property name="value">2012</property>
                    <property name="label">2012</property>
                </structure>
                <structure>
                    <property name="value">2013</property>
                    <property name="label">2013</property>
                </structure>
                <structure>
                    <property name="value">2014</property>
                    <property name="label">2014</property>
                </structure>
                <structure>
                    <property name="value">2015</property>
                    <property name="label">2015</property>
                </structure>
                <structure>
                    <property name="value">2016</property>
                    <property name="label">2016</property>
                </structure>
                <structure>
                    <property name="value">2017</property>
                    <property name="label">2017</property>
                </structure>
                <structure>
                    <property name="value">2018</property>
                    <property name="label">2018</property>
                </structure>
            </list-property>
            <property name="paramType">simple</property>
            <property name="concealValue">false</property>
            <property name="controlType">text-box</property>
            <property name="fixedOrder">true</property>
            <method name="getDefaultValueList"><![CDATA[BirtDateTime.year(BirtDateTime.today())]]></method>
            <structure name="format">
                <property name="category">Unformatted</property>
            </structure>
        </scalar-parameter>
        <scalar-parameter name="IP" id="1540">
            <text-property name="promptText">Выбор управления</text-property>
            <property name="valueType">static</property>
            <property name="sortBy">label</property>
            <property name="sortDirection">asc</property>
            <property name="dataType">string</property>
            <property name="distinct">true</property>
            <simple-property-list name="defaultValue">
                <value type="constant">10.48.6.8</value>
            </simple-property-list>
            <list-property name="selectionList">
                <structure>
                    <property name="value">10.48.2.170</property>
                    <property name="label">002-Клиентская Служба  в Правобережном и Октябрьском округах г. Иркутска</property>
                </structure>
                <structure>
                    <property name="value">10.48.6.8</property>
                    <property name="label">006-Клиентская Служба в Свердловском районе г. Иркутска</property>
                </structure>
                <structure>
                    <property name="value">10.48.14.113</property>
                    <property name="label">014-Клиентская Служба в г. Зима и Зиминском р-не</property>
                </structure>
                <structure>
                    <property name="value">10.48.27.107</property>
                    <property name="label">027-Клиентская Служба в г. Усть-Илимск и Усть-Илимском р-не</property>
                </structure>
                <structure>
                    <property name="value">10.48.20.122</property>
                    <property name="label">020-Клиентская Служба в Нижнеудинском р-не</property>
                </structure>
                <structure>
                    <property name="value">10.48.7.3</property>
                    <property name="label">007-Клиентская Служба в Ангарском МО</property>
                </structure>
                <structure>
                    <property name="value">10.48.4.4</property>
                    <property name="label">004-Клиентская Служба в Ленинском районе г. Иркутска</property>
                </structure>
                <structure>
                    <property name="value">10.48.29.121</property>
                    <property name="label">029-Клиентская Служба в г. Усолье-Сибирское и Усольском р-не</property>
                </structure>
                <structure>
                    <property name="value">10.48.31.71</property>
                    <property name="label">031-Клиентская Служба в г. Черемхово и Черемховском р-не</property>
                </structure>
            </list-property>
            <property name="paramType">simple</property>
            <property name="controlType">list-box</property>
            <property name="mustMatch">true</property>
            <property name="fixedOrder">false</property>
            <structure name="format">
                <property name="category">Unformatted</property>
            </structure>
        </scalar-parameter>
    </parameters>
    <data-sources>
        <oda-data-source extensionID="org.eclipse.birt.report.data.oda.jdbc" name="mysql_kc" id="1166">
            <method name="beforeOpen"><![CDATA[importPackage(Packages.java.util.logging);

 this.setExtensionProperty("odaURL", " ");
 this.setExtensionProperty("odaUser", " ");
 this.setExtensionProperty("odaPassword", " ");

if (params["IP"]=="10.48.30.11")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.30.11/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "12345678");
} 

if (params["IP"]=="10.48.92.61")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.92.61/kc");
 this.setExtensionProperty("odaUser", "rep034");
 this.setExtensionProperty("odaPassword", "");
} 


if (params["IP"]=="10.48.20.102")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.20.102/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "lqbg");
} 



if (params["IP"]=="10.48.33.6")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.33.6/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "505152");
} 


if (params["IP"]=="10.48.13.48")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.13.48/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "root13");
} 





if (params["IP"]=="10.48.29.82")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.29.6/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "3333");
} 


if (params["IP"]=="10.48.18.52")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.18.52/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "1977");
} 



if (params["IP"]=="10.48.27.102")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.27.102/kc1");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "12345");
} 




if (params["IP"]=="10.48.0.46")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.0.46/kc");
 this.setExtensionProperty("odaUser", "kc_edit");
 this.setExtensionProperty("odaPassword", "24362");
} 

if (params["IP"]=="10.48.14.16")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.14.16/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "014");
} 


if (params["IP"]=="10.48.91.2")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.91.2/kc");
 this.setExtensionProperty("odaUser", "rep034");
 this.setExtensionProperty("odaPassword", "pass034");
} 


if (params["IP"]=="10.48.93.1")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.93.1/kc");
 this.setExtensionProperty("odaUser", "kc_edit");
 this.setExtensionProperty("odaPassword", "67091897");
} 




if (params["IP"]=="10.48.1.10")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.1.11/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "1111");
} 



if (params["IP"]=="10.48.21.51")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.21.121/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "13137");
}


if (params["IP"]=="10.48.4.2")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.4.2/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "1111");
} 

if (params["IP"]=="10.48.6.6")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.6.1/ks_pens");
 this.setExtensionProperty("odaUser", "ks_user");
 this.setExtensionProperty("odaPassword", "jsncvornq");
}
 
//------------------------------------------------------
if (params["IP"]=="10.48.7.11")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.7.11/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "ss200000");
}


if (params["IP"]=="10.48.8.15")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.8.15/kc");
 this.setExtensionProperty("odaUser", "rep034");
 this.setExtensionProperty("odaPassword", "pass034");
}






if (params["IP"]=="10.48.9.10")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.9.10/kc");
 this.setExtensionProperty("odaUser", "kc_edit");
 this.setExtensionProperty("odaPassword", "67091897");
}







if (params["IP"]=="10.48.14.17")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.14.17/kc");
 this.setExtensionProperty("odaUser", "opfr");
 this.setExtensionProperty("odaPassword", "014");
}



if (params["IP"]=="10.48.24.35")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.24.35/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "vostok");
}



if (params["IP"]=="10.48.25.11")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.25.11/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "root");
}



if (params["IP"]=="10.48.26.99")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.26.99/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "gt2mrs");
}



if (params["IP"]=="10.48.28.10")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.28.10/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "~!@#$");
}



if (params["IP"]=="10.48.31.99")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.31.99/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "root031");
}

if (params["IP"]=="10.48.32.20")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.32.20/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "root");
}




if (params["IP"]=="10.48.34.67")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.34.67/kc");
 this.setExtensionProperty("odaUser", "rep034");
 this.setExtensionProperty("odaPassword", "pass034");
}



if (params["IP"]=="10.48.100.11")
{
 this.setExtensionProperty("odaURL", "jdbc:mysql://10.48.100.11/kc");
 this.setExtensionProperty("odaUser", "root");
 this.setExtensionProperty("odaPassword", "2222");
}

]]></method>
            <list-property name="privateDriverProperties">
                <ex-property>
                    <name>metadataBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledMetadataBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>contentBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledContentBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
            </list-property>
            <property name="odaDriverClass">com.mysql.jdbc.Driver</property>
            <property name="odaURL">jdbc:mysql://10.48.28.10/kc</property>
            <property name="odaUser">root</property>
            <property name="odaAutoCommit">false</property>
            <encrypted-property name="odaPassword" encryptionID="base64">fiFAIyQ=</encrypted-property>
        </oda-data-source>
        <oda-data-source extensionID="org.eclipse.birt.report.data.oda.jdbc" name="Data Source" id="1627">
            <list-property name="privateDriverProperties">
                <ex-property>
                    <name>metadataBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledMetadataBidiFormatStr</name>
                </ex-property>
                <ex-property>
                    <name>contentBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledContentBidiFormatStr</name>
                </ex-property>
            </list-property>
            <property name="odaDriverClass">com.mysql.jdbc.Driver</property>
            <property name="odaURL">jdbc:mysql://10.48.27.102/kc</property>
            <property name="odaUser">User</property>
            <encrypted-property name="odaPassword" encryptionID="base64">NDMyMQ==</encrypted-property>
        </oda-data-source>
        <oda-data-source extensionID="org.eclipse.birt.report.data.oda.jdbc" name="Data Source1" id="7">
            <method name="beforeOpen"><![CDATA[importPackage(Packages.java.util.logging);

 this.setExtensionProperty("odaURL", " ");
 this.setExtensionProperty("odaUser", " ");
 this.setExtensionProperty("odaPassword", " ");

if (params["IP"]=="10.48.2.170")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.2.170/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 


if (params["IP"]=="10.48.6.8")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.6.8/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 

if (params["IP"]=="10.48.14.113")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.14.113/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 


if (params["IP"]=="10.48.20.122")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.20.122/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 


if (params["IP"]=="10.48.27.107")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.27.107/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 



if (params["IP"]=="10.48.7.3")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.7.3/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
} 



if (params["IP"]=="10.48.4.4")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.4.4/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
}


if (params["IP"]=="10.48.29.121")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.29.121/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
}


if (params["IP"]=="10.48.31.71")
{
 this.setExtensionProperty("odaURL", "jdbc:postgresql://10.48.31.71/damask_stat");
 this.setExtensionProperty("odaUser", "postgreadmin");
 this.setExtensionProperty("odaPassword", "htpfrf");
}

]]></method>
            <list-property name="privateDriverProperties">
                <ex-property>
                    <name>metadataBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledMetadataBidiFormatStr</name>
                </ex-property>
                <ex-property>
                    <name>contentBidiFormatStr</name>
                    <value>ILYNN</value>
                </ex-property>
                <ex-property>
                    <name>disabledContentBidiFormatStr</name>
                </ex-property>
            </list-property>
            <property name="odaDriverClass">org.postgresql.Driver</property>
            <property name="odaURL">jdbc:postgresql://10.48.6.8/damask_stat</property>
            <property name="odaUser">postgreadmin</property>
            <encrypted-property name="odaPassword" encryptionID="base64">aHRwZnJm</encrypted-property>
        </oda-data-source>
    </data-sources>
    <data-sets>
        <oda-data-set extensionID="org.eclipse.birt.report.data.oda.jdbc.JdbcSelectDataSet" name="Набор данных1" id="1380">
            <property name="nullsOrdering">nulls lowest</property>
            <list-property name="computedColumns">
                <structure>
                    <property name="name">mname</property>
                    <expression name="expression">if(row["month_date_comin"]==1)"01.Январь";&#13;
if(row["month_date_comin"]==2)"02.Февраль";&#13;
if(row["month_date_comin"]==3)"03.Март";&#13;
if(row["month_date_comin"]==4)"04.Апрель";&#13;
if(row["month_date_comin"]==5)"05.Май";&#13;
if(row["month_date_comin"]==6)"06.Июнь";&#13;
if(row["month_date_comin"]==7)"07.Июль";&#13;
if(row["month_date_comin"]==8)"08.Август";&#13;
if(row["month_date_comin"]==9)"09.Сентябрь";&#13;
if(row["month_date_comin"]==10)"10.Октябрь";&#13;
if(row["month_date_comin"]==11)"11.Ноябрь";&#13;
if(row["month_date_comin"]==12)"12.Декабрь";</expression>
                    <property name="dataType">string</property>
                </structure>
            </list-property>
            <list-property name="columnHints">
                <structure>
                    <property name="columnName">date_comin</property>
                    <property name="analysis">dimension</property>
                    <text-property name="displayName">date_comin</text-property>
                    <text-property name="heading">date_comin</text-property>
                </structure>
                <structure>
                    <property name="columnName">day_date_comin</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">day_date_comin</text-property>
                    <text-property name="heading">day_date_comin</text-property>
                </structure>
                <structure>
                    <property name="columnName">month_date_comin</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">month_date_comin</text-property>
                    <text-property name="heading">month_date_comin</text-property>
                </structure>
                <structure>
                    <property name="columnName">av</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">av</text-property>
                    <text-property name="heading">av</text-property>
                </structure>
                <structure>
                    <property name="columnName">av2</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">av2</text-property>
                    <text-property name="heading">av2</text-property>
                </structure>
                <structure>
                    <property name="columnName">cnt</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">cnt</text-property>
                    <text-property name="heading">cnt</text-property>
                </structure>
            </list-property>
            <list-property name="parameters">
                <structure>
                    <property name="name">param_1</property>
                    <property name="paramName">P_god</property>
                    <property name="dataType">decimal</property>
                    <property name="position">1</property>
                    <property name="isInput">true</property>
                    <property name="isOutput">false</property>
                </structure>
            </list-property>
            <structure name="cachedMetaData">
                <list-property name="resultSet">
                    <structure>
                        <property name="position">1</property>
                        <property name="name">date_comin</property>
                        <property name="dataType">date</property>
                    </structure>
                    <structure>
                        <property name="position">2</property>
                        <property name="name">day_date_comin</property>
                        <property name="dataType">integer</property>
                    </structure>
                    <structure>
                        <property name="position">3</property>
                        <property name="name">month_date_comin</property>
                        <property name="dataType">integer</property>
                    </structure>
                    <structure>
                        <property name="position">4</property>
                        <property name="name">av</property>
                        <property name="dataType">decimal</property>
                    </structure>
                    <structure>
                        <property name="position">5</property>
                        <property name="name">av2</property>
                        <property name="dataType">decimal</property>
                    </structure>
                    <structure>
                        <property name="position">6</property>
                        <property name="name">cnt</property>
                        <property name="dataType">decimal</property>
                    </structure>
                    <structure>
                        <property name="position">7</property>
                        <property name="name">mname</property>
                        <property name="dataType">string</property>
                    </structure>
                </list-property>
            </structure>
            <property name="dataSource">Data Source1</property>
            <list-property name="resultSet">
                <structure>
                    <property name="position">1</property>
                    <property name="name">date_comin</property>
                    <property name="nativeName">date_comin</property>
                    <property name="dataType">date</property>
                    <property name="nativeDataType">91</property>
                </structure>
                <structure>
                    <property name="position">2</property>
                    <property name="name">day_date_comin</property>
                    <property name="nativeName">day_date_comin</property>
                    <property name="dataType">integer</property>
                    <property name="nativeDataType">4</property>
                </structure>
                <structure>
                    <property name="position">3</property>
                    <property name="name">month_date_comin</property>
                    <property name="nativeName">month_date_comin</property>
                    <property name="dataType">integer</property>
                    <property name="nativeDataType">4</property>
                </structure>
                <structure>
                    <property name="position">4</property>
                    <property name="name">av</property>
                    <property name="nativeName">av</property>
                    <property name="dataType">decimal</property>
                    <property name="nativeDataType">2</property>
                </structure>
                <structure>
                    <property name="position">5</property>
                    <property name="name">av2</property>
                    <property name="nativeName">av2</property>
                    <property name="dataType">decimal</property>
                    <property name="nativeDataType">2</property>
                </structure>
                <structure>
                    <property name="position">6</property>
                    <property name="name">cnt</property>
                    <property name="nativeName">cnt</property>
                    <property name="dataType">decimal</property>
                    <property name="nativeDataType">-5</property>
                </structure>
            </list-property>
            <xml-property name="queryText"><![CDATA[WITH c1 AS (SELECT station_id, user_id, operation_id, queue_number AS queue, client_id, type, MIN(time) AS mt FROM public.events 
	WHERE date_part('year', time) = ? AND type = 9
	GROUP BY station_id, user_id, operation_id, queue_number, client_id, type ),

	c2 AS (SELECT t.station_id, t.user_id, t.operation_id, t.client_id, t.end_status tst, 
	MIN(t.time_get) AS get, MIN(t.time_call) AS call, MIN(t.time_end) AS end FROM  c1 
	LEFT JOIN public.fns_client_stat t ON c1.client_id = t.client_id AND c1.operation_id = t.operation_id AND c1.station_id = t.station_id AND c1.user_id = t.user_id
	WHERE t.end_status IS NOT NULL 
	GROUP BY t.station_id, t.user_id, t.operation_id, t.client_id, t.end_status), 

	c3 AS (SELECT CAST(c1.mt AS DATE) AS date_comin, 
	c2.get AS time_comin, c2.call AS time_nach_p, c2.end AS time_end_p
	FROM c1  LEFT JOIN c2 ON c1.client_id = c2.client_id AND c1.operation_id = c2.operation_id AND c1.station_id = c2.station_id AND c1.user_id = c2.user_id
	WHERE c2.client_id  IS NOT NULL ) 

	SELECT date_comin, CAST(date_part('day', date_comin) AS INTEGER) as day_date_comin,  CAST(date_part('month', date_comin) AS INTEGER) AS month_date_comin, 
	avg(time_nach_p - time_comin)/60 as av , avg(time_end_p - time_nach_p)/60 as av2, count(*) as cnt FROM c3 where (time_nach_p - time_comin) > 0 
	GROUP BY date_comin 
ORDER BY month_date_comin, day_date_comin
]]></xml-property>
            <xml-property name="designerValues"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<model:DesignValues xmlns:design="http://www.eclipse.org/datatools/connectivity/oda/design" xmlns:model="http://www.eclipse.org/birt/report/model/adapter/odaModel">
  <Version>2.0</Version>
  <design:ResultSets derivedMetaData="true">
    <design:resultSetDefinitions>
      <design:resultSetColumns>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>date_comin</design:name>
              <design:position>1</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>91</design:nativeDataTypeCode>
            <design:precision>10</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>NotNullable</design:nullability>
            <design:uiHints>
              <design:displayName>date_comin</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>date_comin</design:label>
            <design:formattingHints>
              <design:displaySize>10</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>avg(time_nach_p-time_comin)/60</design:name>
              <design:position>2</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>8</design:nativeDataTypeCode>
            <design:precision>16</design:precision>
            <design:scale>31</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>avg(time_nach_p-time_comin)/60</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>avg(time_nach_p-time_comin)/60</design:label>
            <design:formattingHints>
              <design:displaySize>16</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
      </design:resultSetColumns>
      <design:criteria/>
    </design:resultSetDefinitions>
  </design:ResultSets>
</model:DesignValues>]]></xml-property>
        </oda-data-set>
        <oda-data-set extensionID="org.eclipse.birt.report.data.oda.jdbc.JdbcSelectDataSet" name="Data Set" id="1625">
            <list-property name="columnHints">
                <structure>
                    <property name="columnName">day_date_comin_</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">day_date_comin_</text-property>
                    <text-property name="heading">day_date_comin_</text-property>
                </structure>
                <structure>
                    <property name="columnName">month_date_comin_</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">month_date_comin_</text-property>
                    <text-property name="heading">month_date_comin_</text-property>
                </structure>
                <structure>
                    <property name="columnName">av</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">av</text-property>
                    <text-property name="heading">av</text-property>
                </structure>
                <structure>
                    <property name="columnName">av2</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">av2</text-property>
                    <text-property name="heading">av2</text-property>
                </structure>
                <structure>
                    <property name="columnName">cnt</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">cnt</text-property>
                    <text-property name="heading">cnt</text-property>
                </structure>
            </list-property>
            <list-property name="parameters">
                <structure>
                    <property name="name">param_1</property>
                    <property name="paramName">P_god</property>
                    <property name="nativeName"></property>
                    <property name="dataType">integer</property>
                    <property name="nativeDataType">8</property>
                    <property name="position">1</property>
                    <property name="isInput">true</property>
                    <property name="isOutput">false</property>
                </structure>
            </list-property>
            <structure name="cachedMetaData">
                <list-property name="resultSet">
                    <structure>
                        <property name="position">1</property>
                        <property name="name">day_date_comin_</property>
                        <property name="dataType">integer</property>
                    </structure>
                    <structure>
                        <property name="position">2</property>
                        <property name="name">month_date_comin_</property>
                        <property name="dataType">integer</property>
                    </structure>
                    <structure>
                        <property name="position">3</property>
                        <property name="name">av</property>
                        <property name="dataType">decimal</property>
                    </structure>
                    <structure>
                        <property name="position">4</property>
                        <property name="name">av2</property>
                        <property name="dataType">decimal</property>
                    </structure>
                    <structure>
                        <property name="position">5</property>
                        <property name="name">cnt</property>
                        <property name="dataType">decimal</property>
                    </structure>
                </list-property>
            </structure>
            <property name="dataSource">Data Source1</property>
            <list-property name="resultSet">
                <structure>
                    <property name="position">1</property>
                    <property name="name">day_date_comin_</property>
                    <property name="nativeName">day_date_comin_</property>
                    <property name="dataType">integer</property>
                </structure>
                <structure>
                    <property name="position">2</property>
                    <property name="name">month_date_comin_</property>
                    <property name="nativeName">month_date_comin_</property>
                    <property name="dataType">integer</property>
                </structure>
                <structure>
                    <property name="position">3</property>
                    <property name="name">av</property>
                    <property name="nativeName">av</property>
                    <property name="dataType">decimal</property>
                </structure>
                <structure>
                    <property name="position">4</property>
                    <property name="name">av2</property>
                    <property name="nativeName">av2</property>
                    <property name="dataType">decimal</property>
                </structure>
                <structure>
                    <property name="position">5</property>
                    <property name="name">cnt</property>
                    <property name="nativeName">cnt</property>
                    <property name="dataType">decimal</property>
                </structure>
            </list-property>
            <xml-property name="queryText"><![CDATA[WITH c1 AS (SELECT station_id, user_id, operation_id, queue_number AS queue, client_id, type, MIN(time) AS mt FROM public.events 
	WHERE date_part('year', time) = ? AND type = 9
	GROUP BY station_id, user_id, operation_id, queue_number, client_id, type ),

	c2 AS (SELECT t.station_id, t.user_id, t.operation_id, t.client_id, t.end_status tst, 
	MIN(t.time_get) AS get, MIN(t.time_call) AS call, MIN(t.time_end) AS end FROM  c1 
	LEFT JOIN public.fns_client_stat t ON c1.client_id = t.client_id AND c1.operation_id = t.operation_id AND c1.station_id = t.station_id AND c1.user_id = t.user_id
	WHERE t.end_status IS NOT NULL 
	GROUP BY t.station_id, t.user_id, t.operation_id, t.client_id, t.end_status), 

	c3 AS (SELECT CAST(c1.mt AS DATE) AS date_comin, 
	c2.get AS time_comin, c2.call AS time_nach_p, c2.end AS time_end_p
	FROM c1  LEFT JOIN c2 ON c1.client_id = c2.client_id AND c1.operation_id = c2.operation_id AND c1.station_id = c2.station_id AND c1.user_id = c2.user_id
	WHERE c2.client_id  IS NOT NULL ) 

	SELECT CAST(date_part('day', date_comin) AS INTEGER) AS day_date_comin_,  CAST(date_part('month', date_comin) AS INTEGER) AS month_date_comin_, 
	avg(time_nach_p - time_comin)/60 as av , avg(time_end_p - time_nach_p)/60 as av2, count(*) as cnt FROM c3 where (time_nach_p - time_comin) > 0 
	GROUP BY date_comin ORDER BY month_date_comin_, day_date_comin_]]></xml-property>
            <xml-property name="designerValues"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<model:DesignValues xmlns:design="http://www.eclipse.org/datatools/connectivity/oda/design" xmlns:model="http://www.eclipse.org/birt/report/model/adapter/odaModel">
  <Version>2.0</Version>
  <DataSetParameters>
    <parameter>
      <design:ParameterDefinition>
        <design:inOutMode>In</design:inOutMode>
        <design:attributes>
          <design:identifier>
            <design:name></design:name>
            <design:position>1</design:position>
          </design:identifier>
          <design:nativeDataTypeCode>8</design:nativeDataTypeCode>
          <design:precision>0</design:precision>
          <design:scale>0</design:scale>
          <design:nullability>Unknown</design:nullability>
        </design:attributes>
      </design:ParameterDefinition>
    </parameter>
  </DataSetParameters>
  <design:ResultSets derivedMetaData="true">
    <design:resultSetDefinitions>
      <design:resultSetColumns>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>day(date_comin)</design:name>
              <design:position>1</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>4</design:nativeDataTypeCode>
            <design:precision>2</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>day(date_comin)</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>day(date_comin)</design:label>
            <design:formattingHints>
              <design:displaySize>2</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>month(date_comin)</design:name>
              <design:position>2</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>4</design:nativeDataTypeCode>
            <design:precision>2</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>month(date_comin)</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>month(date_comin)</design:label>
            <design:formattingHints>
              <design:displaySize>2</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>av</design:name>
              <design:position>3</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>3</design:nativeDataTypeCode>
            <design:precision>18</design:precision>
            <design:scale>8</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>av</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>av</design:label>
            <design:formattingHints>
              <design:displaySize>20</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>av2</design:name>
              <design:position>4</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>3</design:nativeDataTypeCode>
            <design:precision>18</design:precision>
            <design:scale>8</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>av2</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>av2</design:label>
            <design:formattingHints>
              <design:displaySize>20</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>cnt</design:name>
              <design:position>5</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>-5</design:nativeDataTypeCode>
            <design:precision>21</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>NotNullable</design:nullability>
            <design:uiHints>
              <design:displayName>cnt</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>cnt</design:label>
            <design:formattingHints>
              <design:displaySize>21</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
      </design:resultSetColumns>
      <design:criteria/>
    </design:resultSetDefinitions>
  </design:ResultSets>
</model:DesignValues>]]></xml-property>
        </oda-data-set>
        <oda-data-set extensionID="org.eclipse.birt.report.data.oda.jdbc.JdbcSelectDataSet" name="Data Set1" id="1628">
            <list-property name="columnHints">
                <structure>
                    <property name="columnName">kab</property>
                    <property name="analysis">measure</property>
                    <text-property name="displayName">kab</text-property>
                    <text-property name="heading">kab</text-property>
                </structure>
            </list-property>
            <list-property name="parameters"/>
            <structure name="cachedMetaData">
                <list-property name="resultSet">
                    <structure>
                        <property name="position">1</property>
                        <property name="name">kab</property>
                        <property name="dataType">integer</property>
                    </structure>
                </list-property>
            </structure>
            <property name="dataSource">Data Source1</property>
            <list-property name="resultSet">
                <structure>
                    <property name="position">1</property>
                    <property name="name">kab</property>
                    <property name="nativeName">kab</property>
                    <property name="dataType">integer</property>
                </structure>
            </list-property>
            <xml-property name="queryText"><![CDATA[SELECT window_num AS kab FROM public.stations ]]></xml-property>
            <xml-property name="designerValues"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<model:DesignValues xmlns:design="http://www.eclipse.org/datatools/connectivity/oda/design" xmlns:model="http://www.eclipse.org/birt/report/model/adapter/odaModel">
  <Version>2.0</Version>
  <design:ResultSets derivedMetaData="true">
    <design:resultSetDefinitions>
      <design:resultSetColumns>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>kab</design:name>
              <design:position>1</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>4</design:nativeDataTypeCode>
            <design:precision>11</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>NotNullable</design:nullability>
            <design:uiHints>
              <design:displayName>kab</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>kab</design:label>
            <design:formattingHints>
              <design:displaySize>11</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
      </design:resultSetColumns>
      <design:criteria/>
    </design:resultSetDefinitions>
  </design:ResultSets>
</model:DesignValues>]]></xml-property>
        </oda-data-set>
        <oda-data-set extensionID="org.eclipse.birt.report.data.oda.jdbc.JdbcSelectDataSet" name="calen" id="1732">
            <list-property name="columnHints">
                <structure>
                    <property name="columnName">kab</property>
                    <text-property name="displayName">kab</text-property>
                    <text-property name="heading">kab</text-property>
                </structure>
            </list-property>
            <structure name="cachedMetaData">
                <list-property name="resultSet">
                    <structure>
                        <property name="position">1</property>
                        <property name="name">kab</property>
                        <property name="dataType">integer</property>
                    </structure>
                </list-property>
            </structure>
            <property name="dataSource">Data Source1</property>
            <list-property name="resultSet">
                <structure>
                    <property name="position">1</property>
                    <property name="name">kab</property>
                    <property name="nativeName">kab</property>
                    <property name="dataType">integer</property>
                    <property name="nativeDataType">4</property>
                </structure>
            </list-property>
            <xml-property name="queryText"><![CDATA[SELECT window_num AS kab FROM public.stations ]]></xml-property>
            <xml-property name="designerValues"><![CDATA[<?xml version="1.0" encoding="UTF-8"?>
<model:DesignValues xmlns:design="http://www.eclipse.org/datatools/connectivity/oda/design" xmlns:model="http://www.eclipse.org/birt/report/model/adapter/odaModel">
  <Version>2.0</Version>
  <design:ResultSets derivedMetaData="true">
    <design:resultSetDefinitions>
      <design:resultSetColumns>
        <design:resultColumnDefinitions>
          <design:attributes>
            <design:identifier>
              <design:name>kab</design:name>
              <design:position>1</design:position>
            </design:identifier>
            <design:nativeDataTypeCode>4</design:nativeDataTypeCode>
            <design:precision>10</design:precision>
            <design:scale>0</design:scale>
            <design:nullability>Nullable</design:nullability>
            <design:uiHints>
              <design:displayName>kab</design:displayName>
            </design:uiHints>
          </design:attributes>
          <design:usageHints>
            <design:label>kab</design:label>
            <design:formattingHints>
              <design:displaySize>11</design:displaySize>
            </design:formattingHints>
          </design:usageHints>
        </design:resultColumnDefinitions>
      </design:resultSetColumns>
      <design:criteria/>
    </design:resultSetDefinitions>
  </design:ResultSets>
</model:DesignValues>]]></xml-property>
        </oda-data-set>
    </data-sets>
    <cubes>
        <tabular-cube name="Data Cube - Набор данных1" id="1439">
            <property name="dimensions">
                <tabular-dimension name="Группа" id="1440">
                    <property name="defaultHierarchy">NewTabularHierarchy</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy" id="1441">
                            <property name="levels">
                                <tabular-level name="day(date_comin)" id="1442">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">day(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
                <tabular-dimension name="Группа1" id="1443">
                    <property name="defaultHierarchy">NewTabularHierarchy1</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy1" id="1444">
                            <property name="levels">
                                <tabular-level name="month(date_comin)" id="1445">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">month(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
            </property>
            <property name="measureGroups">
                <tabular-measure-group name="Summary Field" id="1446">
                    <property name="measures">
                        <tabular-measure name="av" id="1447">
                            <property name="function">sum</property>
                            <property name="isCalculated">false</property>
                            <expression name="measureExpression" type="javascript">dataSetRow[av]</expression>
                            <property name="dataType">float</property>
                            <property name="isVisible">true</property>
                        </tabular-measure>
                        <tabular-measure name="av23" id="1678">
                            <expression name="measureExpression" type="javascript">dataSetRow["av2"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                        <tabular-measure name="cnt2" id="1679">
                            <expression name="measureExpression" type="javascript">dataSetRow["cnt"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
            </property>
            <property name="dataSet">Набор данных1</property>
        </tabular-cube>
        <tabular-cube name="Data Cube1" id="1629">
            <property name="dimensions">
                <tabular-dimension name="Group2" id="1630">
                    <property name="defaultHierarchy">NewTabularHierarchy4</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy4" id="1631">
                            <property name="levels">
                                <tabular-level name="day(date_comin)" id="1632">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">day(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
                <tabular-dimension name="Group3" id="1633">
                    <property name="defaultHierarchy">NewTabularHierarchy5</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy5" id="1634">
                            <property name="levels">
                                <tabular-level name="month(date_comin)" id="1635">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">month(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
            </property>
            <property name="measureGroups">
                <tabular-measure-group name="Summary Field2" id="1636">
                    <property name="measures">
                        <tabular-measure name="av2" id="1637">
                            <expression name="measureExpression" type="javascript">dataSetRow["av"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
                <tabular-measure-group name="Summary Field3" id="1638">
                    <property name="measures">
                        <tabular-measure name="av21" id="1639">
                            <expression name="measureExpression" type="javascript">dataSetRow["av2"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
                <tabular-measure-group name="Summary Field4" id="1640">
                    <property name="measures">
                        <tabular-measure name="cnt" id="1641">
                            <expression name="measureExpression" type="javascript">dataSetRow["cnt"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
            </property>
            <property name="dataSet">Набор данных1</property>
        </tabular-cube>
        <tabular-cube name="Data Cube2" id="1744">
            <property name="dimensions">
                <tabular-dimension name="Group4" id="1745">
                    <property name="defaultHierarchy">NewTabularHierarchy21</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy21" id="1746">
                            <property name="levels">
                                <tabular-level name="day(date_comin)" id="1747">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">day(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
                <tabular-dimension name="Group11" id="1748">
                    <property name="defaultHierarchy">NewTabularHierarchy31</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy31" id="1749">
                            <property name="levels">
                                <tabular-level name="month(date_comin)" id="1750">
                                    <property name="dataType">integer</property>
                                    <property name="columnName">month(date_comin)</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
            </property>
            <property name="measureGroups">
                <tabular-measure-group name="Summary Field11" id="1751">
                    <property name="measures">
                        <tabular-measure name="av11" id="1752">
                            <expression name="measureExpression" type="javascript">dataSetRow["av"]</expression>
                            <property name="dataType">float</property>
                        </tabular-measure>
                        <tabular-measure name="av221" id="1753">
                            <expression name="measureExpression" type="javascript">dataSetRow["av2"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                        <tabular-measure name="cnt11" id="1754">
                            <expression name="measureExpression" type="javascript">dataSetRow["cnt"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
            </property>
            <property name="dataSet">Набор данных1</property>
        </tabular-cube>
        <tabular-cube name="Data Cube" id="1565">
            <property name="dimensions">
                <tabular-dimension name="Group" id="1566">
                    <property name="defaultHierarchy">NewTabularHierarchy2</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy2" id="1567">
                            <property name="levels">
                                <tabular-level name="day_date_comin" id="1568">
                                    <property name="dataType">integer</property>
                                    <property name="levelType">dynamic</property>
                                    <property name="columnName">day_date_comin</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
                <tabular-dimension name="Group1" id="1569">
                    <property name="defaultHierarchy">NewTabularHierarchy3</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy3" id="1570">
                            <property name="levels">
                                <tabular-level name="month_date_comin" id="1571">
                                    <property name="dataType">integer</property>
                                    <property name="levelType">dynamic</property>
                                    <property name="columnName">month_date_comin</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
                <tabular-dimension name="Group5" id="1765">
                    <property name="defaultHierarchy">NewTabularHierarchy6</property>
                    <property name="hierarchies">
                        <tabular-hierarchy name="NewTabularHierarchy6" id="1766">
                            <property name="levels">
                                <tabular-level name="mname" id="1767">
                                    <property name="dataType">string</property>
                                    <property name="columnName">mname</property>
                                </tabular-level>
                            </property>
                        </tabular-hierarchy>
                    </property>
                </tabular-dimension>
            </property>
            <property name="measureGroups">
                <tabular-measure-group name="Summary Field1" id="1572">
                    <property name="measures">
                        <tabular-measure name="av1" id="1573">
                            <expression name="measureExpression" type="javascript">dataSetRow["av"]</expression>
                            <property name="dataType">float</property>
                        </tabular-measure>
                        <tabular-measure name="av22" id="1669">
                            <expression name="measureExpression" type="javascript">dataSetRow["av2"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                        <tabular-measure name="cnt1" id="1670">
                            <expression name="measureExpression" type="javascript">dataSetRow["cnt"]</expression>
                            <property name="dataType">decimal</property>
                        </tabular-measure>
                    </property>
                </tabular-measure-group>
            </property>
            <property name="dataSet">Набор данных1</property>
        </tabular-cube>
    </cubes>
    <styles>
        <style name="report" id="4">
            <property name="fontFamily">sans-serif</property>
            <property name="fontSize">10pt</property>
        </style>
        <style name="crosstab-cell" id="5">
            <property name="borderBottomColor">#CCCCCC</property>
            <property name="borderBottomStyle">solid</property>
            <property name="borderBottomWidth">1pt</property>
            <property name="borderLeftColor">#CCCCCC</property>
            <property name="borderLeftStyle">solid</property>
            <property name="borderLeftWidth">1pt</property>
            <property name="borderRightColor">#CCCCCC</property>
            <property name="borderRightStyle">solid</property>
            <property name="borderRightWidth">1pt</property>
            <property name="borderTopColor">#CCCCCC</property>
            <property name="borderTopStyle">solid</property>
            <property name="borderTopWidth">1pt</property>
        </style>
        <style name="crosstab" id="6">
            <property name="borderBottomColor">#CCCCCC</property>
            <property name="borderBottomStyle">solid</property>
            <property name="borderBottomWidth">1pt</property>
            <property name="borderLeftColor">#CCCCCC</property>
            <property name="borderLeftStyle">solid</property>
            <property name="borderLeftWidth">1pt</property>
            <property name="borderRightColor">#CCCCCC</property>
            <property name="borderRightStyle">solid</property>
            <property name="borderRightWidth">1pt</property>
            <property name="borderTopColor">#CCCCCC</property>
            <property name="borderTopStyle">solid</property>
            <property name="borderTopWidth">1pt</property>
        </style>
    </styles>
    <page-setup>
        <simple-master-page name="Simple MasterPage" id="2">
            <property name="pageBreakAfter">avoid</property>
            <property name="pageBreakBefore">avoid</property>
            <property name="pageBreakInside">avoid</property>
            <property name="showHeaderOnFirst">false</property>
            <property name="showFooterOnLast">false</property>
            <page-footer>
                <text id="3">
                    <property name="contentType">html</property>
                    <text-property name="content"><![CDATA[<value-of>new Date()</value-of>]]></text-property>
                </text>
            </page-footer>
        </simple-master-page>
    </page-setup>
    <body>
        <text-data id="1541">
            <property name="fontSize">24pt</property>
            <property name="fontWeight">bold</property>
            <property name="textAlign">center</property>
            <expression name="valueExpr">params["IP"].displayText</expression>
            <property name="contentType">html</property>
        </text-data>
        <text-data id="1542">
            <property name="fontSize">16pt</property>
            <property name="textAlign">center</property>
            <expression name="valueExpr">"Среднее время ожидания посетителем.  " + "Данные за:  &lt;b>" + params["P_god"].value+"&lt;/b>  год"</expression>
            <property name="contentType">html</property>
        </text-data>
        <extended-item extensionName="Crosstab" extensionVersion="3.7.0" id="1608">
            <property name="cube">Data Cube</property>
            <property name="measureDirection">horizontal</property>
            <property name="measures">
                <extended-item extensionName="MeasureView" id="1619">
                    <property name="measure">av1</property>
                    <property name="detail">
                        <extended-item extensionName="AggregationCell" id="1620">
                            <property name="aggregationOnRow">Group/day_date_comin</property>
                            <property name="aggregationOnColumn">Group5/mname</property>
                            <property name="verticalAlign">top</property>
                            <property name="whiteSpace">nowrap</property>
                            <list-property name="highlightRules">
                                <structure>
                                    <property name="operator">gt</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">30</value>
                                    </simple-property-list>
                                    <property name="backgroundColor">#FF0000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">15</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">30</expression>
                                    <property name="backgroundColor">#FF8040</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">0</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">15</expression>
                                    <property name="backgroundColor">#008000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                            </list-property>
                            <property name="height">25%</property>
                            <property name="content">
                                <data id="1709">
                                    <structure name="numberFormat">
                                        <property name="category">Currency</property>
                                        <property name="pattern">#,##0.00{RoundingMode=HALF_UP}</property>
                                    </structure>
                                    <property name="resultSetColumn">av1_Group/day_date_comin_Group5/mname</property>
                                </data>
                            </property>
                        </extended-item>
                    </property>
                    <property name="header">
                        <extended-item extensionName="CrosstabCell" id="1622"/>
                    </property>
                </extended-item>
                <extended-item extensionName="MeasureView" id="1718">
                    <property name="measure">av22</property>
                    <property name="detail">
                        <extended-item extensionName="AggregationCell" id="1719">
                            <property name="aggregationOnRow">Group/day_date_comin</property>
                            <property name="aggregationOnColumn">Group5/mname</property>
                            <list-property name="highlightRules">
                                <structure>
                                    <property name="operator">gt</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">30</value>
                                    </simple-property-list>
                                    <property name="backgroundColor">#FF0000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">15</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">30</expression>
                                    <property name="backgroundColor">#FF8000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">0</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">15</expression>
                                    <property name="backgroundColor">#008000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                            </list-property>
                            <property name="content">
                                <data id="1720">
                                    <structure name="numberFormat">
                                        <property name="category">Currency</property>
                                        <property name="pattern">#,##0.00{RoundingMode=HALF_UP}</property>
                                    </structure>
                                    <property name="resultSetColumn">av22_Group/day_date_comin_Group5/mname</property>
                                </data>
                            </property>
                        </extended-item>
                    </property>
                    <property name="header">
                        <extended-item extensionName="CrosstabCell" id="1721">
                            <property name="content">
                                <label id="1722">
                                    <text-property name="text">av22</text-property>
                                </label>
                            </property>
                        </extended-item>
                    </property>
                </extended-item>
                <extended-item extensionName="MeasureView" id="1723">
                    <property name="measure">cnt1</property>
                    <property name="detail">
                        <extended-item extensionName="AggregationCell" id="1724">
                            <property name="aggregationOnRow">Group/day_date_comin</property>
                            <property name="aggregationOnColumn">Group5/mname</property>
                            <list-property name="highlightRules">
                                <structure>
                                    <property name="operator">gt</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">30</value>
                                    </simple-property-list>
                                    <property name="backgroundColor">#FF0000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">15</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">30</expression>
                                    <property name="backgroundColor">#FF8000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                                <structure>
                                    <property name="operator">between</property>
                                    <expression name="testExpr" type="javascript">data["av1_Group/day_date_comin_Group5/mname"]</expression>
                                    <simple-property-list name="value1">
                                        <value type="javascript">0</value>
                                    </simple-property-list>
                                    <expression name="value2" type="javascript">15</expression>
                                    <property name="backgroundColor">#008000</property>
                                    <property name="fontWeight">bold</property>
                                    <property name="color">#FFFFFF</property>
                                </structure>
                            </list-property>
                            <property name="content">
                                <data id="1725">
                                    <structure name="numberFormat">
                                        <property name="category">General Number</property>
                                        <property name="pattern">General Number</property>
                                    </structure>
                                    <property name="resultSetColumn">cnt1_Group/day_date_comin_Group5/mname</property>
                                </data>
                            </property>
                        </extended-item>
                    </property>
                    <property name="header">
                        <extended-item extensionName="CrosstabCell" id="1726">
                            <property name="content">
                                <label id="1727">
                                    <text-property name="text">cnt1</text-property>
                                </label>
                            </property>
                        </extended-item>
                    </property>
                </extended-item>
            </property>
            <property name="rows">
                <extended-item extensionName="CrosstabView" id="1610">
                    <property name="views">
                        <extended-item extensionName="DimensionView" id="1757">
                            <property name="dimension">Group</property>
                            <property name="levels">
                                <extended-item extensionName="LevelView" name="NewLevel View" id="1758">
                                    <property name="level">Group/day_date_comin</property>
                                    <property name="member">
                                        <extended-item extensionName="CrosstabCell" id="1759">
                                            <property name="content">
                                                <data name="day_date_comin" id="1760">
                                                    <property name="resultSetColumn">day(date_comin)</property>
                                                </data>
                                            </property>
                                        </extended-item>
                                    </property>
                                </extended-item>
                            </property>
                        </extended-item>
                    </property>
                </extended-item>
            </property>
            <property name="columns">
                <extended-item extensionName="CrosstabView" id="1624">
                    <property name="views">
                        <extended-item extensionName="DimensionView" id="1768">
                            <property name="dimension">Group5</property>
                            <property name="levels">
                                <extended-item extensionName="LevelView" name="NewLevel View1" id="1769">
                                    <property name="level">Group5/mname</property>
                                    <property name="member">
                                        <extended-item extensionName="CrosstabCell" id="1770">
                                            <property name="content">
                                                <data name="mname" id="1771">
                                                    <property name="resultSetColumn">mname</property>
                                                </data>
                                            </property>
                                        </extended-item>
                                    </property>
                                </extended-item>
                            </property>
                        </extended-item>
                    </property>
                </extended-item>
            </property>
            <property name="header">
                <extended-item extensionName="CrosstabCell" id="1609"/>
            </property>
            <property name="hideMeasureHeader">true</property>
            <property name="display">inline</property>
            <structure name="toc"/>
            <list-property name="boundDataColumns">
                <structure>
                    <property name="name">day(date_comin)</property>
                    <expression name="expression" type="javascript">dimension["Group"]["day_date_comin"]</expression>
                    <property name="dataType">integer</property>
                </structure>
                <structure>
                    <property name="name">Column Binding</property>
                    <text-property name="displayName">as</text-property>
                    <expression name="expression" type="javascript">1</expression>
                    <property name="dataType">blob</property>
                </structure>
                <structure>
                    <property name="name">1_1</property>
                    <expression name="expression" type="javascript">1</expression>
                    <property name="dataType">string</property>
                </structure>
                <structure>
                    <property name="name">2_1</property>
                    <expression name="expression" type="javascript">2</expression>
                    <property name="dataType">string</property>
                </structure>
                <structure>
                    <property name="name">day</property>
                    <expression name="expression" type="javascript">dimension["Group"]["day_date_comin"]</expression>
                    <property name="dataType">integer</property>
                </structure>
                <structure>
                    <property name="name">av1</property>
                    <expression name="expression">measure["av1"]</expression>
                    <property name="dataType">float</property>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">av22</property>
                    <expression name="expression">measure["av22"]</expression>
                    <property name="dataType">decimal</property>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">cnt1</property>
                    <expression name="expression">measure["cnt1"]</expression>
                    <property name="dataType">decimal</property>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">av1_Group/day_date_comin</property>
                    <expression name="expression">measure["av1"]</expression>
                    <property name="dataType">float</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">av22_Group/day_date_comin</property>
                    <expression name="expression">measure["av22"]</expression>
                    <property name="dataType">decimal</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">cnt1_Group/day_date_comin</property>
                    <expression name="expression">measure["cnt1"]</expression>
                    <property name="dataType">decimal</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">mname</property>
                    <expression name="expression">dimension["Group5"]["mname"]</expression>
                    <property name="dataType">string</property>
                </structure>
                <structure>
                    <property name="name">av1_Group/day_date_comin_Group5/mname</property>
                    <expression name="expression">measure["av1"]</expression>
                    <property name="dataType">float</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                        <value>Group5/mname</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">av22_Group/day_date_comin_Group5/mname</property>
                    <expression name="expression">measure["av22"]</expression>
                    <property name="dataType">decimal</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                        <value>Group5/mname</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
                <structure>
                    <property name="name">cnt1_Group/day_date_comin_Group5/mname</property>
                    <expression name="expression">measure["cnt1"]</expression>
                    <property name="dataType">decimal</property>
                    <simple-property-list name="aggregateOn">
                        <value>Group/day_date_comin</value>
                        <value>Group5/mname</value>
                    </simple-property-list>
                    <property name="aggregateFunction">SUM</property>
                </structure>
            </list-property>
        </extended-item>
        <grid id="1514">
            <property name="whiteSpace">nowrap</property>
            <property name="masterPage">Simple MasterPage</property>
            <property name="pageBreakAfter">avoid</property>
            <property name="pageBreakBefore">auto</property>
            <property name="pageBreakInside">auto</property>
            <property name="width">7.947916666666667in</property>
            <column id="1515">
                <property name="width">1.2395833333333333in</property>
            </column>
            <column id="1516">
                <property name="width">3.25in</property>
            </column>
            <column id="1517">
                <property name="width">5in</property>
            </column>
            <row id="1518">
                <cell id="1519">
                    <property name="colSpan">3</property>
                    <property name="rowSpan">1</property>
                    <text id="1534">
                        <property name="fontSize">12pt</property>
                        <property name="fontWeight">bold</property>
                        <property name="textAlign">center</property>
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[Легенда]]></text-property>
                    </text>
                </cell>
            </row>
            <row id="1522">
                <cell id="1523">
                    <property name="backgroundColor">red</property>
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                </cell>
                <cell id="1524">
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                    <text id="1511">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[Ожидание свыше 30 минут]]></text-property>
                    </text>
                </cell>
                <cell id="1525">
                    <text id="1728">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[  1  колонка - среднее время ожидания в очереди]]></text-property>
                    </text>
                </cell>
            </row>
            <row id="1526">
                <cell id="1527">
                    <property name="backgroundColor">orange</property>
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                </cell>
                <cell id="1528">
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                    <text id="1512">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[Ожидание от 15 до 30 минут]]></text-property>
                    </text>
                </cell>
                <cell id="1529">
                    <text id="1729">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[  2  колонка - среднее время приема]]></text-property>
                    </text>
                </cell>
            </row>
            <row id="1530">
                <cell id="1531">
                    <property name="backgroundColor">green</property>
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                </cell>
                <cell id="1532">
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                    <text id="1513">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[Ожидание менее 15 минут]]></text-property>
                    </text>
                </cell>
                <cell id="1533">
                    <text id="1730">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[  3  колонка - количество посетителей]]></text-property>
                    </text>
                </cell>
            </row>
            <row id="1535">
                <cell id="1536">
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                </cell>
                <cell id="1537">
                    <property name="borderBottomColor">#000000</property>
                    <property name="borderBottomStyle">solid</property>
                    <property name="borderBottomWidth">thin</property>
                    <property name="borderLeftColor">#000000</property>
                    <property name="borderLeftStyle">solid</property>
                    <property name="borderLeftWidth">thin</property>
                    <property name="borderRightColor">#000000</property>
                    <property name="borderRightStyle">solid</property>
                    <property name="borderRightWidth">thin</property>
                    <property name="borderTopColor">#000000</property>
                    <property name="borderTopStyle">solid</property>
                    <property name="borderTopWidth">thin</property>
                    <text id="1539">
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[Выходной или праздничный день]]></text-property>
                    </text>
                </cell>
                <cell id="1538">
                    <text id="1731">
                        <property name="display">inline</property>
                        <property name="contentType">auto</property>
                        <text-property name="content"><![CDATA[  *  Статистика приводится без учета предварительной записи.]]></text-property>
                    </text>
                </cell>
            </row>
        </grid>
    </body>
</report>
