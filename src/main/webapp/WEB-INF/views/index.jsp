<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
	integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
	crossorigin="anonymous"></script>
<script>
	function doCheck() {
		var allFilled = true;

		var inputs = document.getElementsByTagName('input');
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text" && inputs[i].value == '') {
				allFilled = false;
				break;
			}
		}

		document.getElementById("submit").disabled = !allFilled;
	}

	window.onload = function() {
		var inputs = document.getElementsByTagName('input');
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].onkeyup = doCheck;
				inputs[i].onblur = doCheck;
			}
		}
	};
</script>
</head>
<body>
	<form action="saveDetails" method="post">
		<div>
			<div class="form-group">
				<label for="id">ENTER VERTICAL ID</label> <input type="text"
					class="form-control" name="verticalId" id="verticalId"
					value="${vertical.verticalId}" required="required">
			</div>

			<div class="form-group">
				<label for="name">VERTICAL NAME</label> <input type="text"
					class="form-control" name="verticalName" id="verticalName"
					value="${vertical.verticalName}" required="required">
			</div>
			<button type="submit" class="btn btn-danger btn-block" id="submit"
				disabled="disabled">SUBMIT</button>
			<br>
		</div>
	</form>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">VEHICLE ID</th>
				<th scope="col">VEHICLE NAME</th>
				<th scope="col">UPDATE</th>
				<th scope="col">DELETE</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<c:forEach var="a" items="${verticals}">
					<tr>
						<td>${a.verticalId}</td>
						<td>${a.verticalName}</td>


						<td><a href="/updatedetails?verticalId=${a.verticalId}">update</a></td>
						<td><a href="/delete?verticalId=${a.verticalId}">delete</a></td>
					</tr>
				</c:forEach>
			</tr>
		</tbody>



	</table>

</body>
<script>
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-z\s]+$/i.test(value);
	}, "Only alphanumerical characters");
	$('form').validate({
		rules : {
			verticalName : {
				required : true,
				lettersonly : true,
				maxlength : 7
			},
			verticalId : {
				required : true,
				digits : true,
				maxlength : 7

			}

		}

	});
</script>
</html>