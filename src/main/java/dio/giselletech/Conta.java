package dio.giselletech;


import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> observacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
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

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        if(!contaDestino.cliente.getCpf().equals(this.cliente.getCpf())) {
            contaDestino.depositar(valor);
            observacoes.add("Transferência entre CPFs diferentes.");
        } else {
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInformacoes() {
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF: %s", this.cliente.getCpf()));
        System.out.println(String.format("Contato: %s", this.cliente.getTelefone()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        if (!observacoes.isEmpty()) {
            System.out.println("Observações:");
            for (String mensagem : observacoes) {
                System.out.println("- " + mensagem);
            }
            System.out.println(" ");
        }

        System.out.println(" ");
    }

}
