<%@ include file="../common/taglibs.jsp"%>
<body>
  <div id="wrapper">
  <h1>Register Business</h1>
  <form:form method="POST" action="createBusiness">
  <input type="hidden" id="businessId" name="businessId"/>
  <div class="col-2">
    <label>
     Business Name
      <input placeholder="Business name" id="businessName" name="businessName" tabindex="1">
    </label>
  </div>
  <div class="col-3">
    <label>
     Address
      <input placeholder="Business Address" id="businessAddress" name="businessAddress" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
     City
      <input placeholder="Business City" id="businessCity" name="businessCity" tabindex="4">
    </label>
  </div>
  
  <div class="col-4">
    <label>
      Description
      <input placeholder="Description" id="description" name="description" tabindex="6">
    </label>
  </div>
  <div class="col-submit">
    <button class="submitbtn">Save Business</button>
  </div>
  
  </form:form>
   
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>