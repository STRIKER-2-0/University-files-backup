package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class HelloUAService implements IHello {

	@Override
	public void sayHello() {
		System.out.println("Say Hello UA");
	}

}
