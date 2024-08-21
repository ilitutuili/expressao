import java.util.Scanner;
import java.util.Stack;

public class verificarexpressao{

    public static boolean verificaExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.isEmpty()) {
                    return false;
                }
                char topo = pilha.pop();
                if (!correspondem(topo, c)) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }

    private static boolean correspondem(char abre, char fecha) {
        return (abre == '(' && fecha == ')') ||
               (abre == '[' && fecha == ']') ||
               (abre == '{' && fecha == '}');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão para verificar:");
        String expressao = scanner.nextLine();

        if (verificaExpressao(expressao)) {
            System.out.println("Expressão correta!");
        } else {
            System.out.println("Expressão incorreta!");
        }

        scanner.close();
    }
}
