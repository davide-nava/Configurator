package com.configurator.Interfaces;

import com.configurator.Entities.ArticleGroupTypeEntity;
import com.configurator.ViewModels.LookupViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IArticleGroupTypeService extends IBaseService<ArticleGroupTypeEntity> {
    List<LookupViewModel> getLookupViewModel() throws SQLException;
}
