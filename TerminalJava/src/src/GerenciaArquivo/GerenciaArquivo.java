package GerenciaArquivo;

import GerenciaDiretorio.GerenciaDiretorio;

import java.io.File;
import java.io.IOException;

public class GerenciaArquivo {

        public static void criaArquivo(String arq){

                File arquivo = new File(GerenciaDiretorio.getDirAtual(), arq);

                if(arquivo.exists()){
                        System.out.println("arquivo já existe\n");
                        return;
                }

                try{
                        if(arquivo.createNewFile()){
                                System.out.println("arquivo criado em: " + GerenciaDiretorio.getDirAtual());
                                return;
                        }

                } catch (IOException e){
                        System.out.println(e.getMessage());
                        return;
                }
        }

        public static void deletaArquivo(String arq){

                File arquivo = new File(arq);

                if(!arquivo.exists()){
                        System.out.println("arquivo não existe\n");
                        return;
                }

                if(!arquivo.delete())
                        System.out.println("não foi possível deletar arquivo\n");

        }


}
