public class App {
    public static void main(String[] args) throws Exception {
        
        int v1 = 10;
        int v2 = 0;
        char op = 'm';
        switch (op) {
            case 'a':
                System.out.format("Soma: %d%n", v1 + v2);
                break;
            case 's':
                System.out.format("Subtracao: %d%n", v1 - v2);
                break;
            case 'm':
                System.out.format("Mutiplicacao : %d%n", v1 * v2);
                break;
            case 'd':
                if (v2 != 0)
                    System.out.format("Divisao: %d%n", v1 / v2);
                else
                    System.out.format("Divisao por zero impossivel.");
                break;
            default:
                System.out.println("Operacao nao reconhecida");
        }
        
    }
}
