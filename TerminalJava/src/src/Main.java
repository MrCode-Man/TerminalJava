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
                System.out.println("digite 'win like' para usar o terminal do windows");
                System.out.println("digite 'linux like' para usar o terminal do linux");

                while (true) {
                        tm.exibicao();


                        entrada = sc.nextLine().trim();

                        if(entrada.equals("win like")){
                                tm = new Windows();
                                System.out.println();
                                continue;

                        } else if(entrada.equals("linux like")){
                                tm = new Linux();
                                System.out.println();
                                continue;

                        } else if(entrada.equals("exit")){
                                System.out.println("Adeus... \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE2D");
                                sc.close();
                                return;
                        }


                        partes = Prompt.trataEntrada(entrada);

                        if (partes[0] == null || partes.length == 0){
                                continue;
                        }

                        String comando = partes[0];

                        switch (comando) {
                                case "cd":
                                        tm.cd(partes[1]);
                                        break;
                                case "rm":
                                        tm.rm(partes[1]);
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
                                default:
                                        System.out.println("Comando desconhecido: " + comando + '\n');
                                        break;
                        }
                }
        }
}