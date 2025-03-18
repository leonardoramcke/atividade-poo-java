// Classe base (superclasse)
class Animal {
    protected String nome;
    protected int idade;

    // Construtor
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método comum (polimorfismo - pode ser sobrescrito)
    public void fazerSom() {
        System.out.println(nome + " faz um som desconhecido.");
    }

    // Método para exibir informações gerais do animal
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + " anos");
    }
}

// Classe Cachorro (herda de Animal)
class Cachorro extends Animal {
    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println(nome + " late: Au Au!");
    }

    // Novo método específico da classe Cachorro
    public void buscarObjeto() {
        System.out.println(nome + " está buscando a bola!");
    }
}

// Classe Gato (herda de Animal)
class Gato extends Animal {
    public Gato(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println(nome + " mia: Miau!");
    }

    // Novo método específico da classe Gato
    public void escalar() {
        System.out.println(nome + " está escalando a prateleira!");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Animal meuAnimal = new Animal("Genérico", 3);
        Cachorro meuCachorro = new Cachorro("Rex", 5);
        Gato meuGato = new Gato("Whiskers", 2);

        // Testando métodos
        meuAnimal.fazerSom();
        meuAnimal.exibirInfo();

        System.out.println();
        
        meuCachorro.fazerSom();
        meuCachorro.exibirInfo();
        meuCachorro.buscarObjeto();

        System.out.println();
        
        meuGato.fazerSom();
        meuGato.exibirInfo();
        meuGato.escalar();
    }
}
