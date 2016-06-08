<%@ include file="../common/taglibs.jsp"%>
<body>
  <div id="wrapper">
  <h1>Customer Details</h1>
  <form:form method="POST" action="createCustomer">
  <div class="col-2">
    <label>
    User Id
      <input placeholder="Id" id="userId" name="userId" tabindex="1">
    </label>
  </div>
  <div class="col-3">
    <label>
     Name
      <input placeholder="Name" id="name" name="name" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
     Address
      <input placeholder="Address" id="address" name="address" tabindex="4">
    </label>
  </div>
  
  <div class="col-4">
    <label>
      City
      <input placeholder="City" id="city" name="city" tabindex="6">
    </label>
  </div>
  <div class="col-4">
    <label>
      Email
      <input placeholder="Email" id="email" name="email" tabindex="6">
    </label>
  </div>
   <div class="col-4">
    <label>
      Mobile Number
      <input placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" tabindex="6">
    </label>
  </div>
   <div class="col-4">
    <label>
      Telephone Number
      <input placeholder=" Telelphone Number" id="telephoneNumber" name="telephoneNumber" tabindex="6">
    </label>
  </div>
  <div class="col-submit">
    <button class="submitbtn">Save Customer</button>
  </div>
  
  </form:form>
   </div>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>