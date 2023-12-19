/**
* Laboratório de Programação 2 - Lab 1
*
* @author Alexandre Santos - 119210883
*/

import java.util.Scanner;

public class AlunoseNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maior = -1, menor = 1001;
        int soma = 0, alunos = 0, acima = 0;
        while (true) {
            String aluno = sc.nextLine();

            if (aluno.equals("-"))
                break;

            int nota = Integer.parseInt(aluno.split(" ")[1]);
            
            // Verifica se a nota do aluno
            // e menor ou maior da sala
            if (nota > maior)
                maior = nota;
            if (nota < menor)
                menor = nota;
            
            // Contabiliza notas acima de 700
            if (nota >= 700)
                acima++;
            
            // Quantidade de alunos e somatorio notas
            alunos++;
            soma += nota;
        } 
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + (soma / alunos));
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + (alunos - acima));
    }
}
