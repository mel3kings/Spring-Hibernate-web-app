<%@ include file="../common/taglibs.jsp"%>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Event Creation Page</title>
  <link rel="shortcut icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <script type="text/javascript" src="/capture/resources/common/js/switchery.min.js"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">		
  <spring:url value="/resources/common/css/styles.css" var="styleCss" />
  <spring:url value="/resources/common/css/switchery.min.css" var="switcheryCss" />
 <link href="${styleCss}" rel="stylesheet" />
 <link href="${switcheryCss}" rel="stylesheet" />
 
 <script type="text/javascript">

$("#submitBtn").click(function(event) {
	$("#albumForm").submit();
	event.preventDefault();
	$("#overlay").modal('hide');
	return false;
});

</script>
 
</head>
<body>
  <div id="wrapper">
  
  <h1>Create Album</h1>
  
  <form:form id="albumForm" method="POST" action="createAlbum">
  <div class="col-2">
    <label>
     Title
      <input placeholder="Album Title" id="title" name="title" tabindex="1">
    </label>
  </div>
  <div class="col-2">
    <label>
     Name
      <input placeholder="Album Name" id="name" name="name" tabindex="1">
    </label>
  </div>
  <div class="col-3">
    <label>
      Description
      <input placeholder="Album Description" id="description" name="description" tabindex="3">
    </label>
  </div>
  <div class="col-3">
    <label>
     Location
      <input placeholder="Album Location" id="location" name="location" tabindex="4">
    </label>
  </div>
  <div class="col-4">
    <label>
      Date/Time
      <input placeholder="todo datetime?" id="date" name="date" tabindex="6">
    </label>
  </div>
  <input type="hidden" name="eventid" id="eventid" value="${event.eventId}"/>
  <input type="hidden" name="customerid" id="customerid" value="${customer.userId}"/>
  
  </form:form>
  <div class="col-submit">
    <button id="submitBtn" class="btn btn-primary" type="button">Create Album</button>
  </div>
  </div>
<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
elems.forEach(function(html) {
  var switchery = new Switchery(html);
});

</script>
</body>
</html>