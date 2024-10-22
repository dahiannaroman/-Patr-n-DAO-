package Libros;

public class LibroMain {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        // Crear libros
        libroDAO.crear(new Libro(0, "El Principito", "Antoine de Saint-Exupéry", 1943));
        libroDAO.crear(new Libro(0, "Cien años de soledad", "Gabriel García Márquez", 1967));

        // Listar libros
        System.out.println("Libros en la biblioteca:");
        libroDAO.listar().forEach(System.out::println);

        // Leer un libro
        System.out.println("\nLeyendo libro con ID 1:");
        System.out.println(libroDAO.leer(1));

        // Actualizar un libro
        libroDAO.actualizar(new Libro(1, "El Principito", "Antoine de Saint-Exupéry", 1945));
        System.out.println("\nLibros después de la actualización:");
        libroDAO.listar().forEach(System.out::println);

        // Eliminar un libro
        libroDAO.eliminar(2);
        System.out.println("\nLibros después de eliminar:");
        libroDAO.listar().forEach(System.out::println);
    }
}
