<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

var re_bpno = '${view.bp_no}';
var mm_code = '${mm_code}';

 
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
    replyInsert(insertData); //Insert 함수호출(아래)
});
 

//댓글 목록
function replyList(){
    $.ajax({
        url : '/replyList',
        type : 'get',
        data : {'re_bpno':re_bpno},
        success : function(data){
            var a ='';
            var b = '';
            $.each(data, function(key, value){
            	b = value.re_mmcode;
                a += '<div class="replyArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px; font-size: 14px;">';
                a += '<div class="replyInfo'+value.re_no+'">'+'댓글번호 : ' + value.re_no + ' / 작성자 : ' + value.re_writer;
                
                if(mm_code == b){
                	a += '<div class="tkrwp"><a href="/replyDelete?re_no='+ value.re_no +'"> 삭제 </a> </div>';
                }
                
                a += '</div><div class="replyContent'+value.re_no+'"> <p> '+value.re_content +'</p> ';
                a += '</div></div>';
            });
            
            $(".replyList").html(a);
            
        }
    });
}
 
//댓글 등록
function replyInsert(insertData){
    $.ajax({
        url : '/replyInsert',
        type : 'post',
        data : insertData,
        success : function(data){
            if(data == 1) {
            	replyList(); //댓글 작성 후 댓글 목록 reload
                $('[name=re_content]').val('');
            }
        }
    });
}

 
//댓글 삭제 
function replyDelete(re_no){
    $.ajax({
        url : '/replyDelete'+re_no,
        type : 'post',
        success : function(data){
            if(data == 1) replyList(); //댓글 삭제후 목록 출력 
        }
    });
}
 
 
 
 
$(document).ready(function(){
	replyList(); //페이지 로딩시 댓글 목록 출력 
});
 
</script>