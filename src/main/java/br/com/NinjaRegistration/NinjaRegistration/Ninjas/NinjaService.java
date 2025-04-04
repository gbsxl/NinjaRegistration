package br.com.NinjaRegistration.NinjaRegistration.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> printAll() {
        List<NinjaModel> ninjaModel = ninjaRepository.findAll();
        return ninjaModel.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO printByID(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO); // map NinjaModel with DTO arguments
        ninjaModel = ninjaRepository.save(ninjaModel); // Did a query POST using NinjaModel
        return ninjaMapper.map(ninjaModel); // return map from NinjaModel to NinjaDTO
    }

    public void delete(Long id) {
        if (ninjaRepository.findById(id).isPresent()) {
            ninjaRepository.deleteById(id);
        }
    }

    public NinjaDTO updateData(NinjaDTO body, Long id) {
        Optional<NinjaModel> base = ninjaRepository.findById(id);
        if (base.isPresent()){
            NinjaModel original = base.get();
            ninjaMapper.updateFromDto(body, original);
            NinjaModel updated = ninjaRepository.save(original);
            return ninjaMapper.map(updated);
        }
        return null;
    }
}