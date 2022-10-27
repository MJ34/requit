<%@include file="edit-profile-header.jsp"%>
${message}
<div class="col-lg-4">
	<form:form id="profile" action="addWorkExp" method="POST"
		modelAttribute="workExp">
		<div id="wExperience">
			<h6 class="heading-small text-muted mb-4">Work Experience</h6>
			<div class="pl-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-name">Organization Name</label>
							<input type="text" id="input-name" name="name" required="required"
								class="form-control" placeholder="Input Nama Organisasi"
								value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-position">Position</label>
							<input type="text" id="input-country" name="position"  required="required"
								class="form-control" placeholder="Input Posisi yang diampu" value="">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-city">Date In</label> <input type="date" id="input-city" class="form-control" required="required"
								placeholder="" name="dateIn" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">date Out</label> <input type="date" id="input-country" class="form-control" required="required"
								name="dateOut" placeholder="" value="">
						</div>
					</div>
				</div>
                <div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-name">Referensi Atasan</label>
							<input type="text" id="input-name" name="referenceName" required="required"
								class="form-control" placeholder="Input Nama Referensi"
								value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-position">Phone Number</label>
							<input type="number" id="input-country" name="phoneNumber"  required="required"
								class="form-control" placeholder="Input Nomor Handphone" value="">
						</div>
					</div>
				</div>
                <div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-name">Salary</label>
							<input type="number" id="input-name" name="salary" required="required"
								class="form-control" placeholder="Input Nominal Salary"
								value="">
						</div>
					</div>
                    </div>
                <div class="row">
                <div class="col-lg-8">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Deskription
							</label>
							<textarea class="form-control" name="remark" rows="8" cols="80" required="required"
							placeholder="Input Deskripsi yang kamu lakukan di organisasi tersebut"></textarea>
						</div>
					</div>
                </div>
				<div class="row">
					<div class="col-lg-12">
						<div class="form-group">
							<input type="submit" id="submit_workExp"
								name="submit_workExp"
								class="form-control btn-outline-primary"
								value="Add Work Experience">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>
<span
	style="display: inline-block; border-left: 1px solid #ccc; margin: 0 -7px; height: 400px;"></span>

<div class="col-lg-6">
	<table class="table table-striped">
		<c:set var="count" value="0" scope="page" />
		<thead>
			<tr>
				<th>Name Company</th>
                <th>Position</th>
				<th>Date IN</th>
				<th>Date Out</th>
				<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="tempWorkExp" items="${workExperienceList}">
				<c:url var="deleteLink" value="deleteWorkExp">
					<c:param name="workExpId" value="${count}" />
				</c:url>
				<tr>
					<td>${tempWorkExp.name}</td>
					<td>${tempWorkExp.position}</td>
					<td>${tempWorkExp.dateIn}</td>
                    <td>${tempWorkExp.dateOut}</td>

					<td><a href="${deleteLink }" class="btn btn-danger">Delete</a></td>

				</tr>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
</div>
</div>
</section>
<div class="vertical-space-50"></div>
<%@include file="footer.jsp"%>
