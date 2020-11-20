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
                //System.out.println(lista[lista.length-2] + lista[lista.length-1]);
            }
            //System.out.println(lista.get(0)[0]);
            //return lista;

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
        return lista;
    }
}
