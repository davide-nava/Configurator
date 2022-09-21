package com.configurator.Entites;

import java.util.UUID;

public class ArticleMachineTypeEntity {

	private UUID articleMachineTypeId = UUID.randomUUID();
	private UUID articleId = UUID.randomUUID();
	private UUID machineTypeId = UUID.randomUUID();
private float qta = 1;

public UUID getArticleMachineTypeId() {
	return articleMachineTypeId;
}

public void setArticleMachineTypeId(UUID articleMachineTypeId) {
	this.articleMachineTypeId = articleMachineTypeId;
}

public UUID getArticleId() {
	return articleId;
}

public void setArticleId(UUID articleId) {
	this.articleId = articleId;
}

public UUID getMachineTypeId() {
	return machineTypeId;
}

public void setMachineTypeId(UUID  machineTypeId) {
	this.machineTypeId = machineTypeId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public float getQta() {
	return qta;
}

public void setQta(float  qta) {
	this.qta=qta;
} 
}
