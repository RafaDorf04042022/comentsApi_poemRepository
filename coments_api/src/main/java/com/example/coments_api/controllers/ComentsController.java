package com.example.coments_api.controllers;

import com.example.coments_api.models.ComentsModel;
import com.example.coments_api.records.ComentsRecordDto;
import com.example.coments_api.repositores.ComentsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ComentsController {
    @Autowired
    ComentsRepository comentsRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/coments")
    public ResponseEntity<ComentsModel> publicarComentario(@RequestBody @Valid ComentsRecordDto comentsRecordDto){
        var comentsModel = new ComentsModel();
        BeanUtils.copyProperties(comentsRecordDto, comentsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentsRepository.save(comentsModel));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/coments/{title}")
    public ResponseEntity<List<ComentsModel>> getByTitle(@PathVariable(name = "title") String title){
        List<ComentsModel> comentsModelList = comentsRepository.findByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(comentsModelList);
    }
}
