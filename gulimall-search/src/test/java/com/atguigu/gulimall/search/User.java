package com.atguigu.gulimall.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author JaChin
 * @version 1.0
 * @date 2022/06/27 10:23
 */
@Data
@Document(indexName = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String gender;
    private String age;
}
