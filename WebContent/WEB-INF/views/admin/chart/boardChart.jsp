<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['board', 'percentage'],
          ['게시판',  ${boardInfo[0].board}],
          ['이미지게시판', ${imageboardInfo[0].image}],
          ['QnA', ${qandaInfo[0].qanda}],
          ['자료실', ${referenceInfo[0].reference}],
          ['공지사항', ${noticeInfo[0].notice}]
        ]);
        
        var options = {
          title: '게시판 게시글 비율'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
  	<form class="form-horizontal" role="form" action="" method="post" >
	<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="180"><jsp:include page="chartMenu.jsp"></jsp:include></td>
			<td width="30">&nbsp;</td>
			<td width="790"> 
		    <div id="piechart" style="width: 900px; height: 500px;"></div>
  		</td>
		</tr>
	</table>
	</div>
	</form>
  </body>
</html>
