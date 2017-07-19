function getRequestList() {
	$.ajax({
		url: "/zigbo/request",
		data: {command: "getAllRequest"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$(".zigbbo-request-list").html(result);
		}
	});
}
getRequestList();