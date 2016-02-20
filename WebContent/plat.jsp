<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Liste Course" />
	<jsp:param name="page" value="/index.jsp" />
</jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-5">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Liste des plats</h3>
				</div>
				<div class="panel-body">
					<form method="post" action="<%=request.getContextPath()%>/AddListLinePlanningServlet">
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-success">
									<div class="panel-heading">
										<h3 class="panel-title">Plats</h3>
									</div>
									<div class="panel-body">
										<div class="list-group panel-meal">
											<c:forEach items="${listMeal}" var="meal">
												<a href="#${meal.id}" class="list-group-item clearfix" data-toggle="collapse">
													<input type="checkbox" name="meals" value="${meal}">
													${meal.name}
												</a>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="panel panel-warning">
									<div class="panel-heading">
										<h3 class="panel-title">Produits</h3>
									</div>
									<div class="panel-body">
										<div class="table-responsive panel-meal">
											<table class="table">
												<thead>
													<tr>
														<th>Produit</th>
														<th>Quantit�</th>
													</tr>
												</thead>
												<c:forEach items="${listMeal}" var="meal">
													<tbody id="${meal.id}" class="collapse">
														<c:forEach items="${meal.lineMeal}" var="lineMeal">
															<tr>
																<td>${lineMeal.product.name}</td>
																<td>${lineMeal.quantity}</td>
															</tr>
														</c:forEach>
													</tbody>
												</c:forEach>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<label for="nbPersonne">Nombre de personnes : </label>
							</div>
							<div class="col-md-2">
								<input type="number" class="form-control" id="nbPersonne" name="nbPersonne" value="1" min="1">
							</div>
							<div class="col-md-3">
								<button type="button" class="btn btn-success">Ajouter</button>
							</div>
							<div class="col-md-2"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-5">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Nouveau plat</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="name" class="col-sm-5 control-label">Nom</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="name"
									placeholder="Nom du plat">
							</div>
							<div class="col-sm-4"></div>
						</div>
						<h1 class="text-right">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#myModal">+ Produit</button>
						</h1>
						<div class="form-group table-responsive table-newMeal">
							<table class="table">
								<thead>
									<tr>
										<th>Produit</th>
										<th>Quantit�</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
									<tr>
										<td><select class="form-control">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td><input type="text" class="form-control"
											placeholder="Qt�"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<label for="nbPersonne">Nombre de personnes : </label>
							</div>
							<div class="col-md-2">
								<input type="number" class="form-control" id="nbPersonne" name="nbPersonne" value="1" min="1">
							</div>
							<div class="col-md-3">
								<button type="button" class="btn btn-success">Ajouter</button>
							</div>
							<div class="col-md-2"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<h1 class="text-center">
		<button type="button" class="btn btn-danger">Retour</button>
	</h1>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Nouveau produit</h4>
			</div>
			<div class="modal-body">
				<form class="form-inline">
					<div class="form-group col-sm-6">
						<label for="exampleInputName2">Nom</label> <input type="text"
							class="form-control" id="name" placeholder="Produit">
					</div>
					<div class="form-group col-sm-6">
						<label for="exampleInputEmail2">D�nombrable</label> <select
							class="form-control" id="comptable">
							<option>Oui</option>
							<option>Non</option>
						</select>
					</div>
					<div class="text-right">
						<button type="button" class="btn btn-success">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/utils/footer.jsp" />