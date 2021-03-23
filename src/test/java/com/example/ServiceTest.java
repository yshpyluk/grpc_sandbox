package com.example;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceTest {

	@Test
	public void test() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8686)
				.usePlaintext()
				.build();

		HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

		HelloResponse response = stub.hello(HelloRequest.newBuilder()
				.setFirstName("First")
				.setLastName("Last")
				.build());

		Assertions.assertEquals("Hello, First Last", response.getGreeting());
	}
}
