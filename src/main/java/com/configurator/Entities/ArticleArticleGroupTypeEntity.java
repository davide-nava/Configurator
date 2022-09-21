package com.configurator.Entites;

import java.util.UUID;

public class ArticleArticleGroupTypeEntity {

	private UUID articleArticleGroupTypeId = UUID.randomUUID();
	private UUID articleGroupTypeId = UUID.randomUUID();
private UUID  articleId = UUID.randomUUID();
private float qta = 1;

public UUID getArticleArticleGroupTypeId() {
	return articleArticleGroupTypeId;
}

public void setArticleArticleGroupTypeId(UUID articleArticleGroupTypeId) {
	this.articleArticleGroupTypeId = articleArticleGroupTypeId;
}

public UUID getArticleGroupTypeId() {
	return articleGroupTypeId;
}

public void setArticleGroupTypeId(UUID articleGroupTypeId) {
	this.articleGroupTypeId = articleGroupTypeId;
}

public UUID getArticleId() {
	return articleId;
}

public void setArticleId(UUID articleId) {
	this.articleId = articleId;
}

public float getQta() {
	return qta;
}

public void setQta(float qta) {
	this.qta = qta;
}
 
}
