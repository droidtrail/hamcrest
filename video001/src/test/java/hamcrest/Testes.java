package hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class Testes {

	// Criando contas
	Conta contaKarine;
	Conta contaKarla;

	// Inicializando as contas criadas
	@Before
	public void setup() {

		contaKarine = new Conta("Karina Gomes", 1234, 50.00);
		contaKarla = new Conta("Karla Silva", 12345, 1500.00);

	}
	
	@Test
	public void creditarValor() {
		this.contaKarine.creditar(100);
		assertThat("Saldo da conta correto", contaKarine.getSaldo(),equalTo(150.00));
	}
	
	@Test
	public void debitarValor() throws OperacaoIlegalException {
		this.contaKarine.debitar(30.00);
		assertThat("Saldo da conta incorreto", contaKarine.getSaldo(),equalTo(20.00));
	}
	
	@Test
	public void encontrarClienteRico() {
		assertThat("O cliente não possui mais de 1000 no nosso banco", contaKarla.getSaldo(),greaterThan(1000.00));
	}

}
