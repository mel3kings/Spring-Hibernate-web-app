<%@ include file="../common/taglibs.jsp"%>
<body>
	<div id="wrapper">
		<h1>${album.title}</h1>
		<h3>${album.location }</h3>
		<h3>${album.description }</h3>

		<input type="hidden" value="${album.albumId}" name="albumId"
			id="albumId" />
			
			<c:forEach var="mediaList" items="${mediaList}">
				<li>${mediaList.mediaName}</li>
			</c:forEach>
	</div>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
