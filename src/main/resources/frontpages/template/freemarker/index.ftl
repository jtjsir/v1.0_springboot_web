<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>freemarker</title>
<#import "common.ftl" as common>
</head>
<body>
	<h1>${hello}</h1>
	<div>
		<p>some people say hello to Springboot</p>
		<#--date类型的需要?date进行转换下-->
		<p>${user.name}-${user.age}-${user.birthday?date}-${user.email}</p>
		<p>${common.ctx!"spring"}--${request.contextPath}</p>
		<p>${requestAttr}</p>
	</div>
</body>
</html>