package Libros;

import java.util.ArrayList;

import java.util.List;


public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros = new ArrayList<>();
    private int contador = 1;

    @Override
    public void crear(Libro libro){
        libro = new Libro(contador++, libro.getTitulo(), libro.getAutor(), libro.getAnioPublication());
        libros.add(libro);
        System.out.println("Libro creado:" + libro);
    }

    @Override
    public Libro leer(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void actualizar(Libro libroActualizado){
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getId() == libroActualizado.getId()) {
                libros.set(i, libroActualizado);
                System.out.println("Libro actualizado: " + libroActualizado);
                return;
            }
        }
        System.out.println("Libro no encontrado para actualizar.");
    }
    @Override
    public void eliminar(int id){
        boolean eliminado = libros.removeIf(libro -> libro.getId() == id);
        if(eliminado){
            System.out.println("Libro eliminado con ID: " + id);
        } else{
            System.out.println("Libro no encontrado para eliminar.");
        }
    }
    @Override
    public List<Libro> listar() {
        return new ArrayList<>(libros);
    }
}
