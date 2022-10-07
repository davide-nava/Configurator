package com.configurator.interfaces;

import com.configurator.entities.ArticleTypeEntity;
import com.configurator.viewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IArticleTypeService extends IBaseService<ArticleTypeEntity> {
    List<LookupViewModel> getLookupViewModel() throws SQLException;

}