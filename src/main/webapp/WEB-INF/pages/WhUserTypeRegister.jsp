<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
    function EnableDisableTextBox(card) {
        var selectedValue = card.options[card.selectedIndex].value;
        var txtOther = document.getElementById("txtOther");
        txtOther.disabled = selectedValue == "Other" ? false : true;
        if (!txtOther.disabled) {
            txtOther.focus();
        }
    }

    function setText(target) {
    	var txt = document.getElementById(target);
    	var temp = txt.value;
    	var tf = document.getElementById("textField");
		if(temp=="Vendor")
			{
			tf.value = "Sale";
			}
		else
			{
			tf.value = "Purchase";
			}
    	}	
</script>
</head>
<body align="center">

<form action="save" method="post">
<b>User Type 	: <input id="radio1" type="radio" name="userType" value="Vendor" onClick="setText('radio1');" />Vendor
<input id="radio2" type="radio" name="userType" value="Customer" onClick="setText('radio2');" />Customer<br/>

<b>User Code : 
<input type="text" name="userCode" required="required" ></b><br><br>
<b>User For 	: 
<input id="textField" type="text" name="userFor" value="Choose One" ></b><br><br>
<b>User Email: 
<input type="text" name="userMail" required="required"></b><br><br>
<b>User Contact	: 
<input type="text" name="userContact" required="required"></b><br><br>
<b>User ID Type :
<select name="userIdType"  id = "card" onchange = "EnableDisableTextBox(this)" required="required">
    <option selected disabled hidden ></option>
    <option >Pan Card</option>
    <option >Aadhar Card</option>
    <option >Voter ID</option>
    <option value = "Other">Other</option>
</select> </b>
<br><br>
Other: <input name="other"  type="text" id="txtOther" disabled="disabled"  required="required" /><br><br>	
<b>ID Number: </b>
<input type="text" name="idNumber" required="required"><br><br>
<pre>	
	<input type="submit" value="Create User"> 
</pre>
				
</form>
${msg }
</body>
</html>