package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Address(String FirstLine, String city) {};
record Person (String name, int age, Address address) {};
@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Shubham";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	@Primary
	public Person person() {
		return new Person("Ravi", 18, new Address("Main Streen", "Utrecht"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address) {
		return new Person(name, age, address);
	}
	
	@Bean
	public Person person4Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {
		return new Person(name, age, address);
	}
	
	@Bean
	@Primary
	public Address address() {
		return new Address ("Bakers Street", "London");
	}
	
	@Bean(name="address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address ("Mumbai", "Maharashtra");
	}
}
