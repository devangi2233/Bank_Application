<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Information Management</title>
    <script>
        function setAction(action) {
            document.getElementById("customerForm").action = "Customer?action=" + action;
            document.getElementById("customerForm").submit();
        }
    </script>
</head>
<body>
    <h1>Customer Information Management</h1>
    <form id="customerForm" method="post">
        <!-- Input fields for customer information -->
        <label>Name:</label>
        <input type="text" name="name" required><br>
        
        <label>Account Number:</label>
        <input type="text" name="accNo" required><br>
        
        <label>Date of Birth (YYYY-MM-DD):</label>
        <input type="text" name="dob" required><br>
        
        <label>Gender:</label>
        <input type="text" name="gender" required><br>
        
        <label>Address:</label>
        <input type="text" name="address" required><br>
        
        <label>Email:</label>
        <input type="email" name="email" required><br>
        
        <label>Phone Number:</label>
        <input type="text" name="phone" required><br>
        
        <label>Balance:</label>
        <input type="text" name="balance" required><br>
        
        <!-- Action buttons -->
        <input type="button" value="Add Customer" onclick="setAction('add')">
        <input type="button" value="Update Customer" onclick="setAction('update')">
        <input type="button" value="Delete Customer" onclick="setAction('delete')">
    </form>
</body>
</html>
