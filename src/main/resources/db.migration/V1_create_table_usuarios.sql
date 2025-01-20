Create Table usuarios(
    id bigint Not Null auto_increment,
    nombre Varchar(100) Not Null,
    email Varchar(100) Not Null Unique,
    perfil Varchar(100) Not Null,
    clave Varchar(300) Not Null,

    primary key(id)
);