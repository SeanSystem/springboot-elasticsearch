package com.example.springbootelasticsearch.service;

import com.example.springbootelasticsearch.entity.GoodsInfo;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

/**
 * @author Sean
 * 2019/08/25
 */
public interface GoodsService {

    String save(GoodsInfo goodsInfo);

    String delete(long id);

    String update(GoodsInfo goodsInfo);

    GoodsInfo getOne(long id);

    List<GoodsInfo> getList(SearchQuery searchQuery);
}
