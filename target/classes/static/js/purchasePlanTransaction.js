$(document).ready(
		function() {

			var custTable = $('#purchasePlanCustomerTable').DataTable(
					{
						dom : "Bfrtip",
						scrollX : 1000,
						scrollCollapse : true,
						ajax : {
							url : '/safe/v1/GetCustomerRegistration?userId='
									+ $("#customerEmail").val(),
							dataSrc : ''
						},
						columns : [ {
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
						} ],
						select : {
							style : 'single'
						},
						responsive : true,
						altEditor : true,
						buttons : [ {
							text : 'Refresh',
							name : 'refresh'
						} ]
					});

			var passengerTable = $('#purchasePlanPassengerTable').DataTable({
				dom : 'Bfrtip',
				scrollX : 1000,
				scrollCollapse : true,
				ajax : {
					url : '/safe/v1/getTransactionDetails',
					dataSrc : '',
					data : function(d) {
						var selected = custTable.row({
							selected : true
						});
						if (selected.any()) {
							d.custEmail = selected.data().custEmail;
						} else {
							d.custEmail = $("#customerEmail").val();
						}
					}

				},
				columns : [ {
					data : 'pFname',
					title : 'First Name'
				}, {
					data : 'pLname',
					title : 'Last Name'
				}, {
					data : 'pGender',
					title : 'Gender'
				}, {
					data : 'pDob',
					title : 'Dob'
				}, {
					data : 'nationality',
					title : 'Nationality'
				}, {
					data : 'pPassportNo',
					title : 'Passport No'
				}, {
					data : 'pPassExpiry',
					title : 'Passport Expiry'
				}, {
					data : 'flightDetails',
					title : 'Flight'
				}, {
					data : 'plan',
					title : 'Purchased Plans'
				}, {
					data : 'pmtAmt',
					title : 'Payment Amount'
				}, {
					data : 'pmtDate',
					title : 'Payment Date'
				}, {
					data : 'payType',
					title : 'Payment Type'
				}

				],
				select : true,
				responsive : true,
				altEditor : true,
				buttons : [ {
					text : 'Refresh',
					name : 'refresh'
				} ]
			});

			custTable.on('select', function(e) {
				passengerTable.ajax.reload();

			});

			custTable.on('deselect', function() {
				passengerTable.ajax.reload();
			});

		});