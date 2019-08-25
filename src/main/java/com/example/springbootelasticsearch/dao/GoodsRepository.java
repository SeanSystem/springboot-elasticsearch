package com.example.springbootelasticsearch.dao;

import com.example.springbootelasticsearch.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品
 *
 * @author Sean
 * 2019/08/25
 */
@Repository
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {
}
