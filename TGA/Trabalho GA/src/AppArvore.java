public class AppArvore {

    public static void main(String[] args) {

        VerificarEntradaService verificarEntradaService = new VerificarEntradaService();
        String entrada = "";

        while (!entrada.equals("s")) {
            System.out.println("\n" +
                    "i - Inserir; \n" +
                    "b - Buscar; \n" +
                    "r - Remover; \n" +
                    "1 - Em-Ordem; \n" +
                    "2 - Pré-Ordem; \n" +
                    "3 - Pós-Ordem; \n" +
                    "s - Sair;");
            entrada = verificarEntradaService.verificar(Teclado.leString("Escolha uma opção: "));
        }
    }
}
