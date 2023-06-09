<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<c:if test="${boardList == null && error == null}">
	</c:if>
	
	<div class="wrap">
		<table class="board_list">
			<caption>
				<h1>home gardening</h1>
				<p>살아남은 식물만 같이간다^^!</p>
			</caption>
			<thead>
				<tr>
					<th>번호</th>
					<th>식물 이름</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<!--  for (Board board : boardList) -->
			<c:forEach items="${boardList}" var = "b" varStatus="i">
				<tr>
					<td>${b.board_no}</td>
					<td class="title"><a href="view?board_no=${b.board_no}">${b.title}</a></td>
					<td>${b.user_id}</td>
					<td>${b.reg_date}</td>
					<td>${b.views}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="bt_wrap bt_list">
			<a href="write">새로운 식물 등록</a>
		</div>
		<div class="board_page">
			<a href="#" class="bt first">&lt;&lt;</a> <a href="#" class="bt prev">&lt;</a>
			<a href="#" class="num on">1</a> <a href="#" class="num">2</a> <a
				href="#" class="num">3</a> <a href="#" class="num">4</a> <a href="#"
				class="num">5</a> <a href="#" class="bt next">&gt;</a> <a href="#"
				class="bt last">&gt;&gt;</a>
		</div>
	</div>
	
	<script> //스크립트 안에있으면 자동완성 안됨
		<c:if test="${param.error != null}"> //param : 리퀘스트 객체.
			alert("${param.error}");
		</c:if>
		<c:if test="${error != null}"> //둘다 에러메시지 출력. 어디로 들어갈지 몰라서 2개. 
			alert("${error}");
		</c:if>
	</script>
	
</body>
</html>