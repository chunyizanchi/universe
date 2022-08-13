package com.cyzc.java.bug;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cyzc.java.entity.LuaResult;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/06/15 10:36]
 */
@Slf4j
public class FastJsonBug {
    public static void main(String... args) throws Exception {
        try {
            String json = "{\"code\":\"00\",\"msg\":\"成功\",\"data\":{\"xxx\":21,\"yyy\":5}}";
            LuaResult result = JSON.parseObject(json, LuaResult.class);
            System.out.println(result);
        }catch (Exception e){
            log.error("出错了", e);
        }

        try {
            String json1 = "{\"msg\":\"成功\",\"data\":\"31\",\"code\":\"00\"}";
            LuaResult<Integer> result = JSON.parseObject(json1, new TypeReference<LuaResult<Integer>>(){});
            System.out.println(result);
        }catch (Exception e){
            log.error("出错了", e);
        }

        //上面2个没问题，到执行第三段的时候，就会必现
        try {
            String json = "{\"code\":\"00\",\"msg\":\"成功\",\"data\":{\"xxx\":21,\"yyy\":5}}";
            LuaResult result = JSON.parseObject(json, LuaResult.class);
            System.out.println(result);
        }catch (Exception e){
            log.error("出错了", e);
        }
    }
}
