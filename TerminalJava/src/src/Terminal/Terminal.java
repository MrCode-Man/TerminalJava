package Terminal;

public abstract class Terminal {

        public abstract void cd(String caminho);
        public abstract void rm(String caminho);
        public abstract void dir();
        public abstract void echo(String texto, String arquivo);
        public abstract void exit();

}
