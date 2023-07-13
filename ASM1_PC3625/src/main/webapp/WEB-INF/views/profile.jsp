<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORGOT PASSWORD</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
</head>
<style type="text/css">
body{
    background: url('/images/bg.jpg');
    background-size: cover;
    background-position-y: -80px;
    font-size: 16px;
    background-color: gray;
}
#wrapper{
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}
#form-login{
    max-width: 400px;
    background: rgba(0, 0, 0 , 0.3);
    flex-grow: 1;
    padding: 30px 30px 40px;
    box-shadow: 0px 0px 17px 2px rgba(255, 255, 255, 0.8);
}
#eye i{
    padding-right: 0;
    cursor: pointer;
}
.form-heading{
    font-size: 25px;
    color: #f5f5f5;
    text-align: center;
    margin-bottom: 30px;
}
.form-group{
    border-bottom: 1px solid #fff;
    margin-top: 15px;
    margin-bottom: 20px;
    display: flex;
}
.form-group i{
    color: #fff;
    font-size: 14px;
    padding-top: 5px;
    padding-right: 10px;
}
.form-input{
    background: transparent;
    border: 0;
    outline: 0;
    color: #f5f5f5;
    flex-grow: 1;
}
.form-input::placeholder{
    color: white;
    opacity: 0.9;
}
input:focus::placeholder { 
	color:transparent; }
.form-submit{
    background: transparent;
    border: 1px solid #f5f5f5;
    color: #fff;
    width: 100%;
    text-transform: uppercase;
    padding: 6px 10px;
    transition: 0.25s ease-in-out;
    margin-top: 30px;
}
.form-submit:hover{
    border: 1px solid #54a0ff;
}
img {
  position: relative;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.img input{
    margin-left: 121px;
 
}z
</style>
<body>
	<div id="wrapper">
        <form method="post" id="form-login">
            <h1 class="form-heading">EDIT PROFILE</h1><br>  
            <br>
            <div class="img">
                <img src="../Asm-TaiNguyen/images/anh_the1.jpg" alt="" width="80px" height="100px">  
              <!-- <input type="file" >    -->             
            </div>
            <div class="form-group">
               <i class="fa fa-user" aria-hidden="true" style="margin-bottom: 3px;"></i>
                <input type="text" class="form-input" placeholder="User name">
            </div>             
            <div class="form-group">
                <i class="fa fa-envelope"></i>
                <input type="email" class="form-input" placeholder="Email">
            </div>
            <div class="form-group">
              <i class="fa fa-map-marker" aria-hidden="true"></i>
                <input type="text" class="form-input" placeholder="Address">
            </div>
             <div class="form-group">
                <i class="fa fa-phone-square"></i>
                <input type="text" class="form-input" placeholder="PHONE NUMBER">
                
            </div> 
             <div class="form-group">
			<input type="radio"  name="gender">  <a style="color:white;">Male</a>	&nbsp;
              <input type="radio"  name="gender">	<a style="color:white;">Female</a>
            </div>           
            <div class="form-group">
			<input type="submit" formaction="/index" value="back" class="form-submit">
            <input type="submit" formaction="/login" value="confirm" class="form-submit">
            </div>
        </form>
    </div>
</body>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript">
</script>
</html>