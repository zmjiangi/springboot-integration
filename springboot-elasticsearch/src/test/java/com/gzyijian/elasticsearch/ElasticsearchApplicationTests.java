package com.gzyijian.elasticsearch;

import com.gzyijian.elasticsearch.bean.Article;
import com.gzyijian.elasticsearch.bean.Book;
import com.gzyijian.elasticsearch.respository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author zmjiangi
 * @date 2019-6-21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test02() {
//		Book book = new Book();
//		book.setId(1);
//		book.setName("西游记");
//		book.setAuthor("吴承恩");
//		bookRepository.index(book);

        for (Book book : bookRepository.findByNameLike("游")) {
            System.out.println(book);
        }
    }


    @Test
    public void contextLoads() {
        //1、给Es中索引（保存）一个文档；
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello World");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("gzyijian").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试搜索
     */
    @Test
    public void search() {

        // 查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"解散了\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        // 更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
        // 构建搜索功能
        Search search = new Search.Builder(json).addIndex("gzyijian").addType("news").build();

        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
