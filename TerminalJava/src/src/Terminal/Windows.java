package Terminal;

import GerenciaArquivo.GerenciaArquivo;
import GerenciaDiretorio.GerenciaDiretorio;

import java.io.File;

public class Windows extends Terminal{

        @Override
        public void exibicao(){
                System.out.print(GerenciaDiretorio.getDirAtual() + "> ");
        }

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

                File atualDir = new File(GerenciaDiretorio.getDirAtual());
                File[] arquivos = atualDir.listFiles();

                for(File arquivo : arquivos){

                        if(arquivo.isFile()){
                                System.out.printf("\t  %s\n", arquivo.getName());

                        } else if(arquivo.isDirectory()){
                                System.out.println("<DIR> " + arquivo.getName());
                        }

                }

                System.out.println();
        }

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
                System.out.println(GerenciaDiretorio.getDirAtual() + '\n');
        }

}
