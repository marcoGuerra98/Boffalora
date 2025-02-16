package com.example.Boffalora.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ANAGRAFICA")
public class Anagrafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "sesso")
    private String sesso;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;

    @Column(name = "nazione_nascita")
    private String nazioneNascita;

    @Column(name = "comune_nascita")
    private String comuneNascita;

    @Column(name = "nazione_residenza")
    private String nazioneResidenza;

    @Column(name = "comune_residenza")
    private String comuneResidenza;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private String cap;


    public Anagrafica(Long id, String nome, String cognome, String sesso, String codiceFiscale, Date dataNascita,
                      String nazioneNascita, String comuneNascita, String nazioneResidenza, String comuneResidenza,
                      String indirizzo, String cap) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
