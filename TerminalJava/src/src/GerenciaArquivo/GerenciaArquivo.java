package GerenciaArquivo;

import GerenciaDiretorio.GerenciaDiretorio;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

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

        public static void escreveArquivo(String texto, String caminho){

                File arquivo = new File(caminho);

                if(!arquivo.exists()){
                        System.out.println("arquivo passado não existe\n");
                        return;
                }

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
                        bw.write(texto);
                        bw.newLine();

                } catch(IOException e){
                        System.out.println(e.getMessage());
                }

        }

        public static void leArquivo(String caminho){

                File arquivo = new File(caminho);

                if(!arquivo.exists()){
                        System.out.println("arquivo passado não existe\n");
                        return;
                }

                try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
                        String linha;

                        while ((linha = br.readLine()) != null)
                                System.out.println(linha);

                } catch(IOException e){
                        System.out.println(e.getMessage() + '\n');
                }
        }

}
