Create Table cursos(
    id bigint Not Null auto_increment,
    nombre Varchar(100) Not Null Unique,
    categoria Varchar(100) Not Null,

    primary key(id)
);