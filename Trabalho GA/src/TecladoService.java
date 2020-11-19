import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TecladoService {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String entrada;

    public int leInt(String mensagem) {
        System.out.println(mensagem);
        int inteiro = 0;
        try {
            entrada = reader.readLine();
            inteiro = Integer.parseInt(entrada);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
        return inteiro;
    }

    public String leString(String mensagem) {
        System.out.println(mensagem);
        entrada = "";
        try {
            entrada = reader.readLine();
        } catch(IOException e) {
            System.out.println(e);
        }
        return entrada;
    }
}
