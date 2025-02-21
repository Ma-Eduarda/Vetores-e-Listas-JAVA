import java.util.*;

public class BaseballGame {
    public static int calcularPontos(String[] ops) {
        Stack<Integer> pilha = new Stack<>(); // Pilha para armazenar os valores

        for (String op : ops) {
            switch (op) {
                case "C":  // Remover a última pontuação
                    if (!pilha.isEmpty()) {
                        pilha.pop();
                    }
                    break;
                case "D":  // Dobrar a última pontuação
                    if (!pilha.isEmpty()) {
                        pilha.push(pilha.peek() * 2);
                    }
                    break;
                case "+":  // Somar os dois últimos valores
                    if (pilha.size() >= 2) {
                        int ultimo = pilha.pop();
                        int novoValor = ultimo + pilha.peek();
                        pilha.push(ultimo);
                        pilha.push(novoValor);
                    }
                    break;
                default:  // Se for um número, converte e adiciona na pilha
                    pilha.push(Integer.parseInt(op));
            }
        }

        // Soma os valores armazenados na pilha
        int soma = 0;
        for (int num : pilha) {
            soma += num;
        }

        return soma;
    }

    public static void main(String[] args) {

        /* 
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite as operações separadas por espaço:");
        String[] ops = sc.nextLine().split(" "); // Lê a entrada e divide em um array

        System.out.println("Resultado: " + calcularPontos(ops));

        sc.close();
        */

        //String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        String[] ops = {"5", "2", "C", "D", "+"};

        // Chamando a função e imprimindo o resultado
        int resultado = calcularPontos(ops);
        System.out.println("Resultado: " + resultado);


    }
}