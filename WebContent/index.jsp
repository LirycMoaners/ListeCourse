<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="/utils/header.jsp">
	<jsp:param name="title" value="Liste Course" />
	<jsp:param name="page" value="/index.jsp" />
</jsp:include>

<div class="col-md-4"></div>
<div class="col-md-4">
	<form method="POST" action="<%=request.getContextPath()%>/AddPlanningServlet" class="text-right">
		<button type="submit" class="btn btn-success">+ Ajouter</button>
	</form>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Liste de course</h3>
		</div>
		<div class="panel-body">
			<div class="list-group listCourse-panel">
				<c:forEach items="${listPlanning}" var="result">
					<a href="#" class="list-group-item clearfix">
						${result.creationDate}
						<span class="pull-right button-group">
							<button class="btn btn-xs btn-danger">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</span>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<div class="col-md-4"></div>
<jsp:include page="/utils/footer.jsp" />