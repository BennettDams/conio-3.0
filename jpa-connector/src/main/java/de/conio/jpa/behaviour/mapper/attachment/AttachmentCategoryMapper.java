package de.conio.jpa.behaviour.mapper.attachment;

import de.conio.core.structure.AttachmentCategory;
import de.conio.jpa.structure.attachment.AttachmentCategoryEntity;

public class AttachmentCategoryMapper {

	public static AttachmentCategory convert2AttachmentCategory (AttachmentCategoryEntity entity) {
		AttachmentCategory attachmentCategory = new AttachmentCategory();
		attachmentCategory.setCreateTime(entity.getCreateTime());
		attachmentCategory.setLastModified(entity.getLastModified());
		attachmentCategory.setName(entity.getName());
		
		return attachmentCategory;
	}
	
	public static AttachmentCategoryEntity convert2AttachmentEntity(AttachmentCategory attachmentCategory) {
		AttachmentCategoryEntity entity = new AttachmentCategoryEntity();
		entity.setCreateTime(attachmentCategory.getCreateTime());
		entity.setLastModified(attachmentCategory.getLastModified());
		entity.setName(attachmentCategory.getName());
		
		return entity;
	}
}
