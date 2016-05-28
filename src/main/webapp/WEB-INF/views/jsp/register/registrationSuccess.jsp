<%@ include file="../common/taglibs.jsp"%>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Registration Page</title>
  <link rel="shortcut icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <script type="text/javascript" src="/capture/resources/common/js/switchery.min.js"></script>		
  <spring:url value="/resources/common/css/styles.css" var="styleCss" />
  <spring:url value="/resources/common/css/switchery.min.css" var="switcheryCss" />
 <link href="${styleCss}" rel="stylesheet" />
 <link href="${switcheryCss}" rel="stylesheet" />
 
</head>

<body>
  <div id="wrapper">
  
  <h1>User Registration Success</h1>
 <br/>
 <br/> 
  	<h1> ${name} has been successfully been registered! Proceed to login: login_link </h1>
 </div> 
 </body>
</html>