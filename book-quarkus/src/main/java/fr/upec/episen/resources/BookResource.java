package fr.upec.episen.resources;

import fr.upec.episen.proto.QuantityGrpc;
import fr.upec.episen.proto.QuantityNameRequest;
import fr.upec.episen.resources.object.Book;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    @GrpcService("etudiant")
    QuantityGrpc.QuantityBlockingStub quantityGrpcService;

    public List<Book> list =new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks(){

        Book book0 = new Book("Harry Potter à l’école des sorciers", "978-2070541270", 9);
        String isbn0 = "978-2070541270";
        book0.setQuantity(
                quantityGrpcService.getQuantity(
                        QuantityNameRequest.newBuilder()
                                .setIsbn(isbn0)
                                .build()
                ).getQuantity()
        );

        Book book1 = new Book("Harry Potter et la chambre des secrets", "978-2070541271", 9);
        String isbn1 = "978-2070541271";
        book1.setQuantity(
                quantityGrpcService.getQuantity(
                        QuantityNameRequest.newBuilder()
                        .setIsbn(isbn1)
                        .build()
                ).getQuantity()
        );

        Book book2 = new Book("Harry Potter et le prisonnier d'Azhkaban", "978-2070541272", 9);
        String isbn2 = "978-2070541272";
        book2.setQuantity(
                quantityGrpcService.getQuantity(QuantityNameRequest.newBuilder()
                    .setIsbn(isbn2)
                    .build()
                ).getQuantity()
        );

        list.add(book0);
        list.add(book1);
        list.add(book2);

        return list;
    }

    @POST
    @Path("/{isbn}/buy")
    public void buyBook(@PathParam("isbn")String isbn){
        quantityGrpcService.removeQuantity(QuantityNameRequest.newBuilder()
                .setIsbn(isbn)
                .setQuantityToRemove(1)
                .build());
    }



}
