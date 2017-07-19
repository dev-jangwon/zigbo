function getRecentSelling() {
	$.ajax({
		url: "selling",
		data: {command: "getMostRecent"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_selling_list").html(result);
		}
	});
}

function getViewSelling() {
	$.ajax({
		url: "selling",
		data: {command: "getMostViews"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_selling_list").html(result);
		}
	});
}

function getZZimSelling() {
	$.ajax({
		url: "selling",
		data: {command: "getMostInterest"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_selling_list").html(result);
		}
	});
}
getRecentSelling();

function getRecentRequest() {
	$.ajax({
		url: "request",
		data: {command: "getMostRecentRequest"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_request_list").html(result);
		}
	});
}
getRecentRequest();
