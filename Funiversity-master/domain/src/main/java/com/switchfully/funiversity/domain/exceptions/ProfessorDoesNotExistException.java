package com.switchfully.funiversity.domain.exceptions;

public class ProfessorDoesNotExistException extends RuntimeException {
    public ProfessorDoesNotExistException(String professorId) {
        super("Professor with id " + professorId + " not found.");
    }
}
