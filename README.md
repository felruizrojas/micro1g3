# MICROSERVICIO 1: GESTIÓN DE USUARIOS

## KANBAN

https://trello.com/invite/b/67e9c474eca9c07062c32442/ATTI566f43f43c7132ca78f40460b2cf213321D4DDD4/tareasfullstackig3

## GITHUB FELLIPE RUIZ

https://github.com/felruizrojas/micro1g3.git

## MÉTODOS HTTP


### POST PARA INGRESAR USUARIO, ROL Y PERMISO:
localhost:8080/api/usuarios
{
  "run": "12345678-9",
  "nombrePrimero": "Felipe",
  "nombreSegundo": "Andrés",
  "apellidoPaterno": "Ruiz",
  "apellidoMaterno": "Rojas",
  "correo": "felipe@example.com",
  "direccion": "Av. Siempre Viva 123",
  "ciudad": "Concepción",
  "region": "Biobío",
  "roles": [
    {
      "nombreRol": "ADMIN",
      "permisos": [
        {
          "nombrePermiso": "GESTION_USUARIOS"
        },
        {
          "nombrePermiso": "GESTION_VENTAS"
        }
      ]
    },
    {
      "nombreRol": "VENDEDOR",
      "permisos": [
        {
          "nombrePermiso": "VER_PRODUCTOS"
        }
      ]
    }
  ]
}
