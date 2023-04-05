package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMatriculaServiceImpl implements IMatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> get(Long id) {
       return Optional.of(matriculaRepository.findById(id).get());
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null){
            return matriculaRepository.findAll();
        }else {
//            return matriculaRepository.findByAlunoBairro(bairro);
            return matriculaRepository.findAlunoMatriculadosBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
    //    matriculaRepository.delete(id);
    }
}
