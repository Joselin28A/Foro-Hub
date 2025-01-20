package alura.challenge.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByActivoTrue(Pageable pageable);

    @Query("SELECT COUNT(t) > 0 FROM Topico t WHERE t.titulo = :titulo AND t.mensaje = :mensaje")
    boolean existsByTituloAndMensaje(@Param("titulo") String titulo, @Param("mensaje") String mensaje);

    @Query("SELECT t FROM Topico t ORDER BY t.curso.nombre ASC")
    Page<Topico> findByCursoAsc(Pageable pageable);

    @Query("SELECT t FROM Topico t ORDER BY t.fecha ASC")
    Page<Topico> findAllOrderByFecha(Pageable pageable);

    @Query("SELECT t FROM Topico t ORDER BY t.autor.nombre ASC")
    Page<Topico> findAllOrderByAutor(Pageable pageable);
}