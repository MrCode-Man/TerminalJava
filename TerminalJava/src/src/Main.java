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

                // entrada = sc.nextLine();
                // partes = Prompt.trataEntrada(entrada);


                tm.cd("..");
                tm.dir();
                System.out.println();

                tm.rm("vazio diretório");
                tm.dir();

        }
}