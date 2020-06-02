<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["이용빈도 낮음", ${dropoutInfo[1].dropoutCount}, "gold"],
        ["혜택 부족", ${dropoutInfo[3].dropoutCount}, "color: #e5e4e2"],
        ["회원간의 트러블", ${dropoutInfo[4].dropoutCount}, "#b87333"],
        ["변화가 없는 사이트", ${dropoutInfo[5].dropoutCount}, "silver"],
        ["기타", ${dropoutInfo[2].dropoutCount}, "color: #e5e4e2"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "회원 탈퇴 사유 비율",
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
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
		    <div id="barchart_values" style="width: 900px; height: 500px;"></div>
  		</td>
		</tr>
	</table>
	</div>
	</form>
  </body>
</html>
