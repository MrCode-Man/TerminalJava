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
                while (true) {
                        tm.exibicao();

                        entrada = sc.nextLine().trim();
                        partes  = Prompt.trataEntrada(entrada);

                        if (partes[0] == null || partes.length == 0){
                                continue;
                        }

                        String comando   = partes[0];

                        switch (comando) {
                                case "cd":
                                        tm.cd(partes[1]);
                                        break;
                                case "rm":
                                        break;
                                case "dir":
                                        tm.dir();
                                        break;
                                case "echo":
                                        tm.echo(partes[1], partes[2]);
                                        break;
                                case "cat":
                                        tm.cat(partes[1]);
                                        break;
                                case "touch":
                                        tm.touch(partes[1]);
                                        break;
                                case "mkdir":
                                        tm.mkdir(partes[1]);
                                        break;
                                case "pwd":
                                        tm.pwd();
                                        break;
                                case "exit":
                                        System.out.println("Saindo...");
                                        sc.close();
                                        return;
                                default:
                                        System.out.println("Comando desconhecido: " + comando);
                                        break;
                        }
                }

        }
}