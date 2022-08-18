package com.cyzc.elasticsearch;

import com.cyzc.elasticsearch.entity.UserInfo;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/07/26 18:43]
 */
@SpringBootTest()
public class SpringbootElasticsearchApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    public RestHighLevelClient restHighLevelClient;

    /**
     * judge index exists
     *
     * @author cyzc
     * @since 2022/7/26 20:36
     */
    @Test
    public void testIndexIsExists() throws IOException {
        GetIndexRequest request = new GetIndexRequest("userinfo");
        IndicesClient indices = restHighLevelClient.indices();
        boolean exists = indices.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);// 索引是否存在
        restHighLevelClient.close();
    }

    @Test
    public void testSearch() throws IOException {

        SearchRequest request = new SearchRequest("userinfo");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "gx");
        builder.query(termQueryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getHits());
        System.out.println("=======================");
        for (SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            sourceAsMap.forEach((k, v) -> {
                System.out.println(k);
                System.out.println(v);
            });
        }
    }

    @Test
    void testBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout("10s");

        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setName("春意暂迟1");
        userInfo1.setHobby("跑步,踢球,打游戏,看书");
        userInfo1.setAddress("山东省临沂市兰山区");
        userInfo1.setAge(25L);
        userInfo1.setEmail("1021981208@qq.com");
        userInfo1.setPhone("17806254787");

        list.add(userInfo1);

        Gson gson = new Gson();
        String s = gson.toJson(list.get(0));
        System.out.println(s);
        request.add(
                new IndexRequest("userinfo").id("20").source(s,
                        XContentType.JSON)
        );

        BulkResponse responses = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(responses.hasFailures());
    }

    @Test
    void testGetDocInfo() throws IOException {
        GetRequest userinfo = new GetRequest("userinfo", "1");
        Gson gson=new Gson();
        //testdb.fetchSourceContext(new FetchSourceContext(true));
        GetResponse response=restHighLevelClient.get(userinfo,RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        System.out.println(sourceAsString);
        System.out.println(gson.fromJson(sourceAsString,UserInfo.class));


        System.out.println(response);
    }

    @Test
    void testGetDocInfo2() throws IOException {
        GetRequest userinfo = new GetRequest("bank", "1");
        Gson gson=new Gson();
        //testdb.fetchSourceContext(new FetchSourceContext(true));
        GetResponse response=restHighLevelClient.get(userinfo,RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        System.out.println(sourceAsString);
        //System.out.println(gson.fromJson(sourceAsString,UserInfo.class));


        System.out.println(response);
    }

}
