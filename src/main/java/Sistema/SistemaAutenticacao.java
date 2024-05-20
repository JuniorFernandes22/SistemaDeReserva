package Sistema;



import java.util.HashMap;
import java.util.Map;
import Modelo.Utilizador;
import Modelo.Cliente;
import Modelo.Funcionario;

public class SistemaAutenticacao {
    private Map<String, Utilizador> utilizadores;

    public SistemaAutenticacao() {
        this.utilizadores = new HashMap<>();
    }

    // Método para registrar um utilizador
    public void registrarUtilizador(Utilizador utilizador) {
        utilizadores.put(utilizador.getEmail(), utilizador);
    }

    // Método para autenticar um utilizador
    public Utilizador autenticar(String email, String senha) {
        Utilizador utilizador = utilizadores.get(email);
        if (utilizador != null && utilizador.getSenha().equals(senha)) {
            return utilizador;
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaAutenticacao sistema = new SistemaAutenticacao();

        // Registrando alguns utilizadores
        Cliente cliente = new Cliente("Elia Silva", "eliatita@example.com", "9565656", "senha123");
        Funcionario funcionario = new Funcionario("Nelson Oliveira", "netxon@example.com", "9876543", "senha456", "Recepcionista");

        sistema.registrarUtilizador(cliente);
        sistema.registrarUtilizador(funcionario);

        // Autenticando utilizadores
        Utilizador user1 = sistema.autenticar("joao@example.com", "senha123");
        if (user1 != null) {
            System.out.println("Autenticação bem-sucedida!");
            user1.exibirInformacoes();
        } else {
            System.out.println("Falha na autenticação.");
        }

        Utilizador user2 = sistema.autenticar("maria@example.com", "senha456");
        if (user2 != null) {
            System.out.println("Autenticação bem-sucedida!");
            user2.exibirInformacoes();
        } else {
            System.out.println("Falha na autenticação.");
        }
    }
}

