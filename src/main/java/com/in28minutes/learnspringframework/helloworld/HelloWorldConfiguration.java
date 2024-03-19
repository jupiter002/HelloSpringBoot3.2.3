package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person (String name, int age, Address address) { };


//Address - firstLine & city
record Address(String firstLine, String city) { };
@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
		
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address()); // name, age
		
		return person;
	}
	
	@Bean
	public Person person3Parameter(String name, int age, Address address3) {
		// name, age, address2
		var person = new Person(name, age, address3); // name, age
		
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Parameter(String name, int age, Address address) {
		// name, age, address2
		var person = new Person(name, age, address); // name, age
		
		return person;
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		// name, age, address2
		var person = new Person(name, age, address); // name, age
		
		return person;
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		var address = new Address("Baker Street", "London");
		
		return address;
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("Motinagar", "Hyperbad");
		
		return address;
	}
}