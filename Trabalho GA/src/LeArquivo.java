import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {
    public static void leArquivo(){
        String arquivoCSV = "dados.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ",";
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {

                String[] pessoa = linha.split(csvDivisor);

                System.out.println(pessoa[pessoa.length-2] + pessoa[pessoa.length-1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
