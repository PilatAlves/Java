public class App {
    public static void main(String[] args) throws Exception {
       
        System.out.println("break");
        for (int i = 0; i < 10; i++){
            if (i == 5){
                break;
            }
            System.out.format("%d ",i);
        }
        System.out.println("\ncontiunue");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.format("%d,",i);
        }
       

    }
}
