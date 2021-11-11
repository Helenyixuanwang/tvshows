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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity

@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    
    @NotNull
    private String network;
    
    @NotNull
    private String description;
    
    @Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	//many shows created by one user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User showCreator;
	

	


	//one show has many ratings
	@OneToMany(mappedBy = "showHasRating", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TvRating> ratingsCreatedForShow;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	public User getShowCreator() {
		return showCreator;
	}
	public void setShowCreator(User showCreator) {
		this.showCreator = showCreator;
	}
	public List<TvRating> getRatingsCreatedForShow() {
		return ratingsCreatedForShow;
	}
	public void setRatingsCreatedForShow(List<TvRating> ratingsCreatedForShow) {
		this.ratingsCreatedForShow = ratingsCreatedForShow;
	}
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	
	
	public Show() {
	}


	
	
    
}
