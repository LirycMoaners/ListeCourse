$(document).ready(function(){
	var i = 1;
	
	$("#add_row").click(function() {
		$('#product' + i).html(
			"<td>"
			+ "<select class='form-control' name='produit'>"
			+ "<option value='' disabled selected>Produit</option>"
			+ "<c:forEach items='${listProduct}' var='product'>"
			+ "<option>${product.name}</option>"
			+ "</c:forEach>"
			+ "</select>"
			+ "</td>"
			+ "<td>"
			+ "<input type='number' name='Qté' class='form-control' placeholder='Qté'>"
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