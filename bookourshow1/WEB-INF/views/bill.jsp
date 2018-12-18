<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
  <div id="header">
  <img src="bookourshow.jpg"></img></div>
  <div id="main">
    <div id="row">
      <div id="col-sm-4 col-md-4 col-lg-4 col-xs-3">
        <b style="font-family:times;">Booking id</b><input type="text" value="bookingid"></input> 
      <!--</div>!-->
        <!--  <div id="col-sm-4 col-md-4 col-lg-4 col-xs-3">!-->
        <b style="font-family:times;">picture selected</b> <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModal">Movie</button>
         <div class="modal fade" id="myModal">
        <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Movie</h4>
        </div>
        <div class="modal-body">
          <img src="bahubali.jpg"></img>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
        </div>
        <!--  </div>
             <div id="col-sm-4 col-md-4 col-lg-4 col-xs-3">!-->
          <b style="font-family:times;">Booking date</b><input type="text" value="bookingdate"></input> 
       <!--  </div>
        <div id="col-sm-4 col-md-4 col-lg-4 col-xs-3">!-->
        <b style="font-family:times;">Venue.venuename</b><input type="text" value="venue"></input> 
      </div>
        </div>
    </div>
  
    
</body>
</html>