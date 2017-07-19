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

function getRecentRequest() {
	$.ajax({
		url: "request",
		data: {command: "getRequest"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$("#index_selling_list").html(result);
		}
	});
}
getRecentSelling();


getRecentSelling();