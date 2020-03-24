package com.switchfully.funiversity.service.professor;

import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.domain.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public Collection<ProfessorDto> findAll() {
        return professorMapper.toDto(professorRepository.getAll());
    }

    public ProfessorDto findById(String id) {
        return professorMapper.toDto(professorRepository.getById(id));
    }

    public ProfessorDto save(ProfessorDto professorDto) {
        return professorMapper.toDto(professorRepository.save(professorMapper.toProfessor(professorDto)));
    }

    public ProfessorDto update(ProfessorDto professorDto) {
        return professorMapper.toDto(professorRepository.save(professorMapper.toExistingProfessor(professorDto)));
    }

    public void delete(String id) {
        professorRepository.deleteById(id);
    }
}
