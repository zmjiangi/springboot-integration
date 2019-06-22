package com.gzyijian.elasticsearch.respository;

import com.gzyijian.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author zmjiangi
 * @date 2019-6-21
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    /**
     * 参照
     * https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
     *
     * @param name
     * @return
     */
    List<Book> findByNameLike(String name);

}
