<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="windows-1250">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta name="page_type" content="np-template-header-footer-from-plugin">
	<title>Home</title>
	<link rel="stylesheet" href="css/nicepage.css" media="screen">
	<link rel="stylesheet" href="css/Home.css" media="screen">
	<script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
	<script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
	<meta name="generator" content="Nicepage 3.27.0, nicepage.com">
	<link id="u-theme-google-font" rel="stylesheet"
	      href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
	
	
	<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
	}</script>
	<meta name="theme-color" content="#478ac9">
	<meta property="og:title" content="Home">
	<meta property="og:type" content="website">
</head>
<body data-home-page="Home.html" data-home-page-title="Home" class="u-body">
<header class="u-clearfix u-header u-header" id="sec-73d9">
	<div class="u-clearfix u-sheet u-sheet-1">
		<p class="u-text u-text-default u-text-1">Java Web Development Course from EPAM - Task 2</p>
	</div>
</header>
<section class="u-clearfix u-section-1" id="sec-b2b0">
	<div class="u-clearfix u-sheet u-sheet-1">
		<p class="u-text u-text-default u-text-1">&nbsp; Создать программу обработки фрагмента
			текста учебника по программированию с использованием элементов, например: Символ,
			Слово, Предложение, Текст, Абзац, Листинг, Лексема, Знак препинания и др.
			Приложение должно осуществлять разбор текста на элементы с обязательной возможностью
			восстановления текста в исходном виде. Можно использовать шаблон Composite.
			Во всех задачах с формированием текста разрешено заменять табуляции и последовательности
			пробелов одним пробелом.
			Для демонстрации работы приложения использовать unit тесты.
			Использовать logging.
			Использовать библиотеки сборки.
		</p>
		<br>
		<form method="POST" action="${pageContext.request.contextPath}/Controller" enctype="multipart/form-data" >
			<input type="hidden" name="command" value="parse111"/>
			<input type="file" name="file"/><br/>
			<input type="submit" value="Parse"/>
		</form>
	</div>
</section>


<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-dfcf">
	<div class="u-clearfix u-sheet u-sheet-1">
		<p class="u-small-text u-text u-text-variant u-text-1">Copyright &copy; 2021 Igor Taren - All Rights Reserved.</p>
	</div>
</footer>
</body>
</html>