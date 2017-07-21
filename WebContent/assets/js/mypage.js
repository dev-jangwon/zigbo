function getRequestList() {
	$.ajax({
		url: "/zigbo/request",
		data: {
			command: "getMyRequest"
		},
		method: "get",
		dataType: "json",
		success: function(result) {
			if (JSON.parse(result[0].requestList).length == 0) {
				$(".request-ul").append("데이터가 없습니다");
				return;
			}
			$(".request-ul").append(
						"<li>"+
							"<div class='row'>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"요청코드"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"날짜"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"진행상태"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"이동하기"+
								"</div>"+
							"</div>"+
						"</li>");
		
			for (var i = 0; i < JSON.parse(result[0].requestList).length; i++) {
				var obj = JSON.parse(result[0].requestList)[i];
				var progress = "<span class='label label-info>완료</span>";
				var href = "<a href='/zigbo/request?command=requestDetail&requestCode=" + obj.requestCode +"'>이동</a>";
				
				if (obj.progress == 'W') {
					progress = "<span class='label label-primary'>대기중</span>";
				} else if (obj.progress=='P') {
					progress = "<span class='label label-success'>진행중</span>";
					href = "<a href='/zigbo/request?command=applyDetail&requestCode=" + obj.requestCode +"'>이동</a>";
				} else if (obj.progress = 'D') {
					progress = "<span class='label label-info'>완료</span>";
				}
				
				$(".request-ul").append(
						"<li>" +
						"<div class='row'>"+
							"<div class='col-md-3 zigbo-col-md'>" + obj.requestCode +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + obj.uploadDate.replace('?', ',') +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + progress +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + 
								href +
							"</div>" +
							"</div>"+
						"</li>");
			}
		}
	});
}

function getSellingList() {
	$.ajax({
		url: "/zigbo/selling",
		data: {
			command: "getMySelling"
		},
		method: "get",
		dataType: "json",
		success: function(result) {
			if (JSON.parse(result[0].sellingList).length == 0) {
				$(".selling-ul").append("데이터가 없습니다");
				return;
			}
			$(".selling-ul").append(
						"<li>"+
							"<div class='row'>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"판매코드"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"날짜"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"진행상태"+
								"</div>"+
								"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"이동하기"+
								"</div>"+
							"</div>"+
						"</li>");
		
			for (var i = 0; i < JSON.parse(result[0].sellingList).length; i++) {
				var obj = JSON.parse(result[0].sellingList)[i];
				
				var progress = "<span class='label label-info'>진행중</span>";

				if (obj.progress == 'W') {
					progress = "<span class='label label-primary'>대기중</span>";
				} else if (obj.progress=='D') {
					progress = "<span class='label label-success'>완료</span>";
				}
				
				$(".selling-ul").append(
						"<li>" +
						"<div class='row'>"+
							"<div class='col-md-3 zigbo-col-md'>" + obj.sellingCode +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + obj.uploadDate.replace('?', ',') +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + progress +
							"</div>" +
							"<div class='col-md-3 zigbo-col-md'>" + 
								"<a href='/zigbo/selling?command=sellingDetail&sellingCode=" + obj.sellingCode +"'>이동</a>" +
							"</div>" +
							"</div>"+
						"</li>");
			}
		}
	});
}

