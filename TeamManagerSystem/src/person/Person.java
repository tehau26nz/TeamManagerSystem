package person;

import javafx.scene.image.ImageView;

public class Person {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private ImageView profilePhoto;
	
	public Person() {
		
	}

	public String getFirstName() {
		// TODO - implement Person.getFirstName
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		// TODO - implement Person.getLastName
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		// TODO - implement Person.getEmailAddress
		return emailAddress;
	}

	/**
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		// TODO - implement Person.getPassword
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	public ImageView getProfilePhoto() {
		// TODO - implement Person.getProfilePhoto
		return profilePhoto;
	}

	/**
	 * 
	 * @param profilePhoto
	 */
	public void setProfilePhoto(ImageView profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

}