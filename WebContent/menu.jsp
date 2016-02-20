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
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['LundiMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Lundi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['LundiMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['LundiMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['LundiMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['LundiSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Lundi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['LundiSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['LundiSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['LundiSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Mardi</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['MardiMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Mardi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['MardiMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['MardiMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['MardiMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['MardiSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Mardi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['MardiSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['MardiSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['MardiSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Mercredi</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['MercrediMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Mercredi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['MercrediMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['MercrediMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['MercrediMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['MercrediSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Mercredi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['MercrediSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['MercrediSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['MercrediSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Jeudi</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['JeudiMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Jeudi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['JeudiMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['JeudiMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['JeudiMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['JeudiSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Jeudi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['JeudiSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['JeudiSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['JeudiSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Vendredi</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['VendrediMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Vendredi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['VendrediMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['VendrediMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['VendrediMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['VendrediSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Vendredi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['VendrediSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['VendrediSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['VendrediSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Samedi</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['SamediMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Samedi"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['SamediMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['LundiMSamediMidiidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['SamediMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['SamediSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Samedi"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['SamediSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['SamediSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['SamediSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
									</tr>
									<tr>
										<td>Dimanche</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['DimancheMidi']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Dimanche"/>
														<input type="hidden" name="moment" value="Midi"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['DimancheMidi']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['DimancheMidi']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['DimancheMidi'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
										</td>
										<td>
											<form method="POST" action="<%=request.getContextPath()%>/GetListMealServlet">
												<c:choose>
													<c:when test="${empty menu['DimancheSoir']}">
														<input type="hidden" name="idPlanning" value="${idPlanning}"/>
														<input type="hidden" name="day" value="Dimanche"/>
														<input type="hidden" name="moment" value="Soir"/>
														<input type="submit" class="btn btn-success add" value="Ajouter"/>
													</c:when>
													<c:otherwise>
														<input type="hidden" name="listLinePlanning" value="${menu['DimancheSoir']}"/>
														<button type="submit" class="btn btn-primary add">
															<c:forEach items="${menu['DimancheSoir']}" var="linePlanning">
																${linePlanning.meal.name}<br/>
															</c:forEach>
															Qty : ${menu['DimancheSoir'][0].nbPersonne}
														</button>
													</c:otherwise>
												</c:choose>
											</form>
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
									<c:forEach items="${listProduct}" var="product">
										<tr>
											<td>${product['name']}</td>
											<td>${product['qty']=='0'?'':product['qty']}</td>
										</tr>
									</c:forEach>
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
	<form method="POST" action="<%=request.getContextPath()%>">
		<h1 class="text-center">
			<input type="submit" class="btn btn-danger" value="Retour"/>
		</h1>
	</form>
</div>
<jsp:include page="/utils/footer.jsp" />