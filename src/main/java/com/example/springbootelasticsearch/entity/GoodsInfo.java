package com.example.springbootelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 商品
 *
 * @author Sean
 * 2019/08/25
 */
@Document(indexName = "testgoods",type = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsInfo implements Serializable {

    private long id;

    private String name;

    private String desc;
}
