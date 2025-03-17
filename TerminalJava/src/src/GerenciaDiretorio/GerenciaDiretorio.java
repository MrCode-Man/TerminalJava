package GerenciaDiretorio;

import java.io.File;
import java.io.IOException;

public class GerenciaDiretorio {

        private static String dirAtual = System.getProperty("user.dir");


        public static boolean mudaDiretorio(String caminho){

                File diretorioNovo = new File(caminho);

                if(!diretorioNovo.isAbsolute()){
                        diretorioNovo = new File(dirAtual, caminho);
                }

                if(!diretorioNovo.exists()){
                        System.out.println("diretório não existe\n");
                        return false;
                }

                if(!diretorioNovo.isDirectory()){
                        System.out.println("não é um diretório\n");
                        return false;
                }

                dirAtual = diretorioNovo.getAbsolutePath();

                return true;
        }

        public static void deletaDiretorio(String caminho){

                File diretorio = new File(caminho);

                if(!diretorio.exists()){
                        System.out.println("diretório não existe\n");
                        return;
                }

                if(!diretorio.delete())
                        System.out.println("não foi possível deletar o diretório\n");

        }

        public static void criaDiretório(String caminho){

                File diretorio = new File(caminho);

                if(diretorio.exists()){
                        System.out.println("diretório já existe\n");
                        return;
                }

                if(!diretorio.mkdir())
                        System.out.println("erro ao criar o(s) diretório(s)\n");

        }

        public static String getDirAtual(){
                return dirAtual;
        }
}
