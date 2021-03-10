package fr.upec.episen.resources;

import fr.upec.episen.resources.object.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {
    public List<Book> list =new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllNotes(){

        Book book0 = new Book("Harry Potter à l’école des sorciers", "978-2070541270", 9);
        Book book1 = new Book("Harry Potter et la chambre des secrets", "978-2070541271", 9);
        Book book2 = new Book("Harry Potter et le prisonnier d'Azhkaban", "978-2070541272", 9);

        list.add(book0);
        list.add(book1);
        list.add(book2);

        return list;
    }



}
