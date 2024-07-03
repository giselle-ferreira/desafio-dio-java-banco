package dio.giselletech;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Luke Skywalker", "12345678", "luke@email.com", "21999994444");
        Cliente cliente2 = new Cliente("Nora Reed", "82345671", "nora@email.com", "21929232345");

        Conta cSalario = new ContaSalario(cliente1);
        Conta cCorrente = new ContaCorrente(cliente1);
        Conta cPoupanca = new ContaPoupanca(cliente1);

        Conta cPoupancaCliente2 = new ContaPoupanca(cliente2);

        cSalario.depositar(4000);
        cSalario.transferir(cCorrente, 1000);

        cSalario.transferir(cPoupancaCliente2, 500);

        cSalario.imprimirExtrato();
        cCorrente.imprimirExtrato();
        cPoupanca.imprimirExtrato();

        cPoupancaCliente2.imprimirExtrato();
    }
}