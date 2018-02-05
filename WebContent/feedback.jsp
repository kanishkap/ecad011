<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.DBMan" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.mycomp
{
width:100%;
margin-top:10px;
margin-bottom:20px;
color:white;
font-family:"Georgia";
font-size:20px;
padding:10px;
border:1px solid black;
background:black;
border-radius:10px;
}

.mycomp:hover
{
color:white;
border:1px solid black;
background:black;
border-radius:10px;
}

.mybtn{
background: black;
margin: 0 auto;
font-weight: bold;
margin-top: 10px;
margin-bottom: 20px;
color: white;
font-family: 'Georgia';
font-size: 20px;
padding: 10px;
border: 1px solid white;
border-radius: 20px;
transition:2s ease-in-out
}
</style>
</head>
<body>
<form action="FeedbackServlet" method="post">
<div style="width:400px;margin:0 auto">

<input type="text" name="roll" id="roll" class="mycomp" placeholder="enter roll number">
<br>
<input type="text" name="stuname" id="stuname" class="mycomp" placeholder="enter name">
<br>

<select name="branch" id="branch" class="mycomp">
<option>CBA</option>
<option>BDA</option>
<option>MA</option>
</select>
<br>

<select name="cat" id="cat" class="mycomp">
<option>Suggestion</option>
<option>Complaint</option>
<option>Reviews</option>
<option>Registration</option>
<option>Examination</option>
<option>Others</option>
</select>
<br>

<textarea name="message" id="message" class="mycomp" ></textarea>
<br>

<input type="submit" n class="mybtn" value="Submit Feedback">
<br>


</div>

</form>

<%-- <script>
<%
String msg=request.getParameter("msg");

try
{
	if(msg.equals("insertion successfull"))
	{
		out.println("alert(record inserted successfully)");
	}
	else if(msg.equals("insertion failed"))
	{
		out.println("alert(record not inserted successfully)");
	}
}
catch(Exception e)
{
	
}

</script>
%>


 --%>
		
<%
try
{
	String msg=request.getParameter("msg");
	
	if(msg==null)
	{%>
		
	
		<%}
		
	
	else if(msg.equals("failed"))
	{%>
		<p> try again!!</p>
	<%
	}
	else if(msg.equals("insert successfully"))
	{
		
	String sql="SELECT * FROM feedback";
			ResultSet rs=DBMan.select(sql);%>
			<table border="2">
			<th>ID</th>
			<th>ROLL</th>
			<th>NAME</th>
			<th>BRANCH</th>
			<th>CATEGORY</th>
			<th>MESSAGE</th>
<%
			while(rs.next())
			{%>
			
			<tr>
			
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			</tr>
				
				
				
			<%
			}
	}
	

}
catch(SQLException e)
{
e.printStackTrace();
}



%>



</body>
</html>