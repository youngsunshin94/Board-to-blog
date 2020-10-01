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
                <a href="#"><i class="fas fa-pen"></i> 글쓰기</a>
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

                    </tbody>                 
                </table>
            </div>
			<!-- ct-body -->

        </div>
        <!-- contents -->
    </div>
    <!-- wrapper -->


</body>
</html>