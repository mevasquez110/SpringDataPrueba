package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    private Long idReview;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "idItem")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
}
