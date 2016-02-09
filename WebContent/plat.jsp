<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-success">
								<div class="panel-heading">
									<h3 class="panel-title">Plats</h3>
								</div>
								<div class="panel-body">
									<div class="list-group">
										<a href="#" class="list-group-item">Pattes carbonara</a> <a
											href="#" class="list-group-item">Purée Jambon</a> <a href="#"
											class="list-group-item">Hamburger frites</a> <a href="#"
											class="list-group-item">Riz poisson</a>
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
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>Produit</th>
													<th>Quantité</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>gshshdhd</td>
													<td>5</td>
												</tr>
												<tr>
													<td>ghdhd</td>
													<td></td>
												</tr>
												<tr>
													<td>gshshdhd</td>
													<td>5</td>
												</tr>
												<tr>
													<td>ghdhd</td>
													<td></td>
												</tr>
												<tr>
													<td>gshshdhd</td>
													<td>5</td>
												</tr>
												<tr>
													<td>ghdhd</td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<h1 class="text-center">
						<button type="button" class="btn btn-success">Ajouter</button>
					</h1>

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
						<div class="form-group table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Produit</th>
										<th>Quantité</th>
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
											placeholder="Qté"></td>
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
											placeholder="Qté"></td>
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
											placeholder="Qté"></td>
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
											placeholder="Qté"></td>
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
											placeholder="Qté"></td>
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
											placeholder="Qté"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<h1 class="text-center">
							<button type="submit" class="btn btn-success">Ajouter</button>
						</h1>
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
					<div class="form-group">
						<label for="exampleInputName2">Nom</label> <input type="text"
							class="form-control" id="name" placeholder="Produit">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail2">Dénombrable</label> <select
							class="form-control" id="comptable">
							<option>Oui</option>
							<option>Non</option>
						</select>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
				<button type="submit" class="btn btn-success">Ajouter</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/utils/footer.jsp" />