package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some Initilization Logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan
public class LazyInitilizationLauncherApplication {
	

	public static void main(String[] args) {
		
		try (var context = new AnnotationConfigApplicationContext
				(LazyInitilizationLauncherApplication.class)) {
			
			System.out.println("Initilization is done");
			context.getBean(ClassB.class).doSomething();
			
		}
		

	}

}
