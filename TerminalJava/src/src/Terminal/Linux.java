package Terminal;

import GerenciaDiretorio.GerenciaDiretorio;

public class Linux extends Terminal {

        @Override
        public void cd(String caminho){

                if(caminho == null || caminho.isEmpty()){
                        return;
                }

                String dirAtual = GerenciaDiretorio.getDirAtual();

                if(caminho.equals("..")){

                }

        }

        @Override
        public void dir(){

        }

        @Override
        public void echo(){}

        @Override
        public void exit(){}

}

