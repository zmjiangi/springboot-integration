package com.gzyijian.task.restcontroller;

import com.gzyijian.task.restcontroller.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmjiangi
 * @date 2019-6-22
 */
@RestController
public class AsyncRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncRestController.class);


    @Autowired
    private AsyncService asyncService;

    /**
     * 返回实例信息
     *
     * @return
     */
    @GetMapping("/api/async/get")
    public ResponseEntity<String> get() {
        try {
            asyncService.get();
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取实例信息失败，{}", e);
            return ResponseEntity.badRequest().body("获取示例行行行失败");
        }
    }

}
