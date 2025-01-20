package alura.challenge.forohub.controller;

import alura.challenge.forohub.domain.respuesta.*;
import alura.challenge.forohub.domain.topico.Estado;
import alura.challenge.forohub.domain.topico.Topico;
import alura.challenge.forohub.domain.topico.TopicoRepository;
import alura.challenge.forohub.domain.usuario.Usuario;
import alura.challenge.forohub.domain.usuario.UsuarioRepository;
import alura.challenge.forohub.excepcion.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
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
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping("/registrar")
    public ResponseEntity<DatosRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta dRegistroRespuesta, UriComponentsBuilder uriComponentsBuilder){
        Usuario autor = usuarioRepository.findById(dRegistroRespuesta.usuarioId()).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        Topico topico = topicoRepository.findById(dRegistroRespuesta.topicoId()).orElseThrow(() -> new ResourceNotFoundException("Tópico no encontrado"));
        Respuesta respuesta = respuestaRepository.save(new Respuesta(dRegistroRespuesta, autor, topico));
        DatosRespuesta datosRespuesta = new DatosRespuesta(respuesta);
        URI url = uriComponentsBuilder.path("respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DatosListadoRespuesta>> listarRespuestas(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(respuestaRepository.findAll(pageable).map(DatosListadoRespuesta::new));
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<DatosRespuesta> retornarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada"));
        DatosRespuesta datosRespuesta = new DatosRespuesta(respuesta);
        return ResponseEntity.ok(datosRespuesta);
    }


}
