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
    <link rel="stylesheet" href="/resources/css/list.css">
    <link rel="stylesheet" href="/resources/css/modal.css">
    <link rel="stylesheet" href="/resources/css/common.css">
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
                <h2>전체 게시글</h2>
                <a href="/board/register"><i class="fas fa-pen"></i> 글쓰기</a>
            </div>
            <div class="ct_body">
                <table>
                    <thead>
                        <tr>
                            <th class="tb_bno">번호</th>
                            <th class="tb_title">제목</th>
                            <th class="tb_writer">글쓴이</th>
                            <th class="tb_regdate">작성일</th>
                            <th class="tb_hit">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${list }" var="board">
	                    	<tr data-bno="${board.bno }">
								<td class="tb_bno"><c:out value="${board.bno }"/></td>
								<td class="tb_title"><c:out value="${board.title }"/></td>
								<td class="tb_writer"><c:out value="${board.writer }"/></td>
								<td class="tb_regdate"><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/></td>
								<td class="tb_hit"><c:out value="${board.hit }"/></td>
							</tr>
                    	</c:forEach>
                    </tbody>        
                </table>
                <form action="/board/get" method="get" id="getAction">
                	<input type='hidden' name='bno'>
                	<input type='hidden' name='pageNum' value="${pageDTO.cri.pageNum }">
                	<input type='hidden' name='amount' value="${pageDTO.cri.amount }">
                	<input type='hidden' name='keyword' value="${pageDTO.cri.keyword }">
                	<input type='hidden' name='type' value="${pageDTO.cri.type }">
                </form>
            </div>
			<!-- ct-body -->
			
			<div class="ct_footer">
				<div class="search-box">
                    <form action="/board/list" method="get" id="searchForm">
                        <select name="type">
                            <option value="" ${pageDTO.cri.type == '' ? 'selected' : '' }>--</option>
                            <option value="T" ${pageDTO.cri.type eq 'T' ? 'selected' : '' }>제목</option>
                            <option value="C" ${pageDTO.cri.type eq 'C' ? 'selected' : '' }>내용</option>
                            <option value="W" ${pageDTO.cri.type eq 'W' ? 'selected' : '' }>작성자</option>
                            <option value="TCW" ${pageDTO.cri.type eq 'TCW' ? 'selected' : '' }>제목+내용+작성자</option>
                        </select>
                        <input type="text" name="keyword" value="${pageDTO.cri.keyword }">
                        <input type='hidden' name='pageNum' value="${pageDTO.cri.pageNum }">
                		<input type='hidden' name='amount' value="${pageDTO.cri.amount }">
                		<button id="btn-search">검색</button>
                    </form>
                </div>
                <div class="paging">
                    <ul class="paginate">
                    	<c:if test="${pageDTO.prev }">
                    		<li><a href="${pageDTO.startNum -1 }">prev</a></li>
                    	</c:if>
                    	
                       <c:forEach begin="${pageDTO.startNum }" end="${pageDTO.endNum }" var="num">
                       		<li class="${pageDTO.cri.pageNum == num ? 'active' : '' }"><a href="${num }">${num }</a></li>
                       </c:forEach>
                       
                    	<c:if test="${pageDTO.next }">
                    		<li><a href="${pageDTO.endNum+1 }">next</a></li>
                    	</c:if>
                    </ul>
                </div>
            </div>
			<!-- ct_footer -->
        </div>
        <!-- contents -->
    </div>
    <!-- wrapper -->

<script type="text/javascript">
$(document).ready(function(){
	
	var getAction = $("#getAction");
	
	$("tr").on("click",function(){
		getAction.find("input[name='bno']").val($(this).data("bno"));
		getAction.submit();
	});
	
	$(".paginate li a").on("click", function(e){
		e.preventDefault();
		
		getAction.find("input[name='bno']").remove();
		getAction.attr("action","/board/list");
		getAction.find("input[name='pageNum']").val($(this).attr("href"));
		getAction.submit();
	});
	
	$("#btn-search").on("click", function(e){
		e.preventDefault();
		
		$("#searchForm").find("input[name='pageNum']").val("1");
		$("#searchForm").submit();
	});
	
});
</script>

</body>
</html>