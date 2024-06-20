import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<String> historico;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.historico = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		registrarTransacao("Saque de R$" + valor);
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		registrarTransacao("Depósito de R$" + valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		registrarTransacao("Transferência de R$" + valor + " para conta " + contaDestino.getNumero());
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<String> getHistorico() {
		return historico;
	}

	protected void registrarTransacao(String descricao) {
		historico.add(descricao);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("Histórico de Transações:");
		for (String transacao : historico) {
			System.out.println("- " + transacao);
		}
	}
}
