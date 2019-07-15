package com.qch.shop.mapper;

import com.qch.shop.model.entity.Log;
import com.qch.shop.model.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Log Mapper
 *
 * @author Qiu Chenhao
 * @date 2019-07-15
 */
@Component
@Mapper
public interface LogMapper {
    /**
     * add log
     *
     * @param log add log object
     */
    @Insert("insert into log(username, operation, time, method, params, ip, create_time) values" +
            "(#{username}, #{operation}, #{time}, #{method}, #{params}, #{id}, #{createTime})")
    void add(Log log);


}
