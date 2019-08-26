package com.example.springbootelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

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

    @Id
    private long id;
   // @Field(analyzer = "ik_smart" )
    private String name;
   // @Field(analyzer = "ik_smart" )
    private String desc;
}
