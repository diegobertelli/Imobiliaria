$a = jQuery.noConflict();
$a(document).ready(function() {
	$a("#telefone").mask("(99) 999-9999");
	$a("#cpf").mask("999-999-999.99");
	$a("#cep").mask("99999-999");
	$a("#cnpj").mask("99.999.999/9999-99");  
	$a('#rg').mask('99.999.999-9');
	$a('#quarto').spinner({min: 0,max: 10,start: 0});
	$a('#sala').spinner({min: 0,max: 10,start: 0});
	$a('#banheiro').spinner({min: 0,max: 10,start: 0});
	$a('#garagem').spinner({min: 0,max: 10,start: 0});
});

$b = jQuery.noConflict();
$b(document).ready(function() {
	$b("#data").datepicker({
		dateFormat: 'dd/mm/yy',
		dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
		dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro', 'Novembro','Dezembro'],
		monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	});        
});

$c = jQuery.noConflict();
$c(document).ready(function() {
	$c("#valorImovel").maskMoney({
		symbol:'R$ ',
		showSymbol:true,
		thousands:'.',
		decimal:',',
		symbolStay: true
	});    
	$c("#valorIPTU").maskMoney({
		symbol:'R$ ',
		showSymbol:true,
		thousands:'.',
		decimal:',',
		symbolStay: true
	});
	$c("#renda").maskMoney({
		symbol:'R$ ',
		showSymbol:true,
		thousands:'.',
		decimal:',',
		symbolStay: true
	});
});

                                        




