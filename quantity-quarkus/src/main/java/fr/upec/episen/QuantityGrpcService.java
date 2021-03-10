package fr.upec.episen;

import fr.upec.episen.proto.QuantityGrpc;
import fr.upec.episen.proto.QuantityNameReply;
import fr.upec.episen.proto.QuantityNameRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;


@Singleton
public class QuantityGrpcService extends QuantityGrpc.QuantityImplBase {

    private QuantityGrpc.QuantityBlockingStub quantityGrpcService;

    @Override
    public void getQuantity(QuantityNameRequest request, StreamObserver<QuantityNameReply> responseObserver) {
        String isbn = request.getIsbn();
        int quantity ;

        switch (isbn){
            case "978-2070541270":
                quantity = 9;
                break;
            case "978-2070541271":
                quantity = 12;
                break;
            case "978-2070541272":
                quantity = 5;
                break;
            default:
                quantity = -1;
                break;
        }

        responseObserver.onNext(QuantityNameReply
            .newBuilder()
                .setQuantity(quantity)
                .build()
        );

        responseObserver.onCompleted();
    }


    @Override
    public void removeQuantity(QuantityNameRequest request, StreamObserver<QuantityNameReply> responseObserver){
        String isbn = request.getIsbn();
        int quantityToRemove = request.getQuantityToRemove();
        int quantity = quantityGrpcService.getQuantity(
                QuantityNameRequest.newBuilder()
                        .setIsbn(isbn)
                        .build()).getQuantity();
        responseObserver.onNext(QuantityNameReply
                .newBuilder()
                .setQuantity(quantity - quantityToRemove)
                .build()
        );
    }
}
