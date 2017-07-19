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
		url: "request",
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
		url: "request",
		data: {command: "getMostInterest"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_selling_list").html(result);
		}
	});
}
getRecentSelling();
