package org.garen.mc.service;

import org.garen.mc.mybatis.domain.Article;
import org.garen.mc.mybatis.domain.Board;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylm on 2017/9/15.
 */
@Service
public class ArticleManager extends BaseManage<Integer> {
    private static final String GET_HOT_SUCCESS = "查询热门成功";
    @Override
    public <T, Q> CommonsService<T, Q, Integer> getService() {
        return null;
    }

    public SuccessModel getHotByBoard(String boardCode) {
        List<Article> articles=new ArrayList<>();
        articles.add(new Article());
        return new SuccessModel().message(GET_HOT_SUCCESS).data(articles);
    }
}
