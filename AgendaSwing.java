import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaSwing extends JFrame {
    private Agenda agenda;
    private JTextArea displayArea;
    private JTextField nomeField, telefoneField, emailField;

    public AgendaSwing() {
        agenda = new Agenda();
        setTitle("Agenda de Contatos");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        nomeField = new JTextField(15);
        telefoneField = new JTextField(15);
        emailField = new JTextField(15);

        JButton addButton = new JButton("Adicionar");
        JButton listButton = new JButton("Listar");
        JButton editButton = new JButton("Editar");
        JButton removeButton = new JButton("Remover");

        addButton.addActionListener(e -> adicionarContato());
        listButton.addActionListener(e -> listarContatos());
        editButton.addActionListener(e -> editarContato());
        removeButton.addActionListener(e -> removerContato());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Telefone:"));
        inputPanel.add(telefoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(addButton);
        inputPanel.add(listButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(editButton);
        buttonsPanel.add(removeButton);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        
        add(inputPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private void adicionarContato() {
        String nome = nomeField.getText();
        String telefone = telefoneField.getText();
        String email = emailField.getText();
        agenda.adicionarContato(new Contato(nome, telefone, email));
        limparCampos();
        listarContatos();
    }

    private void listarContatos() {
        displayArea.setText("");
        for (Contato contato : agenda.getContatos()) {
            displayArea.append(contato.toString() + "\n");
        }
    }

    private void editarContato() {
        String nome = JOptionPane.showInputDialog("Novo Nome:");
        String telefone = JOptionPane.showInputDialog("Novo Telefone:");
        String email = JOptionPane.showInputDialog("Novo Email:");
        int index = Integer.parseInt(JOptionPane.showInputDialog("Índice do contato a editar:"));
        agenda.editarContato(index, nome, telefone, email);
        listarContatos();
    }

    private void removerContato() {
        int index = Integer.parseInt(JOptionPane.showInputDialog("Índice do contato a remover:"));
        agenda.removerContato(index);
        listarContatos();
    }

    private void limparCampos() {
        nomeField.setText("");
        telefoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgendaSwing agendaSwing = new AgendaSwing();
            agendaSwing.setVisible(true);
        });
    }
}
