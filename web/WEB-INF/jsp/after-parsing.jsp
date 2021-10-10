<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta name="page_type" content="np-template-header-footer-from-plugin">
	<title>after parsing</title>
	<link rel="stylesheet" href="../../css/nicepage.css" media="screen">
	<link rel="stylesheet" href="../../css/after-parsing.css" media="screen">
	<script class="u-script" type="text/javascript" src="../../js/jquery.js" defer=""></script>
	<script class="u-script" type="text/javascript" src="../../js/nicepage.js" defer=""></script>
	<meta name="generator" content="Nicepage 3.27.0, nicepage.com">
	<link id="u-theme-google-font" rel="stylesheet"
	      href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
	
	
	<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
	}</script>
	<meta name="theme-color" content="#478ac9">
	<meta property="og:title" content="after parsing">
	<meta property="og:type" content="website">
</head>
<body class="u-body">
<header class="u-clearfix u-header u-header" id="sec-73d9">
	<div class="u-clearfix u-sheet u-sheet-1">
		<p class="u-text u-text-default u-text-1">Java Web Development Course from EPAM - Task 2</p>
	</div>
</header>
<section class="u-clearfix u-section-1" id="sec-b2b0">
	<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
		<p class="u-align-left u-text u-text-1">&nbsp; Создать программу обработки фрагмента
			текста учебника по программированию с использованием элементов, например:
			Символ, Слово, Предложение, Текст, Абзац, Листинг, Лексема, Знак препинания и
			др.
			Приложение должно осуществлять
			разбор текста на элементы с обязательной возможностью восстановления текста в
			исходном виде.
			Можно использовать шаблон Composite.
			Во всех задачах с формированием
			текста разрешено заменять табуляции и последовательности пробелов одним пробелом.
			Для демонстрации работы приложения использовать unit тесты.
			Использовать logging.
			Использовать библиотеки сборки.</p>
	</div>
</section>
<section class="u-clearfix u-grey-25 u-section-2" id="sec-b717">
	<div class="u-clearfix u-sheet u-sheet-1">
		<form method="POST" action="${pageContext.request.contextPath}/Controller">
			<input type="hidden" name="command" value="SHOW_ELEMENTS_DETECTED_WHILE_PARSING"/>
			<input class="u-btn u-button-style u-hover-palette-1-dark-1 u-palette-1-base u-btn-1" type="submit"
			       value="1. Show Elements Detected While Parsing"/>
		</form>
		<form method="POST" action="${pageContext.request.contextPath}/Controller">
			<input type="hidden" name="command" value="SHOW_CONTENT_OF_DOWNLOADED_FILE"/>
			<input class="u-btn u-button-style u-hover-palette-1-dark-1 u-palette-1-base u-btn-2" type="submit"
			       value="2. Show Content Of Downloaded File"/>
		</form>
		<form method="POST" action="${pageContext.request.contextPath}/Controller">
			<input type="hidden" name="command" value="SHOW_PARSED_TEXT"/>
			<input class="u-btn u-button-style u-hover-palette-1-dark-1 u-palette-1-base u-btn-3" type="submit"
			       value="3. Show Parsed Text"/>
		</form>
	</div>
</section>


<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-dfcf">
	<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
		<p class="u-small-text u-text u-text-variant u-text-1">Copyright &copy; 2021 Igor Taren - All Rights
			Reserved.</p>
	</div>
</footer>
</body>
</html>