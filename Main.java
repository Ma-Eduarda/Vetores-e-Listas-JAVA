import java.util.*;

/*
Example: ["1001,D,300", "1002,C,200","1001,D,300"]
Output : Balance -> -400
Output : Balance -> -100
*/


public class Main {
    public static void main(String[] args) {
        String[] arr = { "1001,D,300", "1002,C,200", "1001,D,300" };
        balance(arr);
    }

    public static void balance(String[] balances) {
        int total = 0; // Inicializa o saldo como 0

        for (String transacao : balances) { // Percorre cada transação no array
            String[] parts = transacao.split(","); // Divide a string em partes
            String type = parts[1]; // Pega D ou C
            int value = Integer.parseInt(parts[2]); // Converte o valor para número

            if (type.equals("D")) { // Se for D subtrai
                total -= value;
            } else { // Se for C
                total += value;
            }

            System.out.println("Balance -> " + total); 
        }
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = { "1001,D,300", "1002,C,200", "1001,D,300" };
        balance(arr);
    }

    public static void balance(String[] balances) {
        int total = 0;
        Map<String, Boolean> transacoesProcessadas = new HashMap<>();

        for (String transacao : balances) {
            if (transacoesProcessadas.containsKey(transacao)) {
                continue; // Ignora transação duplicada
            }

            transacoesProcessadas.put(transacao, true); // Registra a transação

            String[] parts = transacao.split(",");
            String type = parts[1];
            int value = Integer.parseInt(parts[2]);

            if (type.equals("D")) {
                total -= value;
            } else {
                total += value;
            }

            System.out.println("Balance -> " + total);
        }
    }
}
