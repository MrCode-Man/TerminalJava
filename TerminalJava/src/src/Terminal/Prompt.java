package Terminal;

public class Prompt {

        public static String[] trataEntrada(String entrada) {

                // tratando parte1
                if(entrada.trim().isEmpty()){
                        return new String[]{null, null, null};
                }

                int separacao = entrada.indexOf(" ");

                if(separacao == -1){
                        return new String[]{entrada.trim(), null, null};
                }

                String parte1 = entrada.substring(0, separacao).trim();


                // trandando parte2
                String novaParte = entrada.substring(separacao + 1).trim();

                int redirecionamento = novaParte.indexOf(">");

                if(redirecionamento == -1){
                        return new String[]{parte1, novaParte.trim(), null};
                }

                String parte2 = novaParte.substring(0, redirecionamento).trim();

                if(parte2.isEmpty()){
                        parte2 = null;
                }


                // tratando parte3
                String parte3 = novaParte.substring(redirecionamento + 1).trim();

                if(parte3.isEmpty()){
                        parte3 = null;
                }

                return new String[]{parte1, parte2, parte3};
        }
}
