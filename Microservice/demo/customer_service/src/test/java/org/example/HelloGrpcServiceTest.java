package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
class CustomerGrpcServiceTest {
    @GrpcClient
    CustomerGrpc helloGrpc;

    @Test
    void testCustomer() {
        CustomerReply reply = helloGrpc
                .sayCustomer(CustomerRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
        assertEquals("Customer Neo!", reply.getMessage());
    }

}
