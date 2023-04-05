package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.IMatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaServiceImpl service;

    @PostMapping()
    public Matricula create(@Valid @RequestBody MatriculaForm form){
        return  service.create(form);
    }
    @GetMapping("{bairro}")
    public List<Matricula> getAll(@RequestParam(value = "bairro",required = false)String bairro){
        return service.getAll(bairro);
    }

    @GetMapping("{id}")
    public Optional<Matricula> getMatriculaById(@PathVariable("id") Long id){
        return service.get(id);
    }

}
