<%@include file="edit-profile-header.jsp"%>
${message}
<div class="col-lg-4">
	<form:form id="profile" action="addFamily" method="POST"
		modelAttribute="family">
		<div id="famili">
			<h6 class="heading-small text-muted mb-4">Family</h6>
			<div class="pl-lg-4">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-city">Status Hubungan</label>
							<input type="text" id="input-city" name="statusHub" required="required"
								class="form-control" placeholder="Input Nama Ibu or Istri/Suami"
								value="">
						</div>
                        <div class="form-group">
							<label class="form-control-label" for="input-city">Nama Lengkap</label>
							<input type="text" id="input-city" name="nameFam" required="required"
								class="form-control" placeholder="Input Nama Lengkap Ybs.."
								value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">ID Card</label>
							<input type="number" id="input-country" name="idCard"  required="required"
								class="form-control" placeholder="Input ID KTP/SIM/PASSPORT" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Pekerjaan</label>
							<input type="text" id="input-country" name="profesi"  required="required"
								class="form-control" placeholder="Input Data Pekerjaan" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Nama Perusahaan</label>
							<input type="text" id="input-country" name="companyName"  required="required"
								class="form-control" placeholder="Input Nama Perusahaan" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Pendidikan Terakhir</label>
							<input type="text" id="input-country" name="lastEdu"  required="required"
								class="form-control" placeholder="Input Pendidikan Terakhir" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">No Handphone</label>
							<input type="number" id="input-country" name="telp"  required="required"
								class="form-control" placeholder="Input Nomor Handphone" value="">
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Keterangan Status</label>
							<input type="text" id="input-country" name="remark"  required="required"
								class="form-control" placeholder="Hidup / Meninggal" value="">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
							<label class="form-control-label" for="input-country">Alamat Lengkap
							</label>
							<textarea class="form-control" name="address" rows="5" cols="80" required="required"
							placeholder="Input alamat lengkap"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="form-group">
							<input type="submit" id="submit_family"
								name="submit_family"
								class="form-control btn-outline-primary"
								value="Add Family">
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
				<th>Status Hub</th>
				<th>Name</th>
				<th>Id Card</th>
				<th>No HP</th>
				<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="tempfamily" items="${familyList}">
				<c:url var="deleteLink" value="deleteFamily">
					<c:param name="familyId" value="${count}" />
				</c:url>
				<tr>
					<td>${tempfamily.statusHub}</td>
					<td>${tempfamily.nameFam}</td>
					<td>${tempfamily.idCard}</td>
					<td>${tempfamily.telp}</td>

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
