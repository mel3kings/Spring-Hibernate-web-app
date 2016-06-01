<%@ include file="../common/taglibs.jsp"%>
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Event Creation Page</title>
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
  
  <h1>Event Creation</h1>
  
  <form:form method="POST" action="createEvent">
  <div class="col-2">
    <label>
     Title/Event Name
      <input placeholder="Event Title" id="eventName" name="eventName" tabindex="1">
    </label>
  </div>
  <!--  <div class="col-2">
    <label>
     Album:
      <input placeholder="TO DO checkboxes for albums?" id="album" name="album" tabindex="2">
    </label>
  </div> -->
  
  <div class="col-3">
    <label>
      Customer
      <input placeholder="Dropdown of customers or auto-set if it's the customer creating the event" id="customerUserId" name="customerUserId" tabindex="3">
    </label>
  </div>
  <div class="col-3">
    <label>
     Location
      <input placeholder="Event Location" id="eventLocation" name="eventLocation" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
     City
      <input placeholder="Event City" id="eventCity" name="eventCity" tabindex="4">
    </label>
  </div>
  
  <div class="col-4">
    <label>
      Date/Time
      <input placeholder="todo datetime picker?" id="eventDateTime" name="eventDateTime" tabindex="6">
    </label>
  </div>
  <div class="col-4">
    <label>
      Hashtags
      <input placeholder="Hashtags" id="eventHashTag" name="eventHashTag" tabindex="7">
    </label>
  </div>
  <div class="col-6">
    <label>Event Description
    <input placeholder="Event Description" id="eventDescription" name="eventDescription" tabindex="7">
    </label>
   </div>
  
  <div class="col-submit">
    <button class="submitbtn">Create Event</button>
  </div>
  
  </form:form>
  </div>
<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
elems.forEach(function(html) {
  var switchery = new Switchery(html);
});
</script>
</body>
</html>