function getPurchaseList() {
	$.ajax({
		url: "/zigbo/selling",
		data: {
			command: "getMyPurchase"
		},
		method: "get",
		dataType: "json",
		success: function(result) {
			if (JSON.parse(result[0].purchaseList).length == 0 && JSON.parse(result[2].requestPaymentList).length == 0) {
				$(".purchase-ul").append("데이터가 없습니다");
				return;
			} else {
				$(".purchase-ul").append(
							"<li>"+
								"<div class='row'>"+
									"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
										"결제코드"+
									"</div>"+
									"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
										"구매 이메일"+
									"</div>"+
									"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
										"배송주소"+
									"</div>"+
									"<div class='col-md-3 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
										"구분"+
									"</div>"+
								"</div>"+
							"</li>");
			
				for (var i = 0; i < JSON.parse(result[0].purchaseList).length; i++) {
					var obj = JSON.parse(result[0].purchaseList)[i];
					
					$(".purchase-ul").append(
							"<li>" +
							"<div class='row'>"+
								"<div class='col-md-3 zigbo-col-md'>" + obj.paymentCode +
								"</div>" +
								"<div class='col-md-3 zigbo-col-md'>" + result[1].email +
								"</div>" +
								"<div class='col-md-3 zigbo-col-md'>" + obj.address +
								"</div>"+
								"<div class='col-md-3 zigbo-col-md'>" + "판매 결제" +
								"</div>"+
								"</div>"+
							"</li>");
				}
			}
			
			if (JSON.parse(result[0].purchaseList).length == 0 && JSON.parse(result[2].requestPaymentList).length == 0) {
				$(".purchase-ul").append("데이터가 없습니다");
			} else {
				for (var i = 0; i < JSON.parse(result[2].requestPaymentList).length; i++) {
					var obj = JSON.parse(result[2].requestPaymentList)[i];
					
					$(".purchase-ul").append(
							"<li>" +
							"<div class='row'>"+
								"<div class='col-md-3 zigbo-col-md'>" + obj.payment_code +
								"</div>" +
								"<div class='col-md-3 zigbo-col-md'>" + result[1].email +
								"</div>" +
								"<div class='col-md-3 zigbo-col-md'>" + obj.address +
								"</div>"+
								"<div class='col-md-3 zigbo-col-md'>" + "요청 결제" +
								"</div>"+
								"</div>"+
							"</li>");
				}
			}
		}	
	});
}

function getApplyList() {
	$.ajax({
		url: "/zigbo/request",
		data: {
			command: "getApplyMemberRequest"
		},
		method: "get",
		dataType: "json",
		success: function(result) {
			if (JSON.parse(result[0].applyList).length == 0) {
				$(".selling-ul").append("데이터가 없습니다");
				return;
			}
			$(".apply-ul").append(
						"<li>"+
							"<div class='row'>"+
								"<div class='col-md-4 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"지원코드"+
								"</div>"+
								"<div class='col-md-4 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"요청코드"+
								"</div>"+
								"<div class='col-md-4 zigbo-col-md' style='font-size:1.3em;margin-bottom:10px;'>"+
									"진행상태"+
								"</div>"+
							"</div>"+
						"</li>");
		
			for (var i = 0; i < JSON.parse(result[0].applyList).length; i++) {
				var obj = JSON.parse(result[0].applyList)[i];
				
				var progress = "<span class='label label-info'>완료</span>";

				if (obj.progress == 'W') {
					progress = "<span class='label label-primary'>대기중</span>";
				} else if (obj.progress=='P') {
					progress = "<span class='label label-success'>진행중</span>";
				}
				
				$(".apply-ul").append(
						"<li>" +
						"<div class='row'>"+
							"<div class='col-md-4 zigbo-col-md'>" + obj.applyCode +
							"</div>" +
							"<div class='col-md-4 zigbo-col-md'>" + obj.requestCode +
							"</div>" +
							"<div class='col-md-4 zigbo-col-md'>" + progress  +
							"</div>" +
							"</div>"+
						"</li>");
			}
		}
	});
}

getRequestList();

$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
    var target = $(e.target).attr("href");
    
    if ((target == '#selling')) {
    		$('.selling-ul').empty();
    		getSellingList();
    } else if ((target == '#request')) {
    		$('.request-ul').empty();
	    	getRequestList();
    } else if ((target == '#purchase')) {
    		$('.purchase-ul').empty();
    		$('.request-purchase-ul').empty();
    		getPurchaseList();
    } else if ((target == '#apply')) {
    		$('.apply-ul').empty();
    		getApplyList();
    }
});