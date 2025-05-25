# MICROSERVICIO 1: GESTIÓN DE USUARIOS

## KANBAN

https://trello.com/invite/b/67e9c474eca9c07062c32442/ATTI566f43f43c7132ca78f40460b2cf213321D4DDD4/tareasfullstackig3

## GITHUB FELLIPE RUIZ

https://github.com/felruizrojas/micro1g3.git

## MÉTODOS HTTP

### POST PARA INGRESAR USUARIO, ROL Y PERMISO:
localhost:8080/api/usuarios
{
  "run": "Prueba2",
  "nombrePrimero": "Prueba2",
  "nombreSegundo": "Prueba2",
  "apellidoPaterno": "Prueba2",
  "apellidoMaterno": "Prueba2",
  "correo": "Prueba2",
  "direccion": "Prueba2",
  "ciudad": "Prueba2",
  "region": "Prueba2",
  "roles": [
    {
      "nombreRol": "Prueba2",
      "permisos": [
        {
            "nombrePermiso": "Prueba2"
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