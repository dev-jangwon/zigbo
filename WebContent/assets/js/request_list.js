function getRequestList(index) {
	$.ajax({
		url: "/zigbo/request",
		data: {
			command: "getAllRequest",
			index: index
		},
		method: "post",
		dataType: "html",
		success: function(result) {
			$(".zigbbo-request-list").html(result);
		}
	});
}
getRequestList(0);