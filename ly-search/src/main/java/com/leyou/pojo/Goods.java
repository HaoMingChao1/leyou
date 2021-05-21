package com.leyou.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2021/4/15 14:59
 * @Created by MingChao Hao
 */

@Data
@Document(indexName = "goods",shards = 1,replicas = 0)
public class Goods {

    @Id
    private Long id; //spuId

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String all; //所有需要被搜索的信息，标题，分类，品牌

    @Field(type = FieldType.Keyword,index = false)
    private String subTitle; //卖点

    private Long brandId; //品牌

    private Long cid1; //1级分类

    private Long cid2; //2级分类

    private Long cid3; //3级分类

    private Date createTime; //sup创建时间

    private Set<Long> price; // 价格

    @Field(type = FieldType.Keyword,index = false)
    private String skus; // sku信息的json结构

    private Map<String,Object> specs; // 可搜索的规格参数，key是参数名,值是参数想

}
