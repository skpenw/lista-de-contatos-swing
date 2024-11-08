import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            contatos.forEach(contato -> System.out.println(contato));
        }
    }

    public void editarContato(int index, String nome, String telefone, String email) {
        if (index >= 0 && index < contatos.size()) {
            Contato contato = contatos.get(index);
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setEmail(email);
            System.out.println("Contato editado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerContato(int index) {
        if (index >= 0 && index < contatos.size()) {
            contatos.remove(index);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
