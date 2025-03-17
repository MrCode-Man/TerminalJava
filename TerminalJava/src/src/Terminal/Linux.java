package Terminal;

import GerenciaArquivo.GerenciaArquivo;
import GerenciaDiretorio.GerenciaDiretorio;

import java.io.File;

public class Linux extends Terminal {

        @Override
        public void cd(String caminho){

                if(caminho == null || caminho.isEmpty()){
                        return;
                }

                String dirAtual = GerenciaDiretorio.getDirAtual();

                if(caminho.equals("..")){
                        File pai = new File(dirAtual);

                        GerenciaDiretorio.mudaDiretorio(pai.getParent());
                        return;
                }

                GerenciaDiretorio.mudaDiretorio(caminho);
        }

        @Override
        public void rm(String caminho){

                if(caminho == null || caminho.isEmpty()){
                        System.out.println("nenhum arquivo ou diretório passado\n");
                        return;
                }

                File file = new File(GerenciaDiretorio.getDirAtual(), caminho);

                if(!file.exists()){
                        System.out.println("diretório ou arquivo não existe\n");
                        return;
                }

                if(file.isFile()){
                        GerenciaArquivo.deletaArquivo(file.getAbsolutePath());

                } else if(file.isDirectory()){
                        GerenciaDiretorio.deletaDiretorio(file.getAbsolutePath());
                }


        }

        @Override
        public void dir(){

                File arquivo = new File(GerenciaDiretorio.getDirAtual());
                File[] arquivos = arquivo.listFiles();

                for(File arq : arquivos){
                        System.out.println("arquivo: " + arq.getName());
                }

        }

        @Override
        public void echo(){}

        @Override
        public void exit(){}

}

