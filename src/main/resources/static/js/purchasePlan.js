function purchasePlan() {
	var mealid = document.getElementById('mealid').value;
	var cabinid = document.getElementById('cabinid').value;
	var speRequestid = document.getElementById('speRequestid').value;
	var flDetailid = document.getElementById('flDetailid').value;
	var planid = document.getElementById('planid').value;
	var planidarr = [];
	$("input:checkbox[id=planid]:checked").each(function() {
		planidarr.push($(this).val());
	});
	var custEmail = $("#custEmail").val();
	var cfname = document.getElementById('cfname').value;
	var cmname = document.getElementById('cmname').value;
	var clname = document.getElementById('clname').value;
	var cardnum = document.getElementById('cardnum').value;
	var cardtype = document.getElementById('cardtype').value;
	var cardExpiry = document.getElementById('cardExpiry').value;

	var planPurchaseData = {
		custEmail : custEmail,
		mealid : mealid,
		cabinid : cabinid,
		speRequestid : speRequestid,
		flDetailid : flDetailid,
		planid : planidarr,
		cfname : cfname,
		cmname : cmname,
		clname : clname,
		cardnum : cardnum,
		cardtype : cardtype,
		cardExpiry : cardExpiry
	};

	if (cabinid == 0) {
		alert('Please select Cabin');
		return true;
	}

	if (flDetailid == 0) {
		alert('Please select flight details');
		return true;
	}

	if (Object.values(planidarr).length == 0) {
		alert('Please select Insurance Plan');
		return true;
	}

	if (cfname == '') {
		alert('Please input First Name');
		return true;
	}

	if (clname == '') {
		alert('Please input Last Name');
		return true;
	}

	if (cardnum == '') {
		alert('Please input Card Number');
		return true;
	}

	if (cardtype == '') {
		alert('Please select Card Type');
		return true;
	}

	if (cardExpiry == '') {
		alert('Please input Card Expiry Date');
		return true;
	}

	$.ajax({
		url : '/safe/v1/createTransaction',
		type : 'POST',
		data : JSON.stringify(planPurchaseData),
		contentType : 'application/json; charset=utf-8',
		beforeSend : function(xhr) {
			$("#loaderDiv").show();
		},
		dataType : 'json',
		success : function(data) {
			alert(data.statusMessage);
			location.reload();
		},
		statusCode : {
			200 : function() {
				$("#loaderDiv").hide();
			}
		}
	}).fail(function(xhr, result, status) {
		$("#loaderDiv").hide();
		alert('Plan Purchase Transaction' + ' ' + xhr.responseText);
	});
}

$(document)
		.ready(
				function() {

					var gender = {
						"M" : "Male",
						"F" : "Female"
					};

					var columnDefs = [ {
						data : 'custId',
						title : 'custId',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'pId',
						title : 'pId',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'fname',
						title : 'First Name'
					}, {
						data : 'lname',
						title : 'Last Name'
					}, {
						data : 'dob',
						title : 'DOB',
						type : 'date'
					}, {
						data : 'gender',
						title : 'Gender',
						type : 'select',
						options : gender,
						render : function(data, type, row, meta) {
							if (data == null || !(data in gender))
								return null;
							return gender[data];

						}
					}, {
						data : 'nationality',
						title : 'Nationality'
					}, {
						data : 'passportNo',
						title : 'Passport Number'
					}, {
						data : 'passExpiry',
						title : 'Passport Expiry Date',
						type : 'date'
					} ];

					var myTable;

					myTable = $('#purchasePlanTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										scrollX : 1000,
										scrollCollapse : true,
										ajax : {
											url : '/safe/v1/getPassengerDetails?userId='
													+ $("#customerEmail").val(),
											dataSrc : '',
											beforeSend : function(xhr) {
												$("#loaderDiv").show();
											},
											statusCode : {
												200 : function() {
													$("#loaderDiv").hide();
												}
											},
											error : function(xhr, result,
													status) {
												if (xhr.status != 200) {
													alert("You Have Encountered an Unexpected Error. Please Contact System Administrator for Assistance");
													$("#loaderDiv").hide();
												}
											}
										},
										columns : columnDefs,
										dom : 'Bfrtip',
										select : 'single',
										responsive : true,
										altEditor : true,
										buttons : [ {
											text : 'Add Passenger',
											name : 'add'
										}, {
											extend : 'selected',
											text : 'Edit Passenger',
											name : 'edit'
										}, {
											extend : 'selected',
											text : 'Delete Passenger',
											name : 'delete'
										}, {
											text : 'Refresh',
											name : 'refresh'
										} ],
										onAddRow : function(datatable, rowdata,
												success, error) {
											var addPassengerData = {
												custEmail : $("#customerEmail")
														.val(),
												fname : rowdata.fname,
												lname : rowdata.lname,
												gender : rowdata.gender,
												nationality : rowdata.nationality,
												passportNo : rowdata.passportNo,
												dob : rowdata.dob,
												passExpiry : rowdata.passExpiry
											};
											$
													.ajax(
															{
																url : '/safe/v1/addPassenger',
																type : 'POST',
																data : JSON
																		.stringify(addPassengerData),
																contentType : 'application/json; charset=utf-8',
															})
													.done(
															function(result) {
																$(
																		'#altEditor-modal-')
																		.modal(
																				'hide');
																$(
																		'#purchasePlanTable')
																		.DataTable().ajax
																		.reload();
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																alert('Add Passenger'
																		+ xhr.statusText
																		+ ' '
																		+ xhr.responseText
																		+ ' '
																		+ xhr.status);
															});
										},
										onDeleteRow : function(datatable,
												rowdata, success, error) {
											var deletePassenger = {
												pId : rowdata.pId
											};
											$
													.ajax(
															{
																url : '/safe/v1/deletePassenger',
																type : 'POST',
																data : JSON
																		.stringify(deletePassenger),
																contentType : 'application/json; charset=utf-8'

															})
													.done(
															function(result) {
																$(
																		'#altEditor-modal-')
																		.modal(
																				'hide');
																$(
																		'#purchasePlanTable')
																		.DataTable().ajax
																		.reload();
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																alert('Delete Passenger Record '
																		+ xhr.statusText
																		+ ' '
																		+ xhr.responseText
																		+ ' '
																		+ xhr.status);
															});
										},
										onEditRow : function(datatable,
												rowdata, success, error) {
											var updatePassengerData = {
												pId : rowdata.pId,
												fname : rowdata.fname,
												lname : rowdata.lname,
												gender : rowdata.gender,
												nationality : rowdata.nationality,
												passportNo : rowdata.passportNo,
												dob : rowdata.dob,
												passExpiry : rowdata.passExpiry
											};
											$
													.ajax(
															{
																url : '/safe/v1/updatePassengerRecord',
																type : 'POST',
																data : JSON
																		.stringify(updatePassengerData),
																contentType : 'application/json; charset=utf-8',
																dataType : 'json',
																success : function(
																		data) {
																	$(
																			'#altEditor-modal-')
																			.modal(
																					'hide');
																	$(
																			'#purchasePlanTable')
																			.DataTable().ajax
																			.reload();
																},
																statusCode : {
																	200 : function() {
																		$(
																				"#loaderDiv")
																				.hide();
																	}
																}
															})
													.fail(
															function(xhr,
																	result,
																	status) {
																$("#loaderDiv")
																		.hide();
																alert('Update Passenger Details'
																		+ xhr.responseText);
																$(
																		'#altEditor-modal-')
																		.modal(
																				'hide');
																$(
																		'#purchasePlanTable')
																		.DataTable().ajax
																		.reload();
															});
										}
									});
				});