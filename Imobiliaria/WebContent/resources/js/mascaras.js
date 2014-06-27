jQuery(function($) {
	try {
		$(".data").mask("99/99/9999");
	} catch (err) {

	}

	try {
		$(".telefone").mask("(999) 999-9999");
	} catch (err) {

	}

	try {

		$(".cpf").mask("999-999-999.99");
	} catch (err) {

	}

});
