package com.switchfully.funiversity.service.professor;

import com.switchfully.funiversity.domain.professor.Professor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessorMapper {
    public Collection<ProfessorDto> toDto(Collection<Professor> professorCollection) {
        return professorCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProfessorDto toDto(Professor professor) {
        return new ProfessorDto(professor.getId(), professor.getFirstName(), professor.getLastName());
    }

    public Professor toProfessor(ProfessorDto professorDto) {
        return new Professor(professorDto.getFirstName(), professorDto.getLastName());
    }

    public Professor toExistingProfessor(ProfessorDto professorDto) {
        return new Professor(professorDto.getId(), professorDto.getFirstName(), professorDto.getLastName());
    }
}
