package dol;

import java.util.UUID;

//las clases abstractas no se pueden instanciar.
public abstract class Person {
	
	private UUID Id;
	private String firstName1;
	private String secondName2;
	private String Lastname1;
	private String Lastname2;
	
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getFirstName1() {
		return firstName1;
	}
	public void setFirstName1(String firstName1) {
		this.firstName1 = firstName1;
	}
	public String getSecondName2() {
		return secondName2;
	}
	public void setSecondName2(String secondName2) {
		this.secondName2 = secondName2;
	}
	public String getLastname1() {
		return Lastname1;
	}
	public void setLastname1(String lastname1) {
		Lastname1 = lastname1;
	}
	public String getLastname2() {
		return Lastname2;
	}
	public void setLastname2(String lastname2) {
		Lastname2 = lastname2;
	}
	
	

}