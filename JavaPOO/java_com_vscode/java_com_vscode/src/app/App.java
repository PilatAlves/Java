package app;

import pacote1.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        int i = 10;
        i++;
        System.out.println("Hello, World!");
        System.out.println("The number is " + i);
        Pessoa p1 = new Pessoa();
        p1.cumprimentar();
    }
}
