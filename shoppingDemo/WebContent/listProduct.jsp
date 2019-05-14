<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<c:if test="${!empty user}">
		<div class="container">Current User: ${user.name}</div>
	</c:if>


	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Price</th>
					<th scope="col">Category ID</th>
					<th scope="col">Model Year</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product" varStatus="st">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.categoryId}</td>
						<td>${product.modelYear}</td>

						<td>
							<form action="addItemOrd" method="post">
								Quantity : <input type="text" value="1" name="num"> <input
									type="hidden" name="pid" value="${product.id}">
							</form>
						</td>
						<td><button type="submit" class="btn btn-primary">Buy</button></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>