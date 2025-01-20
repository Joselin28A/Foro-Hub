Create Table respuestas(
    id bigint Not Null auto_increment,
    topico_id bigint Not Null,
    usuario_id bigint Not Null,

    mensaje TEXT Not Null,
    fecha datetime Not Null,
    solucion bit Not Null,

    Primary Key (id),
    Foreign Key (topico_id) References topicos(id),
    Foreign Key (usuario_id) References usuarios(id)
);