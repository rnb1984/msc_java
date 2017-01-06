package queues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Person {
private boolean female;
private int age;
private String firstName;
private String lastName;

public Person(boolean f, int a, String fn, String ln){
	female = f;
	age = a;
	firstName=fn;
	lastName = ln;
	
}

public boolean isFemale() {
	return female;
}

public void setFemale(boolean female) {
	this.female = female;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String toString(){
	return("(" + female + "," + age + "," + firstName + "," + lastName + ")");
}




}
