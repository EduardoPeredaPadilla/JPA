package principal.logica.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import principal.logica.entities.Autor;
import principal.logica.entities.Editorial;
import principal.logica.entities.Libro;
import principal.persistence.ControladoraPersistencia;

public class ControladorLogicaService {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Métodos para los Autores

    public void agregarAutor (Scanner scanInt) throws Exception {

        System.out.println("----------- AGREGAR UN NUEVO AUTOR ----------------");
        System.out.println("");
        try {
            //Creamos el Autor
            Autor autor = new Autor(scanInt.next(), true);
            //Lo guardamos en la BD
            controlPersis.crearAutor(autor);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarAutor(Scanner scanInt) throws Exception {

        ArrayList<Autor> autores = controlPersis.traerListaAutores();
        System.out.println("-------------------- EDITAR DATOS DE UN AUTOR ------------------");
        System.out.println("---------- Lista de Autores -------------");
        System.out.println("");
        for (Autor autor : autores) {
            System.out.println(autor.toString());
        }
        System.out.println("");
        System.out.println("Elige el ID del autor a editar");
        int idAutor;
        //System.out.println("Id 2");
        try {
            idAutor = scanInt.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
        }
        for (Autor autor : autores) {
            if (idAutor == autor.getId()) {
                Autor autor2 = autor;
                System.out.println("Ingresa el nuevo nombre corregido del autor");
                autor2.setNombre(scanInt.next());
                controlPersis.editarAutor(autor2);
                return;
            }
        }
        System.out.println("El Id ingresado no existe");
        System.out.println("");
    }

    public void DarDeBajaAutor (Scanner scanInt) throws Exception {

        ArrayList<Autor> autores = controlPersis.traerListaAutores();
        System.out.println("-------------------- DAR DE BAJA A UN AUTOR ------------------");
        System.out.println("---------- Lista de Autores -------------");
        System.out.println("");
        for (Autor autor : autores) {
            System.out.println(autor.toString());
        }
        int idAutor;
        System.out.println("");
        System.out.println("Elige el ID del autor a dar de baja");
        //System.out.println("Id 2");
        try {
            idAutor = scanInt.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
        }
        
        for (Autor autor : autores) {
            if (idAutor == autor.getId()) {
                Autor autor2 = autor;
                autor2.setAlta(false);
                controlPersis.darDeBajaAutor(autor2);
                return;
            }
        }
        System.out.println("El Id ingresado no existe");
        System.out.println("");
    }

    public void buscarAutorPorNombre(Scanner scanInt) throws Exception {

        System.out.println("------------- BUSCAR AUTOR POR NOMBRE ----------------");
        System.out.println("");
        System.out.println("Ingresa el nombre del autor a buscar");
        String nombreAutor;
        try {
            nombreAutor = scanInt.next();
        } catch (Exception e) {
            throw new Exception("El nombre de ese autor no está registrado");
        }
        Autor autor = controlPersis.traerAutorPorNombre(nombreAutor);
        if (autor == null) {
            System.out.println("No se encontró el autor");
        } else {
            System.out.println(autor.toString());
        }
    }

    public void mostrarAutores() throws Exception {

        System.out.println("-------------- LISTA DE AUTORES -----------------");
        System.out.println("");
        ArrayList<Autor> autores = controlPersis.traerListaAutores();
        for (Autor autor : autores) {
            System.out.println(autor.toString());
        }
        System.out.println("");
    }

    // Métodos para las Editoriales

    public void agregarEditorial (Scanner scanInt) throws Exception {

        System.out.println("----------- AGREGAR UN NUEVA EDITORIAL ----------------");
        System.out.println("");
        Editorial editorial = null;
        try {
            editorial = new Editorial(scanInt.next(), true);
            controlPersis.crearEditorial(editorial);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarEditorial (Scanner scanInt) throws Exception {

        ArrayList<Editorial> editoriales = controlPersis.traerListaEditoriales();
        System.out.println("-------------------- EDITAR DATOS DE UNA EDITORIAL ------------------");
        System.out.println("---------- Lista de Editoriales -------------");
        System.out.println("");
        for (Editorial editorial : editoriales) {
            System.out.println(editorial.toString());   
        }
        System.out.println("");
        System.out.println("Elige el ID de la editorial a editar");
        int idEditorial;
        try {
            idEditorial = scanInt.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
        }
        
        for (Editorial editorial : editoriales) {
            if (idEditorial == editorial.getId()) {
                Editorial editorial2 = editorial;
                System.out.println("Ingresa el nombre corregido de la editorial");
                editorial2.setNombre(scanInt.next());
                controlPersis.editarEditorial(editorial2);
                return;
            }
        }
    }

    public void darDeBajaEditorial (Scanner scanInt) throws Exception {

        ArrayList<Editorial> editoriales = controlPersis.traerListaEditoriales();
        System.out.println("-------------------- DAR DE BAJA UNA EDITORIAL ------------------");
        System.out.println("---------- Lista de Editoriales -------------");
        System.out.println("");
        for (Editorial editorial : editoriales) {
            System.out.println(editorial.toString());   
        }
        System.out.println("");
        System.out.println("Elige el ID de la editorial a dar de baja");
        int idEditorial;
            try {
                idEditorial = scanInt.nextInt();
            } catch (InputMismatchException e) {
                throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
            }
        for (Editorial editorial : editoriales) {
            if (idEditorial == editorial.getId()) {
                Editorial editorial2 = editorial;
                editorial2.setAlta(false);
                controlPersis.darDeBajaEditorial(editorial2);
                return;
            }
        }
    }

    public void buscarEditorialPorNombre(Scanner scanInt) throws Exception {

        System.out.println("------------- BUSCAR EDITORIAL POR NOMBRE ----------------");
        System.out.println("");
        System.out.println("Ingresa el nombre de la editorial a buscar");
        String nombreEditorial = scanInt.next();
        Editorial editorial = controlPersis.traerEditorialPorNombre(nombreEditorial);
        if (editorial == null) {
            System.out.println("No se encontró la editorial");
        } else {
            System.out.println(editorial);
        }
    }

    public void mostrrarEditoriales() throws Exception {

        System.out.println("-------------- LISTA DE EDITORIALES -----------------");
        System.out.println("");
        ArrayList<Editorial> editoriales = controlPersis.traerListaEditoriales();
        for (Editorial editorial : editoriales) {
            System.out.println(editorial.toString());   
        }
        System.out.println("");
    }

    // Métodos para los Libros

    public void agregarLibro(Scanner scanInt) throws Exception {

        System.out.println("----------- AGREGAR UN NUEVO LIBRO ----------------");
        System.out.println("");
        Libro libro = null;
        Autor autor2 = null;
        Editorial editorial2 = null;
        try {
            libro = new Libro();
            autor2 = new Autor();
            editorial2 = new Editorial();
            //El uruario ingresa los datos del libro
            System.out.println("Ingresa el título del libro");
            libro.setTitulo(scanInt.next());
            System.out.println("Ingresa el año del libro");
            libro.setAnio(scanInt.nextInt());
            System.out.println("Ingresa el número de ejemplares que exiten en la librería");
            libro.setEjemplares(scanInt.nextInt());
            System.out.println( "Ingresa el número de ejemplares prestados");
            libro.setEjemplaresPrestados(scanInt.nextInt());
            libro.setEjemplaresRestantes(libro.getEjemplares() - libro.getEjemplaresPrestados());
            libro.setAlta(true);
            //El usuario ingresa los datos del autor (se crea o selecciona uno en caso de que el autor ya este registrado)
            System.out.println("Ingresa el nombre del autor del libro");
            autor2.setNombre(scanInt.next());
            autor2.setAlta(true);
            addAutorToLibro(autor2);
            libro.setAutor(autor2);
            //El usuario ingresa los datos de la editorial (se crea o selecciona una en caso de que la editorial ya este registrada)
            System.out.println("Ingresa el nombre de la editorial");
            editorial2.setNombre(scanInt.next());
            addEditorialToLibro(editorial2);
            libro.setEditorial(editorial2);
            //Se crea el libro en la base de datos
            controlPersis.crearLibro(libro);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addAutorToLibro(Autor autor2)  {

        String nombre = autor2.getNombre();
        Autor autor = controlPersis.traerAutorPorNombre(nombre);
        if (autor == null) {
            System.out.println("Se creo un nuevo autor");
            controlPersis.crearAutor(autor2);
            return;
        } else {
            System.out.println("Autor existente");
            autor2.setId(autor.getId());
        }
    }

    public void addEditorialToLibro(Editorial editorial2) throws Exception {

        String nombre = editorial2.getNombre();
        Editorial editorial = controlPersis.traerEditorialPorNombre(nombre);
        if (editorial == null) {
            System.out.println("Se creo una nueva editorial");
            controlPersis.crearEditorial(editorial2);
            return;
        } else {
            System.out.println("Editorial existente");
            editorial2.setId(editorial.getId());
        }
    }

    public void editarLibro(Scanner scanInt) throws Exception {

        ArrayList<Libro> libros = controlPersis.traerListaLibros();
        System.out.println("-------------------- EDITAR DATOS DE UN LIBRO ------------------");
        System.out.println("---------- Lista de Libros -------------");
        System.out.println("");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        System.out.println("");
        System.out.println("Elige el ISBN del libro a editar");
        long isbn;
        try {
            isbn = scanInt.nextLong();
        } catch (InputMismatchException e) {
            throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
        }
        for (Libro libro : libros) {
            if (isbn == libro.getIsbn()) {
                Libro libro2 = libro;
                menuEditarLibro(scanInt, libro2);
                return;
            }
        }
        System.out.println("El id ingresado no corresponde a ningun libro de la lista");
    }

    public void menuEditarLibro(Scanner scanInt, Libro libro2) throws Exception {

        System.out.println("Menú de datos a editar del libro " + libro2.getTitulo());
        System.out.println("");
        System.out.println("1. Título = " + libro2.getTitulo());
        System.out.println("2. Año de publicación = " + libro2.getAnio());
        System.out.println("3. Número de ejemplares = " + libro2.getEjemplares());
        System.out.println("4. Número de ejemplares prestados = " + libro2.getEjemplaresPrestados());
        System.out.println("5. Autor = " + libro2.getAutor().getNombre());
        System.out.println("6. Editorial = " + libro2.getEditorial().getNombre());
        System.out.println("7. Regresar al Menú Principal");
        System.out.println("");
        System.out.println("Elige la opción que deseas editar, ingresa 7 para salir");
        int resp;
        try {
            resp = scanInt.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("Caracter inválido");
            //menuEditarLibro(libro2);
            //return;
        }
        int anio;
        int ejem;
        int ejemP;
        int respA;
        int idAutor;
        int respE;
        int idEdit;
        switch (resp) {
            case 1:
                System.out.println("Ingresa títullo corregido del libro");
                libro2.setTitulo(scanInt.next());
                menuEditarLibro(scanInt, libro2);
                break;
            case 2:
                System.out.println("Ingresa el año de publicación corregido");
                try {
                    anio = scanInt.nextInt();
                } catch (InputMismatchException e) {
                    throw new Exception("Caracter inválido");
                    //menuEditarLibro(libro2);
                    //return;
                }
                libro2.setAnio(anio);
                menuEditarLibro(scanInt, libro2);
                break;
            case 3:
                System.out.println("Ingresa el número de ejemplares corregido");
                try {
                    ejem = scanInt.nextInt();
                } catch (InputMismatchException e) {
                    throw new Exception("Caracter inválido");
                    //menuEditarLibro(libro2);
                    //return;
                }
                libro2.setEjemplares(ejem);
                menuEditarLibro(scanInt, libro2);
                break;
            case 4:
                System.out.println("Ingresa el número de ejemplares prestados corregido");
                try {
                    ejemP = scanInt.nextInt();
                } catch (InputMismatchException e) {
                    throw new Exception("Caracter inválido");
                    //menuEditarLibro(libro2);
                    //return;
                }
                libro2.setEjemplaresPrestados(ejemP);
                libro2.setEjemplaresRestantes(libro2.getEjemplares() - ejemP);
                menuEditarLibro(scanInt, libro2);
                break;
            case 5:
                System.out.println("Acciones para editar el Autor");
                System.out.println("1. Editar el autor de este libro");
                System.out.println("2. Cambiar de autor, elegir de la lista de autores existente");
                System.out.println("3. Agredar un nuevo autor");
                System.out.println("4. Regresar al Menú Principal");
                System.out.println("Elige la opción deseada");
                try {
                    respA = scanInt.nextInt();
                } catch (InputMismatchException e) {
                    throw new Exception("Caracter inválido");
                    //menuEditarLibro(libro2);
                    //return;
                }
                switch (respA) {
                    case 1:
                        System.out.println("Ingresa el nombre del autor corregido");
                        libro2.getAutor().setNombre(scanInt.next());
                        controlPersis.editarAutor(libro2.getAutor());
                        menuEditarLibro(scanInt, libro2);
                        break;
                    case 2:
                        System.out.println("Lista de Autores");
                        ArrayList<Autor> autores = controlPersis.traerListaAutores();
                        for (Autor autor : autores) {
                            System.out.println(autor.toString());
                        }
                        System.out.println("Elige el id del autor que quieres asignar al libro");
                        try {
                            idAutor = scanInt.nextInt();
                        } catch (InputMismatchException e) {
                            throw new Exception("Caracter inválido");
                        }
                        for (Autor autor : autores) {
                            if (idAutor == autor.getId()) {
                                Autor autor2 = autor;
                                libro2.setAutor(autor2);
                                menuEditarLibro(scanInt, libro2);
                                return;
                            }
                        }
                        System.out.println("El id ingresado no corresponde a ningun autor registrado, intenta nuevamante");
                        menuEditarLibro(scanInt, libro2);
                        break;
                    case 3:
                        System.out.println("Ingresa el nombre del nuevo autor");
                        Autor autor3 = new Autor(scanInt.next(), true);
                        controlPersis.crearAutor(autor3);
                        libro2.setAutor(autor3);
                        menuEditarLibro(scanInt, libro2);
                        break;
                    case 4:
                        menuEditarLibro(scanInt, libro2);
                        break;
                    default:
                        System.out.println("Respuesta fuera del reango de opciones");
                        menuEditarLibro(scanInt, libro2);
                        break;
                }
            case 6: 
                System.out.println("Acciones para editar la Editorial");
                System.out.println("1. Editar la editorial de este libro");
                System.out.println("2. Cambiar a una editorial de la lista de editoriales existentes");
                System.out.println("3. Registrar una nueva editorial");
                System.out.println("4. Regresar al Menú Principal");
                System.out.println("Elige la opción deseada");
                try {
                    respE = scanInt.nextInt();
                } catch (InputMismatchException e) {
                    throw new Exception("Caracter inválido");
                }
                switch (respE) {
                    case 1:
                        System.out.println("Ingresa el nombre corregido de la editorial");
                        libro2.getEditorial().setNombre(scanInt.next());
                        controlPersis.editarEditorial(libro2.getEditorial());
                        break;
                    case 2:
                        System.out.println("Lista de Editoriales");
                        ArrayList<Editorial> editoriales = controlPersis.traerListaEditoriales();
                        for (Editorial editorial : editoriales) {
                            System.out.println(editorial.toString());
                        }
                        System.out.println("Ingresa el id de la editorial para asignarla al libro");
                        try {
                            idEdit = scanInt.nextInt();
                        } catch (InputMismatchException	 e) {
                            throw new Exception("Caracter inválido");
                        }
                        for (Editorial editorial : editoriales) {
                            if (idEdit == editorial.getId()) {
                                libro2.setEditorial(editorial);
                                menuEditarLibro(scanInt, libro2);
                                return;
                            }
                        }
                        System.out.println("El id ingresado no corresponde a ninguna editorial registrada, intenta nuevamante");
                        menuEditarLibro(scanInt, libro2);
                        break;
                    case 3:
                        System.out.println("Ingresa el nombre de la nueva editorial");
                        Editorial editorial3 = new Editorial(scanInt.next(), true);
                        controlPersis.crearEditorial(editorial3);
                        libro2.setEditorial(editorial3);
                        menuEditarLibro(scanInt, libro2);
                        break;
                    case 4:
                        menuEditarLibro(scanInt, libro2);
                        break;
                    default:
                        System.out.println("Respuesta fuera del reango de opciones");
                        menuEditarLibro(scanInt, libro2);
                        break;
                }
            case 7:
                System.out.println("Regresando al menu principal");

                break;
            default:
                System.out.println("Opción in´valida, intenta nuevamente");
                menuEditarLibro(scanInt, libro2);
                break;
        }
    }

    public void darDeBajaLibro(Scanner scanInt) throws Exception {

        ArrayList<Libro> libros = controlPersis.traerListaLibros();
        System.out.println("-------------------- DAR DE BAJA UN LIBRO ------------------");
        System.out.println("---------- Lista de Libros -------------");
        System.out.println("");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        System.out.println("");
        System.out.println("Elige el ISBN del libro a dar de baja");
        long isbn;
        try {
            isbn = scanInt.nextLong();
        } catch (InputMismatchException e) {
            throw new Exception("Ingresaste un caracter inválido, intenta nuevamente");
        }
        for (Libro libro : libros) {
            if (isbn == libro.getIsbn()) {
                Libro libro2 = libro;
                libro2.setAlta(false);
                controlPersis.darDeBajaLibro(libro2);
                return;
            }
        }
        System.out.println("El id ingresado no corresponde a ningun libro de la lista");
    }

    public void buscarLibroPorTitulo(Scanner scanInt) throws Exception {

        System.out.println("Ingresa el título del libro buscado");
        String titulo = scanInt.next();
        Libro libro = controlPersis.traerLibroPorTitulo(titulo);
        if (libro == null) {
            System.out.println("No se encontró el libro");
        } else {
            System.out.println(libro.toString());
        }
    }

    public void buscarLibroPorAutor(Scanner scanInt) throws Exception {

        System.out.println("Ingresa el nombre del autor del libro buscado");
        String nombreAutor = scanInt.next();
        ArrayList<Autor> autores = controlPersis.traerListaAutores();
        for (Autor autor : autores) {
            if (nombreAutor.equalsIgnoreCase(autor.getNombre())) {
                List<Libro> libros = controlPersis.traerLibroPorAutor(autor);
                if (libros == null) {
                    System.out.println("No se encontró ningun libro de el autor " + nombreAutor);
                } else {
                    for (Libro libro : libros) {
                        System.out.println(libro.toString());
                    }
                }
            }
        }
    }

    public void buscarLibroPorEditorial(Scanner scanInt) throws Exception {

        System.out.println("Ingresa el nombre de la editorial del libro buscado");
        String nombreEditorial = scanInt.next();
        ArrayList<Editorial> editoriales = controlPersis.traerListaEditoriales();
        for (Editorial editorial : editoriales) {
            if (nombreEditorial.equalsIgnoreCase(editorial.getNombre())) {
                List<Libro> libros = controlPersis.traerLibroPorEditorial(editorial);
                if (libros == null) {
                    System.out.println("No se encontró ningun libro de la editorial " + nombreEditorial);
                } else {
                    for (Libro libro : libros) {
                        System.out.println(libro.toString());
                    }
                }
            }
        }
    }

    public void mostrarLibros() throws Exception {
        
        System.out.println("--------------- LISTA DE LIBROS ------------------");
        System.out.println("");
        ArrayList<Libro> libros = controlPersis.traerListaLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrado en este momento");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        }
    }
}
