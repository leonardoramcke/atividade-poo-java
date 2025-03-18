// Classe base (superclasse)
class Animal {
    String nome;

    // Construtor
    public Animal(String nome) {
        this.nome = nome;
    }

    // Método comum
    public void fazerSom() {
        System.out.println("O animal faz um som.");
    }
}

// Classe derivada (herança)
class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    // Polimorfismo (sobrescrita do método fazerSom)
    @Override
    public void fazerSom() {
        System.out.println(nome + " late: Au Au!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal meuAnimal = new Animal("Genérico");
        Cachorro meuCachorro = new Cachorro("Rex");

        meuAnimal.fazerSom();   // "O animal faz um som."
        meuCachorro.fazerSom(); // "Rex late: Au Au!"
    }
}
