import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceDeskovek {
    public EvidenceDeskovek(){
        cteniZeSouboru();
    }
    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public List<Deskovka> getSeznamDeskovek() {
        return seznamDeskovek;
    }

    public void setSeznamDeskovek(List<Deskovka> seznamDeskovek) {
        this.seznamDeskovek = seznamDeskovek;
    }

    public Deskovka getDeskovka(int index){
        return seznamDeskovek.get(index);
    }

    public void cteniZeSouboru(){
        String text = "Deskovky.txt";
        try(
                FileReader fileReader = new FileReader(text);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Scanner scanner = new Scanner(bufferedReader);
                )
        {
            String radek;
            while (scanner.hasNextLine()){
                radek = scanner.nextLine();
                String[] pole = radek.split(";");
                String nazev = pole[0];
                boolean koupeno = Boolean.parseBoolean(pole[1]);
                int oblibenost = Integer.parseInt(pole[2]);
                seznamDeskovek.add(new Deskovka(nazev, koupeno, oblibenost));
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
