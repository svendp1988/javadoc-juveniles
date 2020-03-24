package com.switchfully.funiversity.api.exceptions;

import com.switchfully.funiversity.api.professor.ProfessorController;
import com.switchfully.funiversity.domain.exceptions.ProfessorDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    @ExceptionHandler(ProfessorDoesNotExistException.class)
    protected void professorDoesNotExistsException(ProfessorDoesNotExistException ex, HttpServletResponse response) throws IOException {
        logger.error("Professor does not exist", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
