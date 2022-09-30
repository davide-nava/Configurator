package com.configurator.Interfaces;

import com.configurator.Entities.ArticleTypeEntity;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IArticleTypeService extends IBaseService<ArticleTypeEntity> {
    List<LookupViewModel> getLookupViewModal() throws SQLException;

}