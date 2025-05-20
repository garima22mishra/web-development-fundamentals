<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Coupon</title>
</head>
<body>
<h1>Create Coupon</h1>

<form action="coupons" method="post">

<pre>
	Code: <input type="text" name="code"/>
	Discount: <input type="text" name="discount"/>
	Expiry Date: <input type="text" name="expiryDate"/>
	<input type="hidden" value="action" name="create"/>
	<input type="submit" value="create" />
</pre>
</form>
</body>
</html>