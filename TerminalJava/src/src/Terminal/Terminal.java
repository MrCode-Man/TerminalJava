package Terminal;

public abstract class Terminal {

        public abstract void exibicao();
        public abstract void cd(String caminho);
        public abstract void rm(String caminho);
        public abstract void dir();
        public abstract void echo(String texto, String arquivo);
        public abstract void cat(String arquivo);
        public abstract void touch(String arquivo);
        public abstract void mkdir(String diretorio);
        public abstract void pwd();

}
