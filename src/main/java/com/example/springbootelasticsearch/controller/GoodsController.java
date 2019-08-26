package com.example.springbootelasticsearch.controller;

import com.example.springbootelasticsearch.entity.GoodsInfo;
import com.example.springbootelasticsearch.service.GoodsService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

/**
 * @author Sean
 * 2019/08/25
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/save")
    public String save(){
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(), "商品" + System.currentTimeMillis(), "改革春风吹满地，中国人民真争气");
        return goodsService.save(goodsInfo);
    }

    @GetMapping("/delete")
    public String delete(long id){
       return goodsService.delete(id);
    }

    @GetMapping("/update")
    public String update(long id, String name, String desc){
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setId(id);
        if(name != null){
            goodsInfo.setName(name);
        }
        if (desc != null){
            goodsInfo.setDesc(desc);
        }
        return goodsService.update(goodsInfo);
    }

    @GetMapping("/getOne")
    public GoodsInfo getOne(long id){
       return goodsService.getOne(id);
    }

    @GetMapping("/getAll")
    public List<GoodsInfo> getAll(){
        return goodsService.getAll();
    }

    private Integer PAGE_SIZE=10;
    @GetMapping("/getList")
    public List<GoodsInfo> getList(Integer pageNum, String query){
        //es默认页面从0开始
        if (pageNum == null){
            pageNum = 0;
        }
        SearchQuery entitySearchQuery = getEntitySearchQuery(pageNum, PAGE_SIZE, query);
       return goodsService.getList(entitySearchQuery);
    }

    private SearchQuery getEntitySearchQuery(int pageNum, int pageSize, String searchContent){
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(new SimpleQueryStringBuilder(searchContent)
                .field("name").field("desc"));
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return new NativeSearchQueryBuilder().withPageable(pageRequest).withQuery(functionScoreQueryBuilder).build();
    }
}
