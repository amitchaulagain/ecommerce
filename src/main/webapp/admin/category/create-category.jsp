<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit New User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
  <h1>Add/Edit User Page</h1>
   <div class="container container-default">
   		<div class="well">
			<form action="/user" method="post">
				 <div class="form-group row">
	                <label for="id" class="col-2 col-form-label"> ID</label>
	                <div class="col-10">
		                <input type="text" class="form-control"
		                    name="id" value="<c:out value="${category.id}" />"
		                   placeholder="enter id" />
	                </div>
	            </div>
				<div class="form-group row">
					<label for="name" class="col-2 col-form-label">
						Name</label>
					<div class="col-10">
						<input class="form-control" type="text" name="name"
							value="<c:out value="${category.name}"/>" id="name"
							placeholder=" Name">
					</div>
				</div>
				<div class="form-group row">
					<label for="description" class="col-2 col-form-label">Description</label>
					<div class="col-10">
						<input class="form-control" type="text" name="description"
							value="<c:out value="${category.description}"/>" id="description"
							placeholder="Description ">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
