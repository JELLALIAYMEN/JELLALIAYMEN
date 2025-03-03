package com.example.gstioneleve.Service;

import com.example.gstioneleve.DTO.DisciplineDTO;
import com.example.gstioneleve.Mapper.Mapperdto;
import com.example.gstioneleve.entites.Discipline;
import com.example.gstioneleve.entites.TypeDisc;
import com.example.gstioneleve.rep.Disciplinerep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class disciplineserviceimpl implements DisciplineService {
    @Autowired
    Disciplinerep disciplinerep;
    @Autowired
    Mapperdto dto;

    @Override
    public DisciplineDTO saveDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline=dto.fromDisciplineDTO(disciplineDTO);
      Discipline saveddiscipline=disciplinerep.save(discipline);


        return  dto.fromDiscipline(saveddiscipline);
    }

    @Override
    public DisciplineDTO updateDiscipline(Long id, TypeDisc typeDisc) {
        Discipline discipline = disciplinerep.findById(id).orElse(null);
        if (discipline != null) {
            discipline.setTypeDisc(typeDisc);
            disciplinerep.save(discipline); // Sauvegarde de la discipline mise à jour
            return dto.fromDiscipline(discipline); // Conversion de l'entité mise à jour en DTO
        }
        return null; // Retourne null si la discipline avec l'ID spécifié n'est pas trouvée
    }

    @Override
    public List<DisciplineDTO> findByCode(String code) {
 List<Discipline> disciplines=disciplinerep.findByCode(code);
 return  disciplines.stream().map(discipline -> dto.fromDiscipline(discipline)).collect(Collectors.toList());

    }

    @Override
    public void deleteDiscipline(Long id) {
      disciplinerep.deleteById(id);
    }

    @Override
    public List<DisciplineDTO> findAll() {
        List<Discipline> disciplines=disciplinerep.findAll();
        return  disciplines.stream().map(discipline -> dto.fromDiscipline(discipline)).collect(Collectors.toList());
    }
}
