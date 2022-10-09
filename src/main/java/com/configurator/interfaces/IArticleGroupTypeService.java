package com.configurator.interfaces;

import com.configurator.entities.ArticleGroupTypeEntity;
import com.configurator.viewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IArticleGroupTypeService extends IBaseService<ArticleGroupTypeEntity> {

    List<LookupViewModel> getLookupViewModel() throws SQLException;
}
