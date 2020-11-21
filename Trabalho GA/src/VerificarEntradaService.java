import java.util.Date;

class VerificarEntradaService {

    private final ArvoreService arvoreService;
    private final ArvoreAVL arvoreAVL;

    VerificarEntradaService() {
        this.arvoreService = new ArvoreService();
        this.arvoreAVL = new ArvoreAVL();
    }

    String verificar(String entrada) {
        switch (entrada) {
            case "1" -> {
                Teclado.mostraMensagem("Opção de busca por CPF selecionada!");
                arvoreService.preBuscarCPF(Teclado.leString("Digite o CPF que deseja buscar: "));
            }
            case "2" -> {
                Teclado.mostraMensagem("Opção de busca por intervalo de data de nascimento selecionada!");
                String id = Teclado.leString("Data inicial do intervalo que deseja buscar: ");
                Date initialDate = arvoreService.transformToDate(id);
                String fd = Teclado.leString("Data final do intervalo que deseja buscar: ");
                Date finalDate = arvoreService.transformToDate(fd);
                arvoreService.preBuscaDataNascimento(initialDate, finalDate);
            }
            case "3" -> {
                Teclado.mostraMensagem("Opção de busca por nome selecionada!");
                arvoreService.preBuscaNome(Teclado.leString("Digite o nome que deseja buscar: "));
            }
            case "s" -> Teclado.mostraMensagem("Encerrando programa!");
            default -> Teclado.mostraMensagem("Opção inválida!");
        }
        return entrada;
    }
}
