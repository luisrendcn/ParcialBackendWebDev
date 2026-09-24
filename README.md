Para comprobar el funcionamiento se ejecuta el comando mvn spring-boot:run
y luego en un navegador colocamos los endpoints para listar los productos, 
por ejemplo : localhost:8080/api/productos
<img width="1025" height="591" alt="image" src="https://github.com/user-attachments/assets/a0ea342e-e6fe-43df-81b4-928a7115fdbb" />
Con este controlador y haciendo uso de GetMapping listo los productos, puedo buscar por id añadiendo al final de la url "/{id}" 

resultados de peticion:
<img width="920" height="321" alt="image" src="https://github.com/user-attachments/assets/a0f3e26c-aa40-408a-909f-cae634dada75" />
En ProductoService definimos las acaciones de ProductoRepository que van a ser luego consultadas por el controlador ProductoController.java
<img width="941" height="601" alt="image" src="https://github.com/user-attachments/assets/1a7d2f77-ff75-40be-9c18-4d848469666c" />
Si bien no logro mostrar el error 404, el backend si maneja correctamente la excepcion cuando el producto no existe
<img width="1250" height="393" alt="image" src="https://github.com/user-attachments/assets/ee9a4872-c51b-4724-827f-aa72e7973fdb" />
<img width="1258" height="211" alt="image" src="https://github.com/user-attachments/assets/6924fbe6-c692-457b-ad15-3b40263e69b7" />



