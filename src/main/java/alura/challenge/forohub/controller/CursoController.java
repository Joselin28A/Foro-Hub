package alura.challenge.forohub.controller;

import alura.challenge.forohub.domain.curso.*;
import alura.challenge.forohub.excepcion.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/registrar")
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso dRegistroCurso, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.save(new Curso(dRegistroCurso));
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria().toString(),
                curso.getDescripcion()
        );
        URI url = uriComponentsBuilder.path("cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DatosListadoCurso>> listarCurso(@PageableDefault(size = 15) Pageable pageable) {
        return ResponseEntity.ok(cursoRepository.findAll(pageable).map(DatosListadoCurso::new));
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<DatosRespuestaCurso> retornarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        DatosRespuestaCurso datosCurso = new DatosRespuestaCurso(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria().toString(),
                curso.getDescripcion()
        );
        return ResponseEntity.ok(datosCurso);
    }
}
