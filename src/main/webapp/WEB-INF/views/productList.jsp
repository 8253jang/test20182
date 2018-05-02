<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{width: 800px;border:5px green solid;}
  td,th{text-align: center; border: 1px gray solid;}
  a{text-decoration: none;}
</style>


<script type="text/javascript" 
src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
   $(function(){
	   //삭제하기
	   $("input[value=삭제]").click(function(){
		   var code = 
			   $(this).parent().parent().children("td:first").next().text();
		  // alert(code)
		   location.href="${pageContext.request.contextPath}/delete/"+code;
	   });
   })

</script>


</head>
<body>


<table>
<caption>
  <h1>[ Product List Page ]</h1>
</caption>
 <tr>
   <th>번호</th>
   <th>상품코드</th>
   <th>상품이름</th>
   <th>상품가격</th>
   <th>상품설명</th>
   <th>삭제하기</th>
 </tr>
   <c:choose>
    <c:when test="${list.size()>0}">
       <c:forEach items="${list}" var="dto" varStatus="state">
          <tr>
            <td>${state.count}</td>
            <td>${dto.code}</td>
            <td>${dto.name}</td>
            <td><fmt:formatNumber value="${dto.price}"/>원</td>
            <td>${dto.detail}</td>
            <td><input type="button" value="삭제" ></td>  
          </tr>
       </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <th colspan="6">검색된 레코드가 없습니다.</th>
      </tr>
    </c:otherwise>
  </c:choose>
  
  
  <tr>
    <th colspan="6"><a href="insertForm">상품등록하기</a></th>
   </tr>
 
</table>


</body>




</html>