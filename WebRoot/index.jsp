<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4></h4>
	<a href="hello?name=树朾" dataType="html">index 测试页面</a><br/>
	<a href="Province/add?code=0&name=上海" > 点击添加</a><br/>
	<a href="SnProvince/countAll" > 点击统计</a><br/>
	<a href="SnProvince/getListByPage?pageSize=3&pageNo=0" > 前3条</a><br/>
	<a href="SnProvince/getAll"> 获取全部</a><br/>
	<button id="province">获取同名身份</button>
	<div></div>
</body>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>
<script type="text/javascript">
	$("#province").click(function() {
		$("div").load("privinces.txt");
		setTimeout(function() {
			$("h4").html("");
			$("div").find("li").each(function(index,item) {
				var url = "SnProvince/add";
				var data = {name:$($(item).find("span")[0]).text(),code:$(item).attr("id").match(/\d+$/)-0};
				$("h4").append($.toJSON(data));
				//$.ajax({type:"post",url:url,data:data,dataType:"json",async : true,success : success,error : error,});
			});
			$("h4").html($("div").find("li").size());
		},1000);
	});
	$("a").attr("onclick","return false").click(function() {
		$this = $(this);
		var href = $this.attr("href");
		var type = $this.attr("type")||"post";
		var dataType = $this.attr("dataType")||"json";
		var data = href.split('?')[1];
		var href = href.split('?')[0];
		$("h4").html("正在加载。。。");
		$.ajax({
			type : type,url : href,data:data,async : true,cache : false,
            dataType : dataType,success : success,error : error,
		});
	});
	function success(data) {
		if(data.result){
			$("h4").html($.toJSON(data.data));
		}else if(data.data){
			$("h4").html(data.data);
		}else{
			$("h4").html(data);
		}
	}
	function error(data) {
		$("h4").html(data);
		$.each(arguments,function (index,item){
			$("h4").html(function() {
				return $(this).html()+"<br/>"+item;
			});
		});
	}
</script>
</html>