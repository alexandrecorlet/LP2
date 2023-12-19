import java.util.Scanner;

import java.util.Scanner;

public class LendoDados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();
        System.out.println("Digite a sua idade:");
        int idade = sc.nextInt();
        int tam = nome.length();
        System.out.println(nome + " - " + idade);
    }
}
