<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="edit-profile-header.jsp"%>
${message}
<div class="col-lg-6">
	<form:form id="profile" action="editProfile" method="POST"
		modelAttribute="jobSeeker">
		<div id="editProfile">
			<h6 class="heading-small text-muted mb-4">User information</h6>

			<div class="pl-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="first_name">First
								name </label> <input type="text" id="first_name" name="firstName"
								class="form-control" placeholder="First name" required="required"
								value="${jobseeker.firstName}">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="last_name">Last
								name</label> <input type="text" id="last_name" name="lastName"
								class="form-control" placeholder="Last name" required="required"
								value="${jobseeker.lastName}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="idCard">ID KTP/SIM </label> <input type="number" id="idCard" name="idCard"
								class="form-control" placeholder="ID Card" required="required"
								value="${jobseeker.idCard}">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="phoneNumber">No Handphone</label> <input type="number" id="phoneNumber" name="phoneNumber"
								class="form-control" placeholder="Phone Number" required="required"
								value="${jobseeker.phoneNumber}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="placeBirth"> Tempat Lahir </label> <input type="text" id="placeBirth" name="placeBirth"
								class="form-control" placeholder="placeBirth" required="required"
								value="${jobseeker.placeBirth}">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="dateBirth">Tanggal Lahir</label> <input type="date" id="dateBirth" class="form-control" required="required"
								name="dateBirth" placeholder="Tanggal Lahir" value="${jobSeeker.dateBirth}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="email">Email
								address</label> <input type="email" id="email" name="email"
								class="form-control" placeholder="shubham@example.com" required="required"
								value="${jobseeker.users.email}">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="religion">Email
								address</label> <input type="religion" id="religion" name="religion"
								class="form-control" placeholder="Input Religion" required="required"
								value="${jobseeker.religion}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<input type="submit" id="submit_profile"
								name="submit_profile" class="form-control btn-outline-primary"
								value="Update">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>
</div>

</div>
</section>
<%@ include file="footer.jsp"%>