<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${row !=0 }">
	<script>
alert("북마크가 저장되었습니다. 감사합니다. -당신을 위한 ForYou-");
location.href="Rent?cmd=myRent";
</script>
</c:if>