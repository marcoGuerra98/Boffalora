package com.example.Boffalora.bean;

import java.util.Date;

public class AnagraficaBean {

    private String nome;
    private String cognome;
    private String sesso;
    private String codiceFiscale;
    private Date dataNascita;
    private String nazioneNascita;
    private String comuneNascita;
    private String nazioneResidenza;
    private String comuneResidenza;
    private String indirizzo;
    private String cap;

    public AnagraficaBean(String nome, String cognome, String sesso, String codiceFiscale, Date dataNascita,
                          String nazioneNascita, String comuneNascita, String nazioneResidenza, String comuneResidenza,
                          String indirizzo, String cap) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
        this.nazioneNascita = nazioneNascita;
        this.comuneNascita = comuneNascita;
        this.nazioneResidenza = nazioneResidenza;
        this.comuneResidenza = comuneResidenza;
        this.indirizzo = indirizzo;
        this.cap = cap;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNazioneNascita() {
        return nazioneNascita;
    }

    public void setNazioneNascita(String nazioneNascita) {
        this.nazioneNascita = nazioneNascita;
    }

    public String getComuneNascita() {
        return comuneNascita;
    }

    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getNazioneResidenza() {
        return nazioneResidenza;
    }

    public void setNazioneResidenza(String nazioneResidenza) {
        this.nazioneResidenza = nazioneResidenza;
    }

    public String getComuneResidenza() {
        return comuneResidenza;
    }

    public void setComuneResidenza(String comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }
}
