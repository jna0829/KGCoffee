<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

target =localStorage.getItem('history');

localStorage.removeItem('history');

location.href = target;

</script>