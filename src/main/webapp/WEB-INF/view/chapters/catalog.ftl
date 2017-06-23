<#assign basePath=request.contextPath />
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>小说章节目录</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <table>
        <h1>
            ${novelDetail.name}&nbsp;&nbsp;•&nbsp;&nbsp;${novelDetail.author}
        </h1>
        <#list catalogList?chunk(4) as catalogs>
        <tr class=<#if catalogs_index % 2 == 0>'oddBg'<#else>'evenBg'</#if>>
            <#list catalogs as catalog>
                <td><a href="/chapters/${catalog.id}">${catalog.name!}</a></td>
            </#list>
        </tr>
        </#list>
    </table>
</body>
</html>
