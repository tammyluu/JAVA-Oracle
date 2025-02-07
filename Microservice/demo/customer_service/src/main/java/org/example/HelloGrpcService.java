package org.example;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class CustomerGrpcService implements CustomerGrpc {

    @Override
    public Uni<CustomerReply> sayCustomer(CustomerRequest request) {
        return Uni.createFrom().item("Customer " + request.getName() + "!")
                .map(msg -> CustomerReply.newBuilder().setMessage(msg).build());
    }

}
