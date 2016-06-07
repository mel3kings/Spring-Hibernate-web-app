<%@ include file="../common/taglibs.jsp"%>
<body>
  <div id="wrapper">
  <h1>Register Business</h1>
  <form:form method="POST" action="updateBusiness">
  <input type="hidden" id="businessId" name="businessId" value="${business.businessId}"/>
  <div class="col-2">
    <label>
     Business Name
      <input placeholder="Business name" id="businessName" name="businessName" value="${business.businessName}" tabindex="1">
    </label>
  </div>
  <div class="col-3">
    <label>
     Address
      <input placeholder="Business Address" id="businessAddress" name="businessAddress" value="${business.businessAddress }" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
     City
      <input placeholder="Business City" id="businessCity" name="businessCity" value="${business.businessCity}" tabindex="4">
    </label>
  </div>
  
  <div class="col-4">
    <label>
      Description
      <input placeholder="Description" id="description" name="description" value="${business.description}" tabindex="6">
    </label>
  </div>
  <div class="col-submit">
    <button class="submitbtn">Update Business</button>
  </div>
  
  </form:form>
   
  <form:form method="POST" action="deleteBusiness/${business.businessId}">
  <div class="col-submit">
    <button class="submitbtn">Delete Business</button>
  </div>
  </form:form>
  </div>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>