package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NinjaService {
    NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> printAll(){
        return ninjaRepository.findAll();
    }
}
