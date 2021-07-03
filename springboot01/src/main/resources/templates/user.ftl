<#--
  Created by IntelliJ IDEA.
  @Desc 
  @author <a href="mailto:chenming1@eversec.cn">chenming</a>
  @date 2021/7/3 0003 16:41
  @version 1.0.0
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1px" align="center" width="50%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>AGE</td>
    </tr>
    <#list users as user >
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>