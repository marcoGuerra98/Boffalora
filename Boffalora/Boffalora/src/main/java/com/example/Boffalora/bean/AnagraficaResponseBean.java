package com.example.Boffalora.bean;

public class AnagraficaResponseBean {

    private String messaggio;
    private String errore;

    public AnagraficaResponseBean(String messaggio, String errore) {
        this.messaggio = messaggio;
        this.errore = errore;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getErrore() {
        return errore;
    }

    public void setErrore(String errore) {
        this.errore = errore;
    }
}
