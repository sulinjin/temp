<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
	<script type="text/javascript">
		var content ={
				"index" : 0,
				"pageLength" : 5
		}
		
		function detailAjax(url, method, content){
			$.ajax({
	            type : method,
	            url : url,
	            data : content,
	            dataType : "text",
	            success : function(data){
	                console.log(data);
	            },
	            error : function(){
	                alert('통신실패!!');
	            }
	        });
		}
		
		function data(content){
			$.ajax({
	            type : "GET",
	            url : "/spring/user",
	            data : content,
	            dataType : "text",
	            success : function(data){
	                console.log("통신데이터 값 : " + data) ;   
	                $('#user').remove();
	                var str = "<tbody id='user'>";
	                $.each(JSON.parse(data),function(index, item){
	                	console.log(item.id+"  " +item.username);
	                		str += "<tr>"
	        				str += "<td>" + item.id + "</td>";
	        				str += "<td>" + item.username + "</td>";
	                });
	                $('#list').append(str);
	            },
	            error : function(){
	                alert('통신실패!!');
	            }
	        });
		}
	
		$(document).ready(function(){
			data(content);
			var userData = {
					"id" : 5
			}
			detailAjax("/spring/detail/user", "GET", userData);
			/* var str = "";
			$.each(${all}, function(index ,item){
				str += "<tr>"
				str += "<td>" + item.id + "</td>";
				str += "<td>" + item.username + "</td>";
				str += "</tr>";
			});
			$('#user').append(str); */
			
			$("#next").on("click", function(){
				var indexPage = parseInt($("#index").val());
				$("#index").val(indexPage + 1);
				content.index = indexPage + 1;
				data(content);
			});
			
			$("#previous").on("click", function(){
				var indexPage = parseInt($("#index").val());
				if(indexPage <= 0){
					$("#index").val(0);
					content.index = 0;
				}else{
					$("#index").val(indexPage - 1);
					content.index = indexPage - 1;
				}
				data(content);
			});
			
			//이용시간 팝업 호출
	        $(document).on('click', '#user tr', function(){
	            var checkBtn = $(this);

	            // checkBtn.parent() : checkBtn의 부모는 <td>이다.
	            // checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
	            var tr = checkBtn;
	            var td = tr.children();
	            var id = td.eq(0).text();	      
	            var username = td.eq(1).text();

	            console.log(id + "   "+ username);
	        });
		});
		
		
		
	</script>
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="index" value=0>
<div>
	<div style="float: left; width: 40%; display: flex; justify-content: flex-end; height: 140px;">
		<button id="previous" style="width: auto; height: 50px; margin: 45px 20px 0 0; cursor:pointer">이전</button>
	</div>
	<div style="float: left; width: 20%; display: flex; justify-content: center;">
		<table id="list">
			<tbody id="user"></tbody>
		</table>
	</div>
	<div style="float: left; width: 40%; display: flex; justify-content: flex-start; height: 140px;">
		<button id="next" style="width: auto; height: 50px; margin: 45px 0 0 20px;cursor:pointer">다음</button>
	</div>
</div>
</body>
</html>