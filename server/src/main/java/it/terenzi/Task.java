package it.terenzi;

public class Task {
    static int id=0;
    String macchina;
    Priority prior;
    Stato stato;
    String descrizione;
    String autore;

    enum Priority { BASSA, MEDIA, ALTA }
    enum Stato { TODO, DOING, DONE }

    public Task(String m,Priority p,Stato s,String desc,String autor){
        macchina = m;
        prior =p;
        stato=s;
        descrizione = desc;
        autore=autor; 
        id++;

    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Task.id = id;
    }

    public String getMacchina() {
        return macchina;
    }

    public void setMacchina(String macchina) {
        this.macchina = macchina;
    }

    public Priority getPrior() {
        return prior;
    }

    public void setPrior(Priority prior) {
        this.prior = prior;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    
}
