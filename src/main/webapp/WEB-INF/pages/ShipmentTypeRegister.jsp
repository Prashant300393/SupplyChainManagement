<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 9px;
  border: 1px solid #ccc;
  border-radius: 2px;
  box-sizing: border-box;
  margin-top: 3px;
  margin-bottom: 10px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  width : 30%;
  border-radius: 5px;
  background-color: #d5f4e6;
  padding: 10px;
  margin: 30px;
}

.blinking{
    animation:blinkingText 1.5s infinite;
   }
@keyframes blinkingText{
	0%{     color: red;    }
    49%{    color: red; }
    60%{    color: transparent; }
    99%{    color:transparent;  }
    100%{   color: red;    }
}
</style>
</head>

<body> 
<span class="blinking"; style="font-weight: bold; text-align:center;  font-size: 25px; padding: 20%; margin: 7%">
---WELCOME TO SHIPMENT TYPE REGISTER PAGE---
</span><br><br>
<div class="container">
<form action="save" method="post">

 <label>Shipment Mode</label>
<select name="shipMode" required="required">
	<option>---select---</option>
	<option>Air</option>
	<option>Truck</option>
	<option>Ship</option>
	<option>Train</option>
</select>

<label>Shipment Code</label>
<input type="text" name="shipCode" required="required">

<label>Enable Shipment</label>
<select name="enbShip" required="required">
	<option>---select---</option>
	<option>YES</option>
	<option>NO</option>
</select>

<label>Shipment Grade</label><br>
	<input type="radio" name="shipGrade" value="A" >A<br>
	<input type="radio" name="shipGrade" value="B">B<br>
	<input type="radio" name="shipGrade" value="C">C<br>
<br>	
<label>Description</label>
    <textarea name="subject" placeholder="Write something.." style="height:200px"></textarea>
    
    <input type="submit" value="Create Shipment">
</form>
</div>
${msg}
</body>
</html>