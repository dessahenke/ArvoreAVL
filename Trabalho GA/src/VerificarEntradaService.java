import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class VerificarEntradaService {

    private final ArvoreService arvoreService;
    private final TecladoService tecladoService;
    private final ArvoreAVL arvoreAVL;

    VerificarEntradaService() {
        this.arvoreService = new ArvoreService();
        this.tecladoService = new TecladoService();
        this.arvoreAVL = new ArvoreAVL();
    }

    String verificar(String entrada) {
        switch (entrada) {
            case "1":
                System.out.println("Opção de busca por CPF selecionada!");
                arvoreService.preBuscarCPF(Teclado.leString("Digite o CPF que deseja buscar: "));
                break;
            case "2":
                System.out.println("Opção de busca por intervalo de data de nascimento selecionada!");
                String id = Teclado.leString("Data inicial do intervalo que deseja buscar: ");
                Date initialDate = arvoreService.transformToDate(id);
                String fd = Teclado.leString("Data final do intervalo que deseja buscar: ");
                Date finalDate = arvoreService.transformToDate(fd);
                arvoreService.preBuscaDataNascimento(initialDate, finalDate);
                break;
            case "3":
                System.out.println("Opção de busca por nome selecionada!");
                arvoreService.preBuscaNome(Teclado.leString("Digite o nome que deseja buscar: "));
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
