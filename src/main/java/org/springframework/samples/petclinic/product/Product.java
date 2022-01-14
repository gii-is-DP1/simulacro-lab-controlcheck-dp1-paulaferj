package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "product")
public class Product extends BaseEntity{
    

    @NotNull
    @Size(min=3, max=50)
    @Column(name="name")
	String name;
    
    @NotNull
    @Min(0)
    @Column(name="price")
	double price;
    
    @ManyToOne
    @NotNull
	@JoinColumn(name = "type_id")
	ProductType productType;
}
