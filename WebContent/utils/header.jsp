<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Course</title>
<link rel="stylesheet"
	href="/ListeCourse/ext/bootstrap/3.2.2/css/bootstrap.css">
<link rel="stylesheet" href="/ListeCourse/style/style.css">
<script src="/ListeCourse/ext/jquery/1.11.2/jquery-1.11.2.js"></script>
<script src="/ListeCourse/ext/bootstrap/3.2.2/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		var i = 1;
		
		$("#add_row").click(function() {
			$('#product' + i).html(
				"<td>"
				+ "<input type='text' class='form-control' list='produit' name='produit'/>"
				+ "<datalist id='produit'>"
				+ "<option value='' disabled selected>Produit</option>"
				+ "<c:forEach items='${listProduct}' var='product'>"
				+ "<option>${product.name}</option>"
				+ "</c:forEach>"
				+ "</datalist>"
				+ "</td>"
				+ "<td>"
				+ "<input type='number' name='qte' class='form-control' placeholder='Qté' min='0' value='0'>"
				+ "</td>");
			$('#tab_logic').append('<tr id="product' + (i + 1) + '"></tr>');
			i++;
		});
		
		$("#delete_row").click(function() {
			if (i > 1) {
				$("#product" + (i - 1)).html('');
				i--;
			}
		});
	});
</script>
</head>
<body>
	<div class="page-header">
		<h1 class="text-center">
			<span class="label label-default">Liste des Courses</span>
		</h1>
	</div>

	<!-- container, body and HTML tags are still opened -->