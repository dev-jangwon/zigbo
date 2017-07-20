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
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"요청코드"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"날짜"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"진행상태"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"이동하기"+
								"</div>"+
							"</div>"+
						"</li>");
		
			for (var i = 0; i < JSON.parse(result[0].requestList).length; i++) {
				var obj = JSON.parse(result[0].requestList)[i];
				var progress = "<span class='label label-info'>진행중</span>";

				if (obj.progress == 'W') {
					progress = "<span class='label label-primary'>대기중</span>";
				} else if (obj.progress='D') {
					progress = "<span class='label label-success'>완료</span>";
				}
				
				$(".request-ul").append(
						"<li>" +
							"<div class='col-md-3'>" + obj.requestCode +
							"</div>" +
							"<div class='col-md-3'>" + obj.uploadDate +
							"</div>" +
							"<div class='col-md-3'>" + progress +
							"</div>" +
							"<div class='col-md-3'>" + 
								"<a href='/zigbo/request?command=requestDetail&requestCode=" + obj.requestCode +"'>이동</a>" +
							"</div>" +
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
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"판매코드"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"날짜"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"진행상태"+
								"</div>"+
								"<div class='col-md-3' style='font-size:1.3em;margin-bottom:10px;'>"+
									"이동하기"+
								"</div>"+
							"</div>"+
						"</li>");
		
			for (var i = 0; i < JSON.parse(result[0].sellingList).length; i++) {
				var obj = JSON.parse(result[0].sellingList)[i];
				
				var progress = "<span class='label label-info'>진행중</span>";

				if (obj.progress == 'W') {
					progress = "<span class='label label-primary'>대기중</span>";
				} else if (obj.progress='D') {
					progress = "<span class='label label-success'>완료</span>";
				}
				
				$(".selling-ul").append(
						"<li>" +
							"<div class='col-md-3'>" + obj.sellingCode +
							"</div>" +
							"<div class='col-md-3'>" + obj.uploadDate +
							"</div>" +
							"<div class='col-md-3'>" + progress +
							"</div>" +
							"<div class='col-md-3'>" + 
								"<a href='/zigbo/selling?command=sellingDetail&sellingCode=" + obj.sellingCode +"'>이동</a>" +
							"</div>" +
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
    		
    } else if ((target == '#support')) {
    		
    }
});