<%@ include file="../common/taglibs.jsp"%>
<body>
  <div id="wrapper">
  
  <h1>User Registration</h1>
  <form:form method="POST" action="submitRegister">
  <div class="col-2">
    <label>
     Name
      <input placeholder="What is your name?"  id="userName" name="userName" tabindex="1">
    </label>
  </div>
  <div class="col-2">
    <label>
     Company
      <input placeholder="TO DO drop down of companies" id="BusinessId" name="BusinessId" tabindex="2">
    </label>
  </div>
  
  <div class="col-3">
    <label>
      User Id
      <input placeholder="What is your preferred User id?" id="userId" name="userId" tabindex="3">
    </label>
  </div>
  <div class="col-3">
    <label>
     Email
      <input placeholder="What is your e-mail address?" id="email" name="email" tabindex="4">
    </label>
  </div>
  <div class="col-3">
    <label>
      Role
      <select tabindex="5">
        <option>ADMIN</option>
        <option>CUSTOMER</option>
        <option>TESTER</option>
      </select>
    </label>
  </div>
  
  <div class="col-4">
    <label>
      Password
      <input placeholder="todo" id="password" name="password" tabindex="6">
    </label>
  </div>
  <div class="col-4">
    <label>
      Mobile Number
      <input placeholder="Personal Number" id="mobileNumber" name="mobileNumber" tabindex="7">
    </label>
  </div>
  <div class="col-4">
    <label>Office Number
    <input placeholder="Office Number" id="officeNumber" name="officeNumber" tabindex="7">
    </label>
   </div>
   <div class="col-4">
    <label>Facebook Account</label>
    &nbsp; &nbsp; &nbsp; &nbsp;
    <fb:login-button scope="email,user_birthday,user_work_history" onlogin="checkLoginState();">
    Create Account with Facebook</fb:login-button>
    <br/>
</div>
  
  <div class="col-submit">
    <button class="submitbtn">Submit Form</button>
  </div>
  
  </form:form>
  </div>
<script type="text/javascript">
function setFBFields() {
  console.log('Welcome!  Fetching your information v2.... ');
  FB.api('/me?fields=name,email,work,birthday', function(response) {
	  var jsonResponse = JSON.stringify(response);
	  console.log(jsonResponse); 
	  alert("Success retrieved user data: "+ jsonResponse);  
	});
}
</script>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>