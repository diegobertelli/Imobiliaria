package teste;

import java.sql.Date;

import sun.net.www.content.text.plain;
import modelo.Pessoa;
import modelo.PessoaFisica;
import modelo.TipoPessoaEnum;
import modelo.sexoEnum;
import controller.PessoaController;

public class PessoaTeste {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setNome("Tliner");
		pessoaFisica.setCpf("02552255");
		pessoaFisica.setEmail("tliner@hotmail.com");
		pessoaFisica.setDataNascimento(new Date(System.currentTimeMillis()));
		pessoaFisica.setRg("1561651651");
		pessoaFisica.setCpf("6546498");
		pessoaFisica.setTipoPessoa(TipoPessoaEnum.fisica.toString());
		pessoaFisica.setSexo(sexoEnum.masculino.toString());
		pessoaFisica.setTelefone("8854-5876");
		
		PessoaController pessoaController = new PessoaController();
		
		pessoaController.novoPessoa(pessoaFisica);
		

	}

}
