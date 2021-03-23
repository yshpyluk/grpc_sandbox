package com.example.service;

import com.example.grpc.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = ServerBuilder
				.forPort(8686)
				.addService(new HelloServiceImpl()).build();

		server.start();
		server.awaitTermination();
	}
}
