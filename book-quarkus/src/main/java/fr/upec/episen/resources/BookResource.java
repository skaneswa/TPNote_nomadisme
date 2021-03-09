package fr.upec.episen.resources;

import fr.upec.episen.resources.object.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposer une méthode getAll renvoyant une liste de notes n Integer
 * depuis la route /notes
 *
 * Json attendu :
 *
 * [
 *      "1234567890G" : {
 *          nomEtudiant: "Dupont",
 *          notes: [10, 12, 13, 8, 17]
 *      },
 *      "0987654321G": {
 *           nomEtudiant: "Michel",
 *          notes: [11, 13, 14, 9, 18]
 *      }
 * ]
 */
@Path("/book")
public class BookResource {

    /*@Inject
    @GrpcService("etudiant")
    EtudiantGrpc.EtudiantBlockingStub etudiantGrpcService;*/

    public List<Book> hashMap =new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllNotes(){

        // FIRST STUDENT
        Book book0 = new Book("Harry Potter à l’école des sorciers", "978-2070541270", 9);
        Book etu0 = new Book();
        String ine0 = "u21815645";
       /* etu0.setEtudiant(
                etudiantGrpcService.getEtudiantName(
                        EtudiantNameRequest.newBuilder()
                                .setIsbn(ine0)
                                .build()
                ).getName()
        );*/
        //etu0.setNotes(notes0);

        // SECOND STUDENT

        Book book1 = new Book("Harry Potter et la chambre des secrets", "978-2070541271", 9);
        Book etu1 = new Book();
        String ine1 = "1234567890G";
       /* etu1.setEtudiant(
                etudiantGrpcService.getEtudiantName(
                        EtudiantNameRequest.newBuilder()
                        .setIsbn(ine1)
                        .build()
                ).getName()
        );*/
        //etu1.setNotes(notes1);

        // THIRD STUDENT
        Book book2 = new Book("Harry Potter et le prisonnier d'Azhkaban", "978-2070541272", 9);

        Book etu2 = new Book();
        String ine2 = "0987654321G";
        /*etu2.setEtudiant(
                etudiantGrpcService.getEtudiantName(EtudiantNameRequest.newBuilder()
                    .setIsbn(ine2)
                    .build()
                ).getName()
        );*/
        //etu2.setNotes(notes2);

        // PUT NOTES IN HASHMAP
        hashMap.add(book0);
        hashMap.add(book1);
        hashMap.add(book2);

        return hashMap;
    }



}
