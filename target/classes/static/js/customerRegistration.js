$(document).ready(function() {
	$('#customerRegistrationForm').submit(function(event) {

		var customerData = {
			passengerFirstName : $("#passengerFirstName").val(),
			passengerLastName : $("#passengerLastName").val(),
			passengerGender : $("#passengerGender").val(),
			passengerNationality : $("#passengerNationality").val(),
			passengerPassportNo : $("#passengerPassportNo").val(),
			passengerDob : $("#passengerDob").val(),
			passengerPassportExpiry : $("#passengerPassportExpiry").val(),
			passengerType : 'C',
			street : $("#street").val(),
			aptno : $("#aptno").val(),
			city : $("#city").val(),
			custState : $("#custState").val(),
			country : $("#country").val(),
			zip : $("#zip").val(),
			custEmail : $("#custEmail").val(),
			contactNum : $("#contactNum").val(),
			countryCodePhone : $("#countryCodePhone").val(),
			emergencyContactNum : $("#emergencyContactNum").val(),
			emergencyContactFirstName : $("#emergencyContactFirstName").val(),
			emergencyContactLastName : $("#emergencyContactLastName").val(),
			customerType : $("#customerType").val(),
			bookingAgentName : $("#bookingAgentName").val(),
			bookingAgentWebAdd : $("#bookingAgentWebAdd").val(),
			bookingAgentContactNo : $("#bookingAgentContactNo").val(),
			membershipname : $("#membershipname").val(),
			assoicatedAirline : $("#assoicatedAirline").val(),
			membershipStartDate : $("#membershipStartDate").val(),
			membershipEndtDate : $("#membershipEndtDate").val(),
		};

		$.ajax({
			type : "POST",
			url : "/safe/v1/CreateCustomerRegistration",
			data : JSON.stringify(customerData),
			contentType : 'application/json; charset=utf-8',
			encode : true,
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
			alert('Update Customer Details' + ' ' + xhr.responseText);
		});

		event.preventDefault();
	});
});