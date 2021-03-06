<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header text-center bg-primary text-white">
				<h3>WELCOME TO WH USER TYPE REGISTER PAGE</h3>
				<br>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="whUserType">
				<div class="row">
					<div class="col-4">
						<label for="userType">User Type</label>
					</div>
				  		<div class="col-4">
				  		<form:radiobutton  path="userType"	value="Vendor" />Vendor
	    				<form:radiobutton path="userType" value="Customer" />Customer<br>
				  		</div>
				  		<div class="col-4">
				  			<span id="userTypeError"></span>
				  		</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">
						<label for="userCode">User Code </label>
					</div>
					<div class="col-4">
						<form:input path="userCode" class="form-control"/>
					</div>
					<div class="col-4">
				  		<span id="userCodeError"></span>
				  	</div>
				  </div>
				<br>
				<div class="row">
					<div class="col-4">
						<label for="userFor">User For </label>					
					</div>
					 <div class="col-4">
					 	<form:input path="userFor" readonly="true"  class="form-control"/>
					 </div>						
					<div class="col-4">
				  		<span id="userForError"></span>
				  	</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">
						<label for="userMail">User Email </label>
					</div>				
					<div class="col-4">
						<form:input path="userMail" class="form-control"/>
					</div>
					<div class="col-4">
				  		<span id="userMailError"></span>
				  		<form:errors path="userMail" cssClass="text-danger"/>
				  	</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4">
						<label for="userContact">User Contact</label>
					</div>
				<div class="col-4">
					<form:input path="userContact" class="form-control"/>
				</div>	
					<div class="col-4">
				  		<span id="userContactError"></span>
				  		<form:errors path="userContact"  cssClass="text-danger"/>
				  	</div>
				</div>	
				<br>
				<div class="row">
					<div class="col-4">
						<label for="userIdType">User ID Type</label>
					</div>
						<div class="col-4">
						 <form:select path="userIdType" class="form-control">
						<form:option value="">--SELECT--</form:option>
						<form:option value="PANCARD">PANCARD</form:option>
						<form:option value="AADHAR CARD">AADHAR CARD</form:option>
						<form:option value="VOTER ID">VOTER ID</form:option>
						<form:option value="OTHER">OTHER</form:option>
					</form:select>
					</div>
					<div class="col-4">
				  		<span id="userIdTypeError"></span>
				  	</div>
				</div>				
				<br>
				<div class="row">
					<div class="col-4">
					</div>
					<div class="col-4">
								<label id="ifOther" for="ifOther">Enter Other UserID Type</label>
						 <form:input path="other" class="form-control"/>
					</div>	
					<div class="col-4">
						<br>
						<span id="otherError"></span>
				  	</div>
				</div>		
				<br>
				<div class="row">
					<div class="col-4"> 
						<label for="idNumber">ID Number</label>						
					</div>
					<div class="col-4">
						 <form:input path="idNumber" class="form-control"/>
					</div>					
					<div class="col-4">
				  		<span id="idNumberError"></span>
				  	</div>
				</div>
				<br>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-4"><input id="register" type="submit" value="Create User" class="btn btn-success btn-center"></div>
				</div>
				</form:form>
				</div>
				<div class="card-footer bg-info text-white text-center">
					<b>${msg }</b>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){

		// 1.  Hide ERROR section
		$('#userTypeError').hide();
		$('#userCodeError').hide();
		$('#userForError').hide();
		$('#userMailError').hide();
		$('#userContactError').hide();
		$('#userIdTypeError').hide();
		$('#otherError').hide();
		$('#idNumberError').hide();
		$("#ifOther").hide();
		$('#other').hide();

		// 2. Define ERROR variable
		var userTypeError = false;
		var userCodeError = false;
		var userForError = false;
		var userMailError = false;
		var userContactError = false;
		var userIdTypeError = false;
		var otherError = false;
		var idNumberError = false;

		// 3. define validate function for input
		
		// USER TYPE RADIOBUTTON
		function validate_userType(){

			var val = $('input[type="radio"][name="userType"]:checked').val();
				if(val=='Vendor'){
					$('#userTypeError').hide();
					$('#userFor').val('Purchase');
					$('#userFor').css('color', 'blue');
					$('#userForError').hide();
					userForError = true;
					userTypeError = true;
					}
				else if(val=='Customer'){
					$('#userTypeError').hide();
					$('#userFor').val('Sale');
					$('#userFor').css('color', 'blue');
					$('#userForError').hide();
					userForError = true;
					userTypeError = true;	
					}
				else{
					$('#userTypeError').show();
					$('#userTypeError').html('<b>*Please Select One User Type</b>');
					$('#userTypeError').css('color', 'red');
					userTypeError = false;
					}
				return userTypeError;
			}
		
		// USERCODE
		function validate_userCode(){
				var val = $('#userCode').val();
				var exp = /^[A-Z]{2,8}$/;
				if(val==''){
					$('#userCodeError').show();
					$('#userCodeError').html("<b>*Please Enter User Code </b>");
					$('#userCodeError').css("color", "red");
					userCodeError = false;
					}
				else if(!exp.test(val)){
					$('#userCodeError').show();
					$('#userCodeError').html("<b>*Please Enter between 2-8 UpperCase Letters </b>");
					$('#userCodeError').css("color", "red");
					userCodeError = false;
					}
				else{
					$('#userCodeError').hide();
					userCodeError = true;
					}
				return userCodeError;
			}		

		// USER FOR
		function validate_userFor(){
			var val = $('#userFor').val();
			if(val==''){
				$('#userForError').show();
				$('#userForError').html('<b>*Please Choose one "UserType" Above for "User For"</b>');
				$('#userForError').css("color", "red");
				userForError = false;
				}
			else{
				$('#userForError').hide();
				userForError = true;
				}
			return userForError;
			}
		
		// USEREMAIL
		function validate_userMail(){

			var val = $('#userMail').val();
			var exp = /^[A-Za-z0-9\_\-\.]+\@[a-zA-Z]{2,8}\.[a-zA-Z]{2,3}(.in)?$/;
			if(val==''){
				$('#userMailError').show();
				$('#userMailError').html('<b>*Please Enter Your Email </b>');
				$('#userMailError').css("color", "red");
				userMailError = false;
				}
			else if(!exp.test(val)){
				$('#userMailError').show();
				$('#userMailError').html('<b>*Please Enter Valid Email </b>');
				$('#userMailError').css("color", "red");
				userMailError = false;
				}
			else{
				$('#userMailError').hide();
				userMailError = true;
				}
			return userMailError;				
			}
		
		// USER CONTACT
		function validate_userContact(){

			var val = $('#userContact').val();
			var exp = /^(\+)?(91)?[6-9][0-9]{9}$/;
			if(val==''){
				$('#userContactError').show();
				$('#userContactError').html('*<b>Please Enter Your Contact</b>');
				$('#userContactError').css("color", "red");
				userContactError = false;
				}
			else if(!exp.test(val)){
				$('#userContactError').show();
				$('#userContactError').html('*<b>Please Enter VALID Contact</b>');
				$('#userContactError').css("color", "red");
				userContactError = false;
				}
			else{
				$('#userContactError').hide();
				userContactError = true;
				}
			return userContactError;
			}

		// USERID TYPE
		function validate_userIdType(){
			var val = $('#userIdType').val();
			if(val==''){
				$('#userIdTypeError').show();
				$('#userIdTypeError').html('<b>*Please Select UserId Type</b>');
				$('#userIdTypeError').css("color", "red");
				userIdTypeError = false;
				}
			else if(val=="OTHER"){
				$("#ifOther").show();
				$('#other').show();
				userIdTypeError = true;
			}
			else{
				$('#userIdTypeError').hide();
				$('#other').hide();
				$("#ifOther").hide();
				$('#otherError').hide();
				userIdTypeError  = true;
				}
				return userIdTypeError;
			}

			function validate_other(){
				
					var val = $('#other').val();
					if(val==''){
						$('#otherError').show();
						$('#otherError').html('<b>*Please Enter User ID </b>');
						$('#otherError').css('color', 'red');
						otherError = false;
						}
					else{
						$('#otherError').hide();
						$('#otherError').html('');
						$('#otherError').val('');
						otherError = true;
						}
					return otherError;
				}
		
		// ID NUMBR
		function validate_idNumber()	{

			var val = $('#idNumber').val();
			var exp = /^[A-Za-z0-9\_\-\.]{4,19}$/;
			if(val==''){
				$('#idNumberError').show();
				$('#idNumberError').html('<b>*Please Enter ID Number </b>');
				$('#idNumberError').css("color", "red");
				idNumberError = false;
				}
			else if(!exp.test(val)){
				$('#idNumberError').show();
				$('#idNumberError').html('<b>*Please Enter VALID ID Number </b>');
				$('#idNumberError').css("color", "red");
				idNumberError = false;
				}
			else{
				$('#idNumberError').hide();
				idNumberError = true;
				}			
				return idNumberError;
			}
		
		
		// 4. Link above Function with Action Events
		$('input[type="radio"][name="userType"]').change(function(){
			validate_userType();
			});
		
		$('#userCode').keyup(function(){
			validate_userCode();
			});

		$('#userFor').change(function(){
			validate_userFor();
			});

		$('#userMail').keyup(function(){
			validate_userMail();
			});

		$('#userContact').keyup(function(){
			validate_userContact();
			});

		$('#userIdType').change(function(){
			validate_userIdType();
			});
	
		
		$('#idNumber').keyup(function(){
			validate_idNumber();
			});

		$('#other').keyup(function(){
			validate_other();
			});

		$("#userCode").blur(function(){
			validate_userCode_ajax();
		});

		// On Click SUBMIT button
		$('#register').click(function(){

			userTypeError = false;
			userCodeError = false;
			userForError = false;
			userMailError = false;
			userContactError = false;
			userIdTypeError = false;
			idNumberError = false;

			validate_userType();
			validate_userCode();
			validate_userFor();
			validate_userMail();
			validate_userContact();
			validate_userIdType();
			validate_idNumber();
					
			if(userTypeError && userCodeError && userForError && userMailError && userContactError && userIdTypeError && idNumberError )	
			{
				return true;
			}
			else
			{
				return false;
			}

		});

		// JQuery AJAX function call
		function validate_userCode_ajax(){
		     var val = $("#userCode").val();
		     $.ajax({
		     	url : 'codeExist',
		     	data : { "userCode": $("#userCode").val()},
		     	success : function(resTxt){
		          if(resTxt!=''){
			          	 $("#userCodeError").show();
		     	         $("#userCodeError").html(resTxt);
		     	         $("#userCodeError").css("color","red");
		     	         $("#userCode").focus();//place cursor back
		          }else{
		          	$("#userCodeError").hide();
		          	$("#userCodeError").html("");
		          }
		     	}
		     });
		  }
		
});
</script>
</body>
</html>
