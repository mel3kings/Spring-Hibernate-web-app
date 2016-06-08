<%@ include file="../common/taglibs.jsp"%>
<body>
  <div id="wrapper">
  <h1>Customer Details</h1>
  <form:form method="POST" action="updateCustomer">
  <div class="col-2">
    <label>
    User Id
      <input placeholder="Id" id="userId" name="userId" value="${customer.userId}" tabindex="1">
    </label>
  </div>
  <div class="col-3">
    <label>
     Name
      <input placeholder="Name" id="name" name="name" value="${customer.name}" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
     Address
      <input placeholder="Address" id="address" name="address" value="${customer.address}" tabindex="4">
    </label>
  </div>
  
  <div class="col-4">
    <label>
      City
      <input placeholder="City" id="city" name="city" value="${customer.city}" tabindex="6">
    </label>
  </div>
  <div class="col-4">
    <label>
      Email
      <input placeholder="Email" id="email" name="email" value="${customer.email}"tabindex="6">
    </label>
  </div>
   <div class="col-4">
    <label>
      Mobile Number
      <input placeholder="Mobile Number" id="mobileNumber" name="mobileNumber" value="${customer.mobileNumber}" tabindex="6">
    </label>
  </div>
   <div class="col-4">
    <label>
      Telephone Number
      <input placeholder=" Telelphone Number" id="telephoneNumber" name="telephoneNumber" value="${customer.telephoneNumber}" tabindex="6">
    </label>
  </div>
  <div class="col-submit">
    <button class="submitbtn">Update Customer</button>
  </div>
  
  </form:form>
   </div>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>