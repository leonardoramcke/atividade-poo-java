💻 Atividade de POO em Java

Este repositório contém um exemplo prático de Programação Orientada a Objetos (POO) em Java, demonstrando herança e polimorfismo. O projeto simula uma empresa com diferentes tipos de funcionários (Funcionário Comum, Gerente e Desenvolvedor), cada um com suas próprias características e cálculos de bônus.

📝 Sobre o código

📌 Classes:
- **Funcionario** (Superclasse) → Contém atributos `nome` e `salario`, além do método `calcularBonus()`.
- **Gerente** (Subclasse) → Herda de `Funcionario`, sobrescreve `calcularBonus()` e adiciona `bonusExtra`.
- **Desenvolvedor** (Subclasse) → Herda de `Funcionario`, sobrescreve `calcularBonus()` com um bônus de 15% do salário.
- **EmpresaGUI** → Classe principal que implementa a interface gráfica para adicionar e visualizar funcionários.

🚀 Como executar

Antes de começar, você precisará de alguns programas instalados no seu computador:

Java Development Kit (JDK): Para compilar e executar código Java.

Download: JDK da Oracle ou OpenJDK.

Instale o JDK seguindo as instruções do site.

Git (opcional, mas recomendado): Para clonar o repositório.

Download: Git.

Instale o Git seguindo as instruções do site.

Terminal/Command Prompt: Para executar comandos.

No Windows, use o Command Prompt ou PowerShell.

No macOS/Linux/Windows, use o Terminal.
1️⃣ Clone o repositório: git clone https://github.com/leonardoramcke/atividade-poo-java.git  
após clonar digite: cd atividade-poo-java

2️⃣ Compile o código: javac EmpresaGUI.java

3️⃣ Execute o programa: java EmpresaGUI

🛠️ Tecnologias utilizadas

Java

Paradigma Orientado a Objetos (POO)

Swing (para a interface gráfica)

📌 Autor
👤 Leonardo Ramcke
