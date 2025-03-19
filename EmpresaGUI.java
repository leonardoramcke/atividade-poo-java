import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Classe base
class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getTipo() {
        return "Funcionário";
    }

    public double calcularBonus() {
        return 0; // Funcionário comum não tem bônus
    }
}

// Classe derivada: Gerente
class Gerente extends Funcionario {
    private double bonusExtra;

    public Gerente(String nome, double salario, double bonusExtra) {
        super(nome, salario);
        this.bonusExtra = bonusExtra;
    }

    @Override
    public String getTipo() {
        return "Gerente";
    }

    @Override
    public double calcularBonus() {
        // Bônus do gerente é exatamente o valor inserido (bonusExtra)
        return bonusExtra;
    }
}

// Classe derivada: Desenvolvedor
class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public String getTipo() {
        return "Desenvolvedor";
    }

    @Override
    public double calcularBonus() {
        // Bônus de 15% do salário para desenvolvedores
        return salario * 0.15;
    }
}

// Classe principal com interface gráfica melhorada
public class EmpresaGUI {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static DefaultTableModel model;

    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Resultados da Empresa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Criando um painel principal com borda e layout
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        // Título da interface
        JLabel titulo = new JLabel("Resultados dos Funcionários", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Criando uma tabela para exibir os dados
        String[] colunas = {"Nome", "Tipo", "Salário", "Bônus"};
        model = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(model);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(25);

        // Adicionando a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        // Botão para adicionar Gerente
        JButton botaoGerente = new JButton("Adicionar Gerente");
        botaoGerente.setFont(new Font("Arial", Font.BOLD, 14));
        botaoGerente.addActionListener(e -> adicionarGerente());

        // Botão para adicionar Desenvolvedor
        JButton botaoDesenvolvedor = new JButton("Adicionar Desenvolvedor");
        botaoDesenvolvedor.setFont(new Font("Arial", Font.BOLD, 14));
        botaoDesenvolvedor.addActionListener(e -> adicionarDesenvolvedor());

        // Botão para adicionar Funcionário Comum
        JButton botaoFuncionario = new JButton("Adicionar Funcionário");
        botaoFuncionario.setFont(new Font("Arial", Font.BOLD, 14));
        botaoFuncionario.addActionListener(e -> adicionarFuncionarioComum());

        // Adicionando os botões ao painel
        painelBotoes.add(botaoGerente);
        painelBotoes.add(botaoDesenvolvedor);
        painelBotoes.add(botaoFuncionario);
        panel.add(painelBotoes, BorderLayout.SOUTH);

        // Adicionando o painel principal à janela
        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para adicionar um Gerente
    private static void adicionarGerente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do gerente:");
        String salarioStr = JOptionPane.showInputDialog("Digite o salário do gerente:");
        String bonusExtraStr = JOptionPane.showInputDialog("Digite o bônus extra do gerente:");

        try {
            double salario = Double.parseDouble(salarioStr);
            double bonusExtra = Double.parseDouble(bonusExtraStr);
            Funcionario gerente = new Gerente(nome, salario, bonusExtra);

            // Adicionando o gerente à lista e à tabela
            funcionarios.add(gerente);
            model.addRow(new Object[]{
                gerente.getNome(),
                gerente.getTipo(),
                gerente.getSalario(),
                gerente.calcularBonus()
            });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números corretamente.");
        }
    }

    // Método para adicionar um Desenvolvedor
    private static void adicionarDesenvolvedor() {
        String nome = JOptionPane.showInputDialog("Digite o nome do desenvolvedor:");
        String salarioStr = JOptionPane.showInputDialog("Digite o salário do desenvolvedor:");

        try {
            double salario = Double.parseDouble(salarioStr);
            Funcionario desenvolvedor = new Desenvolvedor(nome, salario);

            // Adicionando o desenvolvedor à lista e à tabela
            funcionarios.add(desenvolvedor);
            model.addRow(new Object[]{
                desenvolvedor.getNome(),
                desenvolvedor.getTipo(),
                desenvolvedor.getSalario(),
                desenvolvedor.calcularBonus()
            });

            // Mensagem informando o bônus de 15%
            JOptionPane.showMessageDialog(null, "Desenvolvedor adicionado com sucesso!\nBônus: 15% do salário.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números corretamente.");
        }
    }

    // Método para adicionar um Funcionário Comum
    private static void adicionarFuncionarioComum() {
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
        String salarioStr = JOptionPane.showInputDialog("Digite o salário do funcionário:");

        try {
            double salario = Double.parseDouble(salarioStr);
            Funcionario funcionario = new Funcionario(nome, salario);

            // Adicionando o funcionário à lista e à tabela
            funcionarios.add(funcionario);
            model.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getTipo(),
                funcionario.getSalario(),
                funcionario.calcularBonus()
            });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números corretamente.");
        }
    }
}
