<%@ taglib prefix = "cc"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <title>Profles !!!!!!!!!!!</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
  <script>
  //jQuery Ready Hander
	  $(document).ready(function(){
			$("#imgInp").change(function() {
		  		readURL(this);
			});
	  }); 

  //Code which is used to preview the image 
  function readURL(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.onload = function(e) {
	      $('#ppimage').attr('src', e.target.result);
	    }
	    reader.readAsDataURL(input.files[0]); // convert to base64 string
	  }
	}
  
  function openModal(username,email){
	 $("#pemail").html(email);
	 
	 var imgURL = "${pageContext.request.contextPath}/load/image?username="+username;
	 $("#pimage").attr("src",imgURL);
	 
	 //need to edit the image when data is sent from server to the client
	 $("#username").val(username);
	 
  	$("#changeImageModel").modal("show");
  }
  </script>
  <style>
.zoom {
  transition: transform .9s; /* Animation */
  margin: 0 auto;
}
.zoom:hover {
  transform: scale(2.0); /* (200% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}
</style>
</head>
<body>
   <header  style="height: 30px;background-color: #21c9ff;">
   <b style="margin-left: 50px;">Coming soon </b>
   </header>
    <div  class="container">
         <!-- sessionScope  is called implicit EL object -->
         <img src="img/student.png"  style="height: 139px">
                
                <button type="button" class="btn btn-primary">Manage Users</button>
   				  <button type="reset" class="btn btn-danger">Email</button>
   				  	 <a href="iprofiles">
   				  	   <button type="button" class="btn btn-success">IProfiles</button>
   				  	      </a>
   				            <a href="profiles">
   				  	        <button type="button" class="btn btn-success">Profiles</button>
   				  	        </a>				  	        
   				  	        <a href="loggedUser">
   				  	        <button type="button" class="btn btn-primary">Logged in User</button>
   				  	        </a>
   				  	  <a href="logout"> 
   				  	        <button type="button" class="btn btn-warning">Logout</button>
   				  	 </a>
         <hr/>
          <form action="searchProfile">
               <input type="text" name="search" class="form-control" style="width: 50%;display: inline;"/>
               <button type="submit" class="btn btn-primary">Go</button>
                   <a href="profiles">
                   <button type="button" class="btn btn-primary">Clear</button>
                   </a>
          </form>
           <hr/>
            <form action="filterProfile">
           <select name="filterText" class="form-control" style="width: 80%;display: inline;">
           <option>Select</option>
           <cc:forEach  items="${listoptions}"  var="toption">
                  <option>${toption}</option>           
                 </cc:forEach> 
           </select>
           <button type="submit" class="btn btn-primary" style="margin-top: -4px;">Go</button>
           </form>
          <hr/>
        <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Password</th>
         <th>Name</th>
        <th>Email
               <a  href="sortProfile?sort=asc">
                  <img src="img/asc.png"/>
               </a>
               <a  href="sortProfile?sort=desc">
                   <img src="img/desc.png"/>
              </a>
        
        </th>
        <th>Qualification</th>
        <th>Mobile</th>
        <th>Photo</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <cc:forEach  items="${profileDTOs}"  var="profileDTO">
      <tr>
        <td>${profileDTO.username}</td>
        <td>${profileDTO.password}</td>
        <td>${profileDTO.name}</td>
        
        <td>${profileDTO.email}
        <td>${profileDTO.qualification}</td>
        <td>${profileDTO.mobile}</td>
        <td>
         <img src="${pageContext.request.contextPath}/load/image?username=${profileDTO.username}"  style="height: 120px;"  class="zoom"/>
         <a href="javascript:openModal('${profileDTO.username}','${profileDTO.email}');">
         <img src="${pageContext.request.contextPath}/img/edita.png">
         </a>
        </td>
        <td >
            <a href="editProfile?username=${profileDTO.username}">
            <button type="button" class="btn btn-primary">E</button>
            </a>
               <a href="deleteProfile?username=${profileDTO.username}">
           <button type="button" class="btn btn-danger">D</button>
            </a>
        </td>
      </tr>
      </cc:forEach>
    </tbody>
  </table>
    </div>

	 <!-- The Modal Code -->
<div class="modal" id="changeImageModel">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="${pageContext.request.contextPath}/changeImage" method="post" enctype="multipart/form-data">
       
       <input type="hidden" name="username" id="username"/>
       
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Edit Profile Image</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <label>Email : <span id="pemail" style="font-size: 18px;font-weight: bold;"></span></label>
        <hr/>
        <marquee scrolldelay="100">
        <img src="" id="pimage" style="height: 100px;">
        
        <img src="" id="ppimage" style="height: 100px;">
        <input type="file" name="file" id="imgInp" class="form-control"/>
        </marquee>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
       <button type="submit" class="btn btn-primary">Change Photo</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
</form>
    </div>
  </div>
</div>
   
  
</body>
</html>