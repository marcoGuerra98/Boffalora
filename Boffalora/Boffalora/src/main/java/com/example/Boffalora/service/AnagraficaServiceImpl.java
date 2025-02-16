package com.example.Boffalora.service;

import com.example.Boffalora.bean.AnagraficaBean;
import com.example.Boffalora.dao.AnagraficaRepository;
import com.example.Boffalora.model.Anagrafica;
import com.example.Boffalora.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaServiceImpl { // Nessuna interfaccia implementata

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    public List<Anagrafica> getAllAnagrafica() {
        return anagraficaRepository.findAll();
    }

    public void setAnagraficaToDB(AnagraficaBean bean) {
        if (bean != null) {
            Anagrafica anagrafica = Utils.anagraficaBeanToEntity(bean);
            anagraficaRepository.save(anagrafica);
        }
    }
}
