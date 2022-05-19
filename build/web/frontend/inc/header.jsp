<%@page import="Helper.Utils"%>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="<%= Utils.getBaseUrl(request) %>/frontend/asset/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= Utils.getBaseUrl(request) %>/frontend/asset/css/style.css?date=123456789" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="<%= Utils.getBaseUrl(request) %>/frontend/asset/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<link href="<%= Utils.getBaseUrl(request) %>/frontend/asset/css/main2.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="<%= Utils.getBaseUrl(request) %>/frontend/asset/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="<%= Utils.getBaseUrl(request) %>/frontend/asset/js/move-top.js"></script>
<script type="text/javascript" src="<%= Utils.getBaseUrl(request) %>/frontend/asset/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<!-- start-smoth-scrolling -->