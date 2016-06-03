<%@ page language="java" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1660177537640645',
      xfbml      : true,
      version    : 'v2.6'
    });
	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    if (response.status === 'connected') {
		      setFBFields();
	    } else if (response.status === 'not_authorized') {
	     	alert("User has not authorized application");
	    } else {
			alert("Please login your Facebook account");
	    }
	  }

	  // This function is called when someone finishes with the Login
	  // Button.  See the onlogin handler attached to it in the sample
	  // code below.
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }

	 function logoutOutUser(){
		FB.logout();
	}

	

	 
</script>
    