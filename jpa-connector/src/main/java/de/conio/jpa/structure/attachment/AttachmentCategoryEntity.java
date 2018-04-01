package de.conio.jpa.structure.attachment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.conio.jpa.structure.BaseEntity;

@Entity
@Table(name = "attachment_category")
public class AttachmentCategoryEntity extends BaseEntity{

	@Column(name = "name")
	private String name;

	public AttachmentCategoryEntity(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
