
class VerificarEntradaService {

    private final ArvoreService arvoreService;
    private final TecladoService tecladoService;

    VerificarEntradaService() {
        this.arvoreService = new ArvoreService();
        this.tecladoService = new TecladoService();
    }

    String verificar(String entrada) {
        switch (entrada) {
            case "i":
                System.out.println("Opção de inserção selecionada!");
                arvoreService.preInserir(Teclado.leInt("Digite o valor a ser inserido: "));
                break;
            case "b":
                System.out.println("Opção de busca selecionada!");
                arvoreService.preBuscar(Teclado.leInt("Digite o valor que deseja buscar: "));
                break;
            case "r":
                System.out.println("Opção de remoção selecionada!");
                arvoreService.preRemover(Teclado.leInt("Digite o valor que deseja remover: "));
                break;
            case "1":
                arvoreService.imprimirInOrdem();
                break;
            case "2":
                arvoreService.imprimirPreOrdem();
                break;
            case "3":
                arvoreService.imprimirPosOrdem();
                break;
            case "s":
                System.out.println("Encerrando programa!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        return entrada;
    }
}
