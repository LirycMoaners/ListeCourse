<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Liste Course" />
	<jsp:param name="page" value="/index.jsp" />
</jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Menu</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th></th>
										<th>Midi</th>
										<th>Soir</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Lundi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Mardi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Mercredi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Jeudi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Vendredi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Samedi</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
									<tr>
										<td>Dimanche</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
										<td>
											<button type="button" class="btn btn-success add">Ajouter</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Liste</h3>
					</div>
					<div class="panel-body liste">
						<div class="table-responsive table-liste">
							<table class="table">
								<thead>
									<tr>
										<th>Produit</th>
										<th>Quantité</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
									<tr>
										<td>Jambon</td>
										<td>5</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="text-center">
							<button type="button" class="btn btn-warning">Imprimer</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
	<h1 class="text-center">
		<button type="button" class="btn btn-danger">Retour</button>
	</h1>
</div>
<jsp:include page="/utils/footer.jsp" />