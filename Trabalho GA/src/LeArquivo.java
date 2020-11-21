import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeArquivo {
    public static ArrayList<String[]> leArquivo(String arquivoCSV){
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        ArrayList<String[]> lista = new ArrayList<String[]>();
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {
                String[] linhaLimpa = linha.split(csvDivisor);
                lista.add(linhaLimpa);
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
        lista.remove(0);
        return lista;
    }
}
