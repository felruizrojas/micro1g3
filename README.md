# MICROSERVICIO 1: GESTIÓN DE USUARIOS

## KANBAN

https://trello.com/invite/b/67e9c474eca9c07062c32442/ATTI566f43f43c7132ca78f40460b2cf213321D4DDD4/tareasfullstackig3

## GITHUB FELLIPE RUIZ

https://github.com/felruizrojas/micro1g3.git

## MÉTODOS HTTP

### GET POR ID:
localhost:8080/api/usuarios

### POST PARA INGRESAR USUARIO y/o ROL:
localhost:8080/api/usuarios

{
  "run": "",
  "nomPrimero": "",
  "nomSegundo": "",
  "apPaterno": "",
  "apMaterno": "",
  "correo": "",
  "direccion": "",
  "ciudad": "",
  "region": "",
  "rolNombre": ""
}

### POST PARA INGRESAR USUARIO y/o ROL:
localhost:8080/api/roles

{
  "nombre": "",
  "permisos": [""]
}

### POST PARA PERMISO:
localhost:8080/api/permisos

{
  "nombre": ""
}

### PUT PARA USUARIO:
localhost:8080/api/usuarios/1

{
  "nomPrimero": "",
  "nomSegundo": "",
  "apPaterno": "",
  "apMaterno": "",
  "correo": "",
  "direccion": "",
  "ciudad": "",
  "region": "",
  "rolNombre": ""
}

### PUT PARA ROL Y PERMISO NO CREADO -- NO SE ESPERA MODIFICARLOS SOLO ELIMINARLOS

### DELETE POR ID: