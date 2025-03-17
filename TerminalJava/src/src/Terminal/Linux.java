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


                int maxLength = 0;

                for (File file : arquivos) {
                        if (file.getName().length() > maxLength) {
                                maxLength = file.getName().length();
                        }
                }


                String format = "%-" + (maxLength + 2) + "s";

                for (int i = 0; i < arquivos.length; i++) {

                        if(arquivos[i].isFile())
                                System.out.printf("\033[34m" + format + "\033[0m", arquivos[i].getName());
                        else
                                System.out.printf("\033[35m" + format + "\033[0m", arquivos[i].getName());


                        if ((i + 1) % 3 == 0 || i == arquivos.length - 1) {
                                System.out.println();
                        }
                }

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
        public void exit(){}

}

