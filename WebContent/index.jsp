<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
					<div class="list-group-item clearfix">
						${result.creationDate}
						<div class="pull-right">
							<form method="POST" action="<%=request.getContextPath()%>/ConsultPlanningServlet">
								<button type="submit" class="btn btn-xs btn-primary" name="idPlanning" value="${result.id}">
									<span class="glyphicon glyphicon-pencil"></span>
								</button>
							</form>
							<form method="POST" action="<%=request.getContextPath()%>/DeletePlanningServlet">
								<button type="submit" class="btn btn-xs btn-danger" name="idPlanning" value="${result.id}">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<div class="col-md-4"></div>
<jsp:include page="/utils/footer.jsp" />