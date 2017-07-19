function getSalesList() {
	$.ajax({
		url: "/zigbo/selling",
		data: {command: "getAllSelling"},
		method: "post",
		dataType: "html",
		success: function(result) {
			$(".zigbbo-sales-list").html(result);
		}
	});
}
getSalesList();