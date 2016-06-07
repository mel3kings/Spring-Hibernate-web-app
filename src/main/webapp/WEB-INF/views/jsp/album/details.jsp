<%@ include file="../common/taglibs.jsp"%>
<head>
<style>
#filedrag
{
	display: none;
	font-weight: bold;
	text-align: center;
	padding: 1em 0;
	margin: 1em 0;
	color: #555;
	border: 2px dashed #555;
	border-radius: 7px;
	cursor: default;
	height: 80px;
}

#filedrag.hover
{
	color: #f00;
	border-color: #f00;
	border-style: solid;
	box-shadow: inset 0 3px 4px #888;
}

#uploadFile {
	display:none;
}
</style>
 
</head>
<body>
  <div id="wrapper">
  
  <h1>Album</h1>
  
  <form:form id="albumForm" method="POST" action="createAlbum">
  <div class="col-2">
    <label>
     Title
      <input placeholder="Album Title" id="title" name="title" tabindex="1" disabled="disabled">
    </label>
  </div>
  <div class="col-2">
    <label>
     Name
      <input placeholder="Album Name" id="name" name="name" tabindex="1" disabled="disabled">
    </label>
  </div>
  <div class="col-3">
    <label>
      Description
      <input placeholder="Album Description" id="description" name="description" tabindex="3" disabled="disabled">
    </label>
  </div>
  <div class="col-3">
    <label>
     Location
      <input placeholder="Album Location" id="location" name="location" tabindex="4" disabled="disabled">
    </label>
  </div>
  <div class="col-4">
    <label>
      Date/Time
      <input placeholder="todo datetime?" id="date" name="date" tabindex="6" disabled="disabled">
    </label>
  </div>
 
  <input type="hidden" name="albumId" id="albumId" value="${album.albumId}"/>
  
  </form:form>
  <div>
    <c:forEach var="mediaList" items="${mediaList}">
				<li>${mediaList.mediaName}</li>
			</c:forEach>
  </div>
  <div class="col-submit">
    <button id="submitBtn" class="btn btn-primary" type="button">Update Album</button>
  </div>
  
  <form:form id="upload" action="uploadMedia/${album.albumId}" method="POST" enctype="multipart/form-data">

		<fieldset>

		<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE" value="300000" />

		<div>
			<input type="file" id="uploadFile" name="uploadFile" multiple="multiple" />
			<div id="filedrag">drop files here</div>
		</div>

		<div id="submitbutton">
			<button class="btn btn-primary" type="submit">Upload Files</button>
		</div>

		</fieldset>

  </form:form>
  <div id="messages">
<p>Status Messages</p>
</div>
  </div>
<script type="text/javascript">
//getElementById
function $id(id) {
	return document.getElementById(id);
}

//
//output information
function Output(msg) {
	var m = $id("messages");
	m.innerHTML = msg + m.innerHTML;
}

function parseFile(file) {

	Output(
		"<p>File information: <strong>" + file.name +
		"</strong> type: <strong>" + file.type +
		"</strong> size: <strong>" + file.size +
		"</strong> bytes</p>"
	);
	
}

 if (window.File && window.FileList && window.FileReader) {
		Init();
	} 
//initialize
function Init() {

	var fileselect = $id("uploadFile"),
		filedrag = $id("filedrag"),
		submitbutton = $id("submitbutton");
	
	// file select
	fileselect.addEventListener("change", FileSelectHandler, false);

	// is XHR2 available?
	var xhr = new XMLHttpRequest();
	if (xhr.upload) {
	
		// file drop
		filedrag.addEventListener("dragover", FileDragHover, false);
		filedrag.addEventListener("dragleave", FileDragHover, false);
		filedrag.addEventListener("drop", FileSelectHandler, false);
		filedrag.style.display = "block";
		
		// remove submit button
		submitbutton.style.display = "none";
	}

}

//file drag hover
function FileDragHover(e) {
	e.stopPropagation();
	e.preventDefault();
	e.target.className = (e.type == "dragover" ? "hover" : "");
}

//file selection
function FileSelectHandler(e) {

	// cancel event and hover styling
	FileDragHover(e);

	// fetch FileList object
	var files = e.target.files || e.dataTransfer.files;

	// process all File objects
	for (var i = 0, f; f = files[i]; i++) {
		parseFile(f);
		uploadFile(f);
	}

}

//upload JPEG files
function uploadFile(file) {
	
	var oMyForm = new FormData();
    oMyForm.append("uploadFile", file);
    var sUrl = $id("upload").action;
	
    $.ajax({url : sUrl,
        data : oMyForm,
        type : "POST",
        enctype: 'multipart/form-data',
        processData: false, 
        contentType:false,
        success : function(result) {
            window.location.reload();
        },
        error : function(result){
        	alert('upload failed');
        }
    });

}
</script>
<%@ include file="../common/endtaglibs.jsp"%>
</body>
</html>