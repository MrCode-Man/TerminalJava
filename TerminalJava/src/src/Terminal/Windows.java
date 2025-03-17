package Terminal;

import GerenciaArquivo.GerenciaArquivo;
import GerenciaDiretorio.GerenciaDiretorio;

import java.io.File;

public class Windows extends Terminal{

        @Override
        public void exibicao(){}

        @Override
        public void cd(String caminho){}

        @Override
        public void rm(String caminho){}

        @Override
        public void dir(){}

        @Override
        public void echo(String texto, String arquivo){

                if(texto == null || texto.isEmpty()){
                        System.out.println("informe o texto\n");
                        return;
                }

                if(arquivo == null || arquivo.isEmpty()){
                        System.out.println(texto + '\n');
                        return;
                }


                File arq = new File(GerenciaDiretorio.getDirAtual(), arquivo);
                GerenciaArquivo.escreveArquivo(texto, arq.getAbsolutePath());

        }

        @Override
        public void cat(String caminho){}

        @Override
        public void touch(String caminho){}

        @Override
        public void mkdir(String caminho){}

        @Override
        public void pwd(){
                System.out.println(GerenciaDiretorio.getDirAtual());
        }

}
