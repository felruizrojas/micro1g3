# MICROSERVICIO 1: GESTIÓN DE USUARIOS

## KANBAN

https://trello.com/invite/b/67e9c474eca9c07062c32442/ATTI566f43f43c7132ca78f40460b2cf213321D4DDD4/tareasfullstackig3

## GITHUB FELLIPE RUIZ

https://github.com/felruizrojas/micro1g3.git

## MÉTODOS HTTP

### POST PARA INGRESAR USUARIO, ROL Y PERMISO:
localhost:8080/api/usuarios
{
  "run": "Prueba1",
  "nombrePrimero": "Prueba1",
  "nombreSegundo": "Prueba1",
  "apellidoPaterno": "Prueba1",
  "apellidoMaterno": "Prueba1",
  "correo": "Prueba1",
  "direccion": "Prueba1",
  "ciudad": "Prueba1",
  "region": "Prueba1",
  "roles": [
    {
      "nombreRol": "Prueba1",
      "permisos": [
        {
            "nombrePermiso": "Prueba1"
        }
      ]
    }
  ]
}


### POST PARA INGRESAR ROL Y PERMISO(S):
{
  "nombreRol": "ADMINISTRADOR",
  "permisos": [
    {
      "nombrePermiso": "CREAR_USUARIO"
    },
    {
      "nombrePermiso": "EDITAR_USUARIO"
    },
    {
      "nombrePermiso": "ELIMINAR_USUARIO"
    }
  ]
}