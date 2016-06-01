<%@ include file="../common/taglibs.jsp"%>
<head>
<title>Successfully created an event</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<spring:url value="/resources/style/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<script type="text/javascript">
	var vid = document.getElementById("bgvid");
	var pauseButton = document.querySelector("#polina button");

	function vidFade() {
		vid.classList.add("stopfade");
	}

	vid.addEventListener('ended', function() {
		// only functional if "loop" is removed 
		vid.pause();
		// to capture IE10
		vidFade();
	});

	pauseButton.addEventListener("click", function() {
		vid.classList.toggle("stopfade");
		if (vid.paused) {
			vid.play();
			pauseButton.innerHTML = "Pause";
		} else {
			vid.pause();
			pauseButton.innerHTML = "Paused";
		}
	})

	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>



</head>

<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index.html">scumba<span class="logo_colour">_business</span></a>
					</h1>
					<h2>Simple. Contemporary. We make shit. ${name}</h2>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<h2>
							Welcome : ${pageContext.request.userPrincipal.name} | 
						</h2>
						<a href="<c:url value="j_spring_security_logout" />" ><font color="white">Logout</font></a>
					</c:if>
				</div>
			</div>
			<div id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="index.html">Home</a></li>
					<li><a href="page.html">Wedding Details</a></li>
					<li><a href="examples.html">Entourage</a></li>
					<li class="selected"><a href="another_page.html">Guest
							Guide</a></li>
					<li><a href="contact.html">RSVP</a></li>
				</ul>
			</div>
		</div>

		<br>
		<div
			style="position: absolute; z-index: -99; width: 100%; height: 100%">
			<!-- <iframe frameborder="0" height="100%" width="100%" 
			src="https://youtube.com/embed/UtJnmt1tt4I?autoplay=1&controls=0&showinfo=0&autohide=1">
		  </iframe>-->
		</div>



		<div id="site_content">


			<div id="polina">

				<p>Failed to save event: ${name}</p>

				<!--<a class="twitter-timeline" href="https://twitter.com/hashtag/PiliPinasDebates2016" data-widget-id="730989554967011328">#PiliPinasDebates2016 Tweets</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>-->
			</div>
		</div>
</body>

