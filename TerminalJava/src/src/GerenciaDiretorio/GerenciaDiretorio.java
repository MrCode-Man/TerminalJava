package GerenciaDiretorio;

import java.io.File;

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

        public static String getDirAtual(){
                return dirAtual;
        }
}
