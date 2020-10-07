<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/common.css">
    <link rel="stylesheet" href="/resources/css/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div class="wrapper">
        <div class="header_wrapper">
            <div class="header">
                <div class="logo">
                    <a href="/board/list">board Project</a>
                </div>      
                <div class="hd_link">
                    <a href="#"><i class="fas fa-sign-in-alt"></i> 로그인</a>
                </div>
            </div>
        </div>
        <div class="contents">
            <div class="ct_head">
                <h2>게시글 수정</h2>
            </div>
            <div class="ct_body">
                <form action="/board/modify" method="post" id="form">
                	<input type='hidden' name='bno' value="${board.bno }">
                	<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
					<input type="hidden" name="type" value="${cri.type }">
					<input type="hidden" name="keyword" value="${cri.keyword }">
					
                    <div class="form-group">
                        <label>제목</label><br><input type="text" name="title" value="${board.title }">
                    </div>
                    <div class="form-group">
                        <label>내용</label><br><textarea name="content">${board.content }</textarea>
                    </div>
                    <div class="form-group">
                        <label>작성자</label><br><input type="text" name="writer" value="${board.writer }">
                    </div>
                    <button class="btn" data-type='modify'>수정</button>
                    <button class="btn" data-type='remove'>삭제</button>
                    <button class="btn" data-type="list">list</button>
                </form>
               
            </div>
			<!-- ct_body -->
        </div>
		<!-- contents -->

    </div>
<script type="text/javascript">
$(document).ready(function(){
	
	var formTag = $("#form");
	
	$("button[data-type='modify']").on('click',function(e){
		e.preventDefault();
		
		formTag.submit();
		
	});
	
	$("button[data-type='list']").on('click',function(e){
		e.preventDefault();
		
		var pageNumTag = $("input[name='pageNum']").clone();
		var amountTag = $("input[name='amount']").clone();
		var typeTag = $("input[name='type']").clone();
		var keywordTag = $("input[name='keyword']").clone();
		
		formTag.empty();
		
		formTag.append(pageNumTag);
		formTag.append(amountTag);
		formTag.append(keywordTag);
		formTag.append(typeTag);
		
		formTag.attr("action","/board/list").attr("method","get");
		formTag.submit();
		
	});
	
	$("button[data-type='remove']").on('click',function(e){
		e.preventDefault();
		
		if(confirm("삭제하시겠습니까?")){
			formTag.attr("action","/board/remove");
			formTag.submit();			
		}		
	});	
});
</script>
</body>
</html>