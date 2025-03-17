import Terminal.Linux;
import Terminal.Terminal;
import Terminal.Windows;
import Terminal.Prompt;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

                // inicialização
                Terminal tm = new Linux();
                Scanner sc = new Scanner(System.in);
                String[] partes;
                String entrada;

                // implementação

                tm.dir();
                System.out.println();

                tm.rm("mamae.txt");

                tm.dir();



        }
}