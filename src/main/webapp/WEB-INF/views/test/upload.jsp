<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title> 
</head>

<body>

<div align="center">
    <h2>upload例子</h2>
    <br>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"></br>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html> 