$(document)
		.ready(
				function() {

					var columnDefs = [ {
						data : 'pId',
						title : 'Id',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'custId',
						title : 'custId',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'cType',
						title : 'cType',
						type : 'hidden',
						visible : false,
						searchable : false
					}, {
						data : 'pFname',
						title : 'First Name'
					}, {
						data : 'pLname',
						title : 'Last Name'
					}, {
						data : 'pDob',
						title : 'DOB',
						type : 'date'
					}, {
						data : 'pGender',
						title : 'Gender'
					}, {
						data : 'aptNo',
						title : 'Apt No'
					}, {
						data : 'city',
						title : 'City'
					}, {
						data : 'cstState',
						title : 'State'
					}, {
						data : 'street',
						title : 'Street'
					}, {
						data : 'zip',
						title : 'Zip Code'
					}, {
						data : 'contactNum',
						title : 'Contact No'
					}, {
						data : 'countryCode',
						title : 'Country Code'
					}, {
						data : 'custEmail',
						title : 'Customer Email',
						type : 'readonly'
					}, {
						data : 'pNationality',
						title : 'Nationality'
					}, {
						data : 'pPassExpiry',
						title : 'Passport Expiry Date',
						type : 'date'
					}, {
						data : 'pPassportNo',
						title : 'Passport Number'
					}, {
						data : 'emerContactFname',
						title : 'Emerg Contact First Name'
					}, {
						data : 'emerContactLname',
						title : 'Emerg Contact Last Name'
					}, {
						data : 'assoAirline',
						title : 'Airline Name'
					}, {
						data : 'memName',
						title : 'Membership Name'
					}, {
						data : 'memStdate',
						title : 'Membership Start Date',
						type : 'date'
					}, {
						data : 'memEnddate',
						title : 'Membership End Date',
						type : 'date'
					}, {
						data : 'baName',
						title : 'Agent Name'
					}, {
						data : 'baWebadd',
						title : 'Agent WebPage'
					}, {
						data : 'baContNo',
						title : 'Agent Contact Num'
					} ];

					var myTable;

					myTable = $('#customerDetailsTable')
							.DataTable(
									{
										'sPaginationType' : 'full_numbers',
										scrollX : 1000,
										scrollCollapse : true,
										ajax : {
											url : '/safe/v1/GetCustomerRegistration?userId='
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
											extend : 'selected',
											text : 'Edit',
											name : 'edit'
										}, {
											text : 'Refresh',
											name : 'refresh'
										} ],
										onEditRow : function(datatable,
												rowdata, success, error) {
											var pType = 'C';
											var updateCustData = {
												pId : rowdata.pId,
												custId : rowdata.custId,
												passengerFirstName : rowdata.pFname,
												passengerLastName : rowdata.pLname,
												passengerGender : rowdata.pGender,
												passengerNationality : rowdata.pNationality,
												passengerPassportNo : rowdata.pPassportNo,
												passengerDob : rowdata.pDob,
												passengerPassportExpiry : rowdata.pPassExpiry,
												passengerType : pType,
												custId : rowdata.custId,
												street : rowdata.street,
												aptno : rowdata.aptNo,
												city : rowdata.city,
												custState : rowdata.cstState,
												country : rowdata.country,
												zip : rowdata.zip,
												custEmail : rowdata.custEmail,
												contactNum : rowdata.contactNum,
												countryCodePhone : rowdata.countryCode,
												emergencyContactNum : rowdata.emergencyContactNum,
												emergencyContactFirstName : rowdata.emerContactFname,
												emergencyContactLastName : rowdata.emerContactLname,
												customerType : rowdata.cType,
												bookingAgentName : rowdata.baName,
												bookingAgentWebAdd : rowdata.baWebadd,
												bookingAgentContactNo : rowdata.baContNo,
												membershipname : rowdata.memName,
												assoicatedAirline : rowdata.assoAirline,
												membershipStartDate : rowdata.memStdate,
												membershipEndtDate : rowdata.memEnddate
											};
											//alert(JSON.stringify(updateCustData));
											// return true;
											$
													.ajax(
															{
																url : '/safe/v1/UpdateCustomerRegistration',
																type : 'POST',
																data : JSON
																		.stringify(updateCustData),
																contentType : 'application/json; charset=utf-8',
																beforeSend : function(
																		xhr) {
																	$(
																			"#loaderDiv")
																			.show();
																},
																dataType : 'json',
																success : function(
																		data) {
																	alert(data.statusMessage);
																	$(
																			'#altEditor-modal-')
																			.modal(
																					'hide');
																	$(
																			'#customerDetailsTable')
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
																alert('Update Customer Details'
																		+ xhr.responseText);
																$(
																		'#altEditor-modal-')
																		.modal(
																				'hide');
																$(
																		'#customerDetailsTable')
																		.DataTable().ajax
																		.reload();
															});
										}
									});
				});