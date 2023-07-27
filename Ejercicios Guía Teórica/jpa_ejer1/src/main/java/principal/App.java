package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import principal.logica.services.ControladorLogicaService;

public class App {
    public static void main( String[] args ) throws Exception {

        // ControladorLogicaService contLogServ = new ControladorLogicaService();
        // contLogServ.agregarLibro();
        //  Menu();
        try (Scanner scanInt = new Scanner(System.in)) {
            Menu(scanInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Menu(Scanner scanInt) throws Exception {

        ControladorLogicaService contLogServ = new ControladorLogicaService();


            System.out.println("");
            System.out.println("******************* MENÚ DE LA LIBRERÍA *******************");
            System.out.println("");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Agregar un Autor");
            System.out.println("3. Agregar una Editorial");
            System.out.println("4. Editar un libro");
            System.out.println("5. Editar un Autor");
            System.out.println("6. Editar una Editorial");
            System.out.println("7. Dar de baja un libro");
            System.out.println("8. Dar de baja un Autor");
            System.out.println("9. Dar de baja una Estancia");
            System.out.println("10. Buscar un libro");
            System.out.println("11. Buscar un autor");
            System.out.println("12. Buscar una editorial");
            System.out.println("13. Mostrar Libros");
            System.out.println("14. Mostrar Autores");
            System.out.println("15. Mostrar Editoriales");
            System.out.println("16. Salir");
            System.out.println("");
            System.out.println("Ingresa la opción deseada");

            //Variables de respuestas de menús
            int respM;
            int respL;
            

            try {
                // respM = scanInt.nextInt();
                if (scanInt.hasNextInt()) {
                    respM = scanInt.nextInt();
                } else {
                    System.out.println("Scanner vacío, intenta nuevamente");
                    scanInt.next(); // Limpia la entrada inválida para evitar bucles infinitos
                    Menu(scanInt);
                    return;
                }
            } catch (InputMismatchException e) {
                //throw new Exception("Caracter inválido");
                System.out.println("Caracter inválido, intenta nuevamente");
                scanInt.next(); // Limpia la entrada inválida para evitar bucles infinitos
                Menu(scanInt);
                return;
            }
            switch (respM) {
                case 1:
                    System.out.println("");
                    try {
                        contLogServ.agregarLibro(scanInt);
                        Menu(scanInt);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                        //scan.close();
                        Menu(scanInt);
                        return;
                    }
                    break;
                case 2:
                    System.out.println("");
                    contLogServ.agregarAutor(scanInt);
                    Menu(scanInt);
                    break;
                case 3:
                    System.out.println("");
                    contLogServ.agregarEditorial(scanInt);
                    Menu(scanInt);
                    break;
                case 4:
                    System.out.println("");
                    contLogServ.editarLibro(scanInt);
                    Menu(scanInt);
                    break;
                case 5:
                    System.out.println("");
                    contLogServ.editarAutor(scanInt);
                    Menu(scanInt);
                    break;
                case 6:
                    System.out.println("");
                    contLogServ.editarEditorial(scanInt);
                    Menu(scanInt);
                    break;
                case 7:
                    System.out.println("");
                    contLogServ.darDeBajaLibro(scanInt);
                    Menu(scanInt);
                    break;
                case 8:
                    System.out.println("");
                    contLogServ.DarDeBajaAutor(scanInt);
                    Menu(scanInt);
                    break;
                case 9:
                    System.out.println("");
                    contLogServ.darDeBajaEditorial(scanInt);
                    Menu(scanInt);
                    break;
                case 10:
                    System.out.println("");
                    System.out.println("Tipos de busquedas de libros");
                    System.out.println("1. Buscar libro por título");
                    System.out.println("2. Buscar libro por autor");
                    System.out.println("3. Buscar libro por editorial");
                    System.out.println("4. Regresar al Menú Principal");
                    System.out.println("Elige la opción deseada");
                    try {
                        respL = scanInt.nextInt();
                    } catch (InputMismatchException e) {
                        throw new Exception("Caracter inválido");
                    }
                    switch (respL) {
                        case 1:
                            System.out.println("");
                            contLogServ.buscarLibroPorTitulo(scanInt);
                            Menu(scanInt);
                            break;
                        case 2:
                            System.out.println("");
                            contLogServ.buscarLibroPorAutor(scanInt);
                            Menu(scanInt);
                            break;
                        case 3:
                            System.out.println("");
                            contLogServ.buscarLibroPorEditorial(scanInt);
                            Menu(scanInt);
                            break;
                        case 4:
                            Menu(scanInt);
                            break;
                        default:
                            System.out.println("Opción fuera del rango del menú");
                            Menu(scanInt);
                            break;
                    }
                case 11:
                    System.out.println("");
                    contLogServ.buscarAutorPorNombre(scanInt);
                    Menu(scanInt);
                    break;
                case 12:
                    System.out.println("");
                    contLogServ.buscarEditorialPorNombre(scanInt);
                    Menu(scanInt);
                    break;
                case 13:
                    contLogServ.mostrarLibros();
                    Menu(scanInt);
                    break;
                case 14:
                    contLogServ.mostrarAutores();
                    Menu(scanInt);
                    break;
                case 15:
                    contLogServ.mostrrarEditoriales();
                    Menu(scanInt);
                    break;
                case 16:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Respuesta fuera del rango del menú");
                    Menu(scanInt);
                    break;
            }
        
    }
}
