package com.example.springbootelasticsearch.service.impl;

import com.example.springbootelasticsearch.dao.GoodsRepository;
import com.example.springbootelasticsearch.entity.GoodsInfo;
import com.example.springbootelasticsearch.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Sean
 * 2019/08/25
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public String save(GoodsInfo goodsInfo) {
        try {
            goodsRepository.save(goodsInfo);
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String delete(long id) {
        try {
            goodsRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String update(GoodsInfo goodsInfo) {
        try {
            goodsRepository.save(goodsInfo);
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public GoodsInfo getOne(long id) {
        try {
            Optional<GoodsInfo> optional = goodsRepository.findById(id);
            return optional.get();
        }catch (Exception e){
            e.printStackTrace();
        }
      return null;
    }

    @Override
    public List<GoodsInfo> getList(SearchQuery searchQuery) {
        try {
            Page<GoodsInfo> search = goodsRepository.search(searchQuery);
            return search.getContent();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
