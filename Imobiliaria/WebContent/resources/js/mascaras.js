$a = jQuery.noConflict();
$a(document).ready(function() {
	$a("#data").mask("99/99/9999"); 
	$a("#telefone").mask("(99) 999-9999");
	$a("#cpf").mask("999-999-999.99");    
	$a("#cep").mask("99.999-999"); 
	$a("#cnpj").mask("99.999.999/9999-99"); 
});
