
public class Main {

	public static void main(String[] args) {
		Cliente luan = new Cliente();
		luan.setNome("Luan");

		Conta cc = new ContaCorrente(luan);
		Conta poupanca = new ContaPoupanca(luan);

		cc.depositar(100);
		cc.depositar(100);
		cc.depositar(100);
		cc.transferir(50, poupanca);
		cc.transferir(100, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
