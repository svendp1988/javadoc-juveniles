package com.switchfully.funiversity.api.professor;

import com.switchfully.funiversity.service.professor.ProfessorDto;
import com.switchfully.funiversity.service.professor.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private ProfessorService professorService;
    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProfessorDto> findAll() {
        logger.info("Returning all professors to the requester");
        return professorService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto findById(@PathVariable("id") String id) {
        logger.info("Returning a specific professor to the requester");
        return professorService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto save(@RequestBody ProfessorDto professorDto) {
        logger.info("Creating a new professor");
        return professorService.save(professorDto);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto updateProfessor(@RequestBody ProfessorDto professorDto, @PathVariable("id") String id) {
        logger.info("Updating an existing professor");
        ProfessorDto professorToUpdate = professorService.findById(id);
        professorToUpdate.setFirstName(professorDto.getFirstName());
        professorToUpdate.setLastName(professorDto.getLastName());
        professorService.update(professorToUpdate);
        return professorToUpdate;
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessor(@PathVariable("id") String id) {
        logger.info("Deleting an existing professor");
        professorService.delete(id);
    }
}
