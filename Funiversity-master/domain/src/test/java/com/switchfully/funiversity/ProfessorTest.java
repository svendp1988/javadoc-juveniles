package com.switchfully.funiversity;

import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.domain.professor.ProfessorRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {
    @Test
    void givenAFullName_returnsCorrectName() {
        // Given
        String givenFirstName = "name";
        String givenLastName = "lastName";
        Professor professor = new Professor(givenFirstName, givenLastName);
        // When
        String actualName = professor.getFirstName();
        String actualLastName = professor.getLastName();
        // Then
        assertThat(actualName).isEqualTo(givenFirstName);
        assertThat(actualLastName).isEqualTo(givenLastName);
    }

    @Test
    void testIfIDNotNull(){
        // Given
        String givenFirstName = "name";
        String givenLastName = "lastName";
        Professor professor = new Professor(givenFirstName, givenLastName);
        // When
        String actualId = professor.getId();
        // Then
        assertThat(actualId).isNotEqualTo(null);
    }

    @Test
    void whenAsked_shouldReturn_collectionOfProfessors(){
        // Given
        Professor professor = new Professor("John", "Doe");
        Professor professor1 = new Professor("Jane", "Doe");
        ProfessorRepository repo = new ProfessorRepository();
        // When
        repo.save(professor);
        repo.save(professor1);
        // Then
        assertThat(repo.getAll()).containsExactlyInAnyOrder(professor, professor1);
    }

    @Test
    void whenAsked_shouldReturn_aProfessorById(){
        // Given
        Professor professor = new Professor("John", "Doe");
        Professor professor1 = new Professor("Jane", "Doe");
        ProfessorRepository repo = new ProfessorRepository();
        // When
        repo.save(professor);
        repo.save(professor1);
        // Then
        assertThat(repo.getById(professor.getId())).isEqualTo(professor);
    }

    @Test
    void whenAsked_toReturnAProfessor_withInvalidId_throwException() {
        // Given
        ProfessorRepository repo = new ProfessorRepository();
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> {repo.getById("some made up Id");});
    }
}