package com.helen.belt.models;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=2,max=200,message="First Name should be between 2~200")
    private String firstName;
    private String lastName;
    

 


	//validation
    @Email
    private String email;
    @Size(min=2,max=200,message="Password should be between 2~200")
    private String password;
    @NotBlank  
    @Transient
    private String passwordConfirmation;
 



    @Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
    
	//one user create many ratings
	@OneToMany(mappedBy = "ratingCreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TvRating> ratingsCreated;
	//one user create many shows
	@OneToMany(mappedBy = "showCreator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Show> showsCreated;
	


    

 

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


	public List<TvRating> getRatingsCreated() {
		return ratingsCreated;
	}
	public void setRatingsCreated(List<TvRating> ratingsCreated) {
		this.ratingsCreated = ratingsCreated;
	}
	public List<Show> getShowsCreated() {
		return showsCreated;
	}
	public void setShowsCreated(List<Show> showsCreated) {
		this.showsCreated = showsCreated;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public User() {
	}

	
    
}
