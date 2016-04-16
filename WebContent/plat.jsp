<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Liste Course" />
	<jsp:param name="page" value="/index.jsp" />
</jsp:include>
<div class="container-fluid">
	<div class="row">
		<form method="post" action="<%=request.getContextPath()%>/AddLinePlanningServlet">
			<input type="hidden" name="idPlanning" value="${idPlanning}">
			<input type="hidden" name="day" value="${day}">
			<input type="hidden" name="moment" value="${moment}">
			<div class="col-md-1"></div>
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Liste des plats</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-success">
									<div class="panel-heading">
										<h3 class="panel-title">Plats</h3>
									</div>
									<div class="panel-body">
										<div class="list-group panel-meal">
											<c:forEach var="entry" items="${listMeal}">
												<div class="list-group-item clearfix checkbox">
													<label>
														<c:choose>
															<c:when test="${entry.value==0}">
																<input type="checkbox" name="meals" value="${entry.key.id}" data-target="#${entry.key.id}" data-parent="#meals" data-toggle="collapse">
															</c:when>
															<c:otherwise>
																<input type="checkbox" name="meals" value="${entry.key.id}" data-target="#${entry.key.id}" data-parent="#meals" data-toggle="collapse" checked>
															</c:otherwise>
														</c:choose>
														${entry.key.name}
													</label>
													<div class="pull-right" role="group">
														<button type="submit" class="btn btn-danger" name="Valider" value="${entry.key.id}">
															<span class="glyphicon glyphicon-trash"></span>
														</button>
													</div>
												</div>
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
											<table class="table" id="meals">
												<thead>
													<tr>
														<th>Produit</th>
														<th>Quantité</th>
													</tr>
												</thead>
												<c:forEach var="entry" items="${listMeal}">
													<c:choose>
														<c:when test="${entry.value==0}">
															<tbody id="${entry.key.id}" class="collapse out">
																<c:forEach items="${entry.key.lineMeal}" var="lineMeal">
																	<tr>
																		<td>${lineMeal.product.name}</td>
																		<td>${lineMeal.quantity}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</c:when>
														<c:otherwise>
															<tbody id="${entry.key.id}" class="collapse in">
																<c:forEach items="${entry.key.lineMeal}" var="lineMeal">
																	<tr>
																		<td>${lineMeal.product.name}</td>
																		<td>${lineMeal.quantity}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</c:otherwise>
													</c:choose>
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
								<c:choose>
    								<c:when test="${empty nbPersonne}">
										<input type="number" class="form-control" id="nbPersonne" name="nbPersonne" value="1" min="1">
									</c:when>
									<c:otherwise>
										<input type="number" class="form-control" id="nbPersonne" name="nbPersonne" value="${nbPersonne}" min="1">
									</c:otherwise>
								</c:choose>
							</div>
							<div class="col-md-3">
								<input type="submit" class="btn btn-success" name="Valider" value="Valider">
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Nouveau plat</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group">
								<div class="col-sm-4"></div>
								<label for="name" class="col-sm-1 control-label">Nom</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" name="name"
										placeholder="Nom du plat">
								</div>
								<div class="col-sm-4"></div>
							</div>
						</div>
						<div class="row">
							<div class="form-group table-responsive table-newMeal">
								<table class="table" id="tab_logic">
									<thead>
										<tr>
											<th>Produit</th>
											<th>Quantité</th>
										</tr>
									</thead>
									<tbody>
										<tr id='product0'>
											<td>
												<input type="text" class="form-control" list="produit" name="produit" placeholder="Produit"/>
												<datalist id='produit'>
													<c:forEach items="${listProduct}" var="product">
														<option>${product.name}</option>
													</c:forEach>
												</datalist>
											</td>
											<td>
												<input type="number" name='qte' class="form-control" placeholder='Qté' value="0" min="0">
											</td>
										</tr>
										<tr id='product1'></tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<a id="add_row" class="btn btn-default pull-left">+ Ajouter</a>
							<a id='delete_row' class="pull-right btn btn-default">- Supprimer</a>
						</div>
						<div class="row">
							<div class="text-center">
								<input type="submit" class="btn btn-success" name="Valider" value="Ajouter">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</form>
	</div>
	<form method="POST" action="<%=request.getContextPath()%>/GetLinePlanningListServlet">
		<h1 class="text-center">
			<input type="hidden" name="idPlanning" value="${idPlanning}"/>
			<input type="submit" class="btn btn-danger" value="Retour"/>
		</h1>
	</form>
</div>
<jsp:include page="/utils/footer.jsp" />