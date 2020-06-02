<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
    	var data = google.visualization.arrayToDataTable([
			['가입경로', 'Visitations', { role: 'style' } ],
    	    ['인터넷 검색', ${joinInfo[0].joinCount}, 'stroke-color: #3a6343; stroke-width: 4; fill-color: #82b09f'],
    	    ['카페/블로그', ${joinInfo[3].joinCount}, 'stroke-color: #eb81b2;  stroke-width: 4; fill-color: #f0d5da'],
    	    ['인터넷 뉴스/기사', ${joinInfo[4].joinCount}, 'stroke-color: gray; stroke-width: 4; fill-color: #d4d6d6'],
    	    ['SNS', ${joinInfo[5].joinCount}, 'stroke-color: #703593; stroke-width: 4; fill-color: #C5A5CF'],
    	    ['지인소개', ${joinInfo[6].joinCount}, 'stroke-color: #071063;  stroke-width: 4; fill-color: #9da5f5'],
    	    ['기타', ${joinInfo[2].joinCount}, 'stroke-color: #f0ce46;  stroke-width: 4; fill-color: #ede3bb']
    	]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "가입 경로 비율",
        width: 800,
        height: 400,
        bar: {groupWidth: "80%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
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
		    <div id="columnchart_values" style="width: 900px; height: 500px;"></div>
  		</td>
		</tr>
	</table>
	</div>
	</form>
  </body>
</html>
