Create Table topicos (
    id bigint Not Null auto_increment,
    curso_id bigint Not Null,
    usuario_id bigint Not Null,

    titulo Varchar(200) Not Null,
    mensaje TEXT Not Null,
    fecha datetime Not Null,
    status Varchar(50) Not Null,
    activo bit Not Null,

    Primary Key(id),
    Foreign Key (curso_id) References cursos(id),
    Foreign Key (usuario_id) References usuarios(id)
);