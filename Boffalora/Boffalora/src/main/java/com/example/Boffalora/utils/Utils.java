package com.example.Boffalora.utils;

import com.example.Boffalora.bean.AnagraficaBean;
import com.example.Boffalora.model.Anagrafica;

import java.util.Date;

public class Utils {

    public static Anagrafica anagraficaBeanToEntity(AnagraficaBean bean) {
        Anagrafica entity = new Anagrafica();
        if (bean != null) {
            String string;
            int Int;
            Date date;

            string = bean.getNome();
            if (string != null) {
                entity.setNome(string);
            }
            string = bean.getCognome();
            if (string != null) {
                entity.setCognome(string);
            }

            string = bean.getSesso();
            if (string != null) {
                entity.setSesso(string);
            }

            string = bean.getCodiceFiscale();
            if (string != null) {
                entity.setCodiceFiscale(string);
            }

            date = bean.getDataNascita();
            if (date != null) {
                entity.setDataNascita(date);
            }

            string = bean.getNazioneNascita();
            if (string != null) {
                entity.setNazioneNascita(string);
            }

            string = bean.getComuneNascita();
            if (string != null) {
                entity.setComuneNascita(string);
            }

            string = bean.getNazioneResidenza();
            if (string != null) {
                entity.setNazioneResidenza(string);
            }

            string = bean.getComuneResidenza();
            if (string != null) {
                entity.setComuneResidenza(string);
            }

            string = bean.getIndirizzo();
            if (string != null) {
                entity.setIndirizzo(string);
            }

            string = bean.getCap();
            if (string != null) {
                entity.setCap(string);
            }

        }
        return entity;
    }
}
