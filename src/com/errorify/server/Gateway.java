package com.errorify.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import com.errorify.server.gen.ClosureService.Processor;
import com.errorify.server.ClosureServiceImpl;

public class Gateway {
	private void start() {
		try {
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(7911);
			Processor<ClosureServiceImpl> processor = new Processor<ClosureServiceImpl>(new ClosureServiceImpl());
			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).processor(processor));
			System.out.println("Starting server on port 7911 ...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Gateway srv = new Gateway();
		srv.start();
	}
}
