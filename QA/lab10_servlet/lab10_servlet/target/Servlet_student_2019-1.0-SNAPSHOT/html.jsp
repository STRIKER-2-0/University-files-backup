<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
<form  method="get" action="calculate?a=${a}&operator=${operator}&b=${b}">
    Number a: <input type="number" name="a" value="${a}" step="0.00001" />
    <br><br>
    Operator: <input type="text" name="operator" value="${operator}"  />
    <br><br>
    Number b: <input type="number" name="b" value="${b}" step="0.00001" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
