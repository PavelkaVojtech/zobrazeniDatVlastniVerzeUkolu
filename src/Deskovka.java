public class Deskovka {
    private String nazevDeskovky;
    private boolean koupeno;
    private int oblibenost;

    public Deskovka(String nazevDeskovky, boolean koupeno, int oblibenost) {
        this.nazevDeskovky = nazevDeskovky;
        this.koupeno = koupeno;
        this.oblibenost = oblibenost;
    }

    public String getNazevDeskovky() {
        return nazevDeskovky;
    }

    public void setNazevDeskovky(String nazevDeskovky) {
        this.nazevDeskovky = nazevDeskovky;
    }

    public boolean isKoupeno() {
        return koupeno;
    }

    public void setKoupeno(boolean koupeno) {
        this.koupeno = koupeno;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) {
        this.oblibenost = oblibenost;
    }
}
