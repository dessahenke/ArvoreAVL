import java.util.ArrayList;

public class AppArvore {

    public static void main(String[] args) {
        ArvoreService arvoreService = new ArvoreService();
        ArrayList<String[]> listaPessoas = LeArquivo.leArquivo("dados.csv");


        for (String[] pessoa: listaPessoas) {
            arvoreService.inserirPessoa(pessoa);
        }

        VerificarEntradaService verificarEntradaService = new VerificarEntradaService();
        String entrada = "";

        while (!entrada.equals("s")) {
            System.out.println("\n" +
                    "1 - Buscar por CPF; \n" +
                    "2 - Buscar por intervalo de data de nascimento; \n" +
                    "3 - Buscar por nome; \n" +
                    "s - Sair;");
            entrada = verificarEntradaService.verificar(Teclado.leString("Escolha uma opção: "));
        }
    }
}
