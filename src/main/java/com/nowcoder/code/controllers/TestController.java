package com.nowcoder.code.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nowcoder.code.model.BoolTestInfo;
import com.nowcoder.code.model.Chen;
import com.nowcoder.code.model.TestInfo;
import com.nowcoder.code.model.TestUser;
import com.nowcoder.code.service.TestService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.DefValue;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/30
 */
@Path("")
public class TestController {
    @Autowired
    private TestService testService;
    @Get("/hello")
    public String test() throws Exception{
        return "test/error";
    }

    @Get("/flash1")
    public String flash1(Flash flash){
        flash.add("msg", "修改成功");
//        return "pr:/flash2";
        //重定向
        return "r:/flash2";
    }

    @Get("/flash2")
    public String flash2(Invocation inv, Flash flash){
        inv.addModel("info", flash.get("msg"));
        return "test/flash";
    }

    @Get("/upload")
    public String uploadRequest(){
        return "test/upload";
    }

    @Post("/upload")
    public String upload(@Param("file") MultipartFile file){
        if(file == null){
            return "/test/error";
        }
        String fileName = file.getOriginalFilename() == null? "null" : file.getOriginalFilename();
        //return "@upload " + file.getName() + " successfully";
        return "@upload " + fileName + " successfully";
    }
    @Get("/get-test")
    public String getTest(){
        TestInfo testInfo = testService.getTest();
        return "@Hello the No.\"" + testInfo.getId() + "\" is \"" + testInfo.getMsg() + "\"";
    }

    @Get("hello-velocity")
    public String helloVelocity(Invocation inv){
        inv.addModel("name", "velocity");
        return "test/helloVelocity";
    }

    /**
     * 测试是否支持boolean
     * @param id
     * @return
     */
    @Get("/booltest/{id:[0-9]+}")
    public String getBoolTest(@Param("id") int id) {
        System.out.println(id);
        BoolTestInfo boolTest = testService.getBoolTestInfo(id);
        return "@" + JSON.toJSONString(boolTest);
    }

    @Post("/param")
    public String param(Chen chen){
        return "@ParamResolverController: " + chen.getChen1() + ":" + chen.getChen2();
    }

    @Get("array")
    public String arrayTest(@Param("ids") int[] ids){
        StringBuilder res = new StringBuilder("@ID List: ");
        for(int id : ids){
            res.append(" " + id);
        }
        return res.toString();
    }

    @Get("map")
    public String mapTest(@Param("kv")Map<String, String> map){
        //http://localhost:8082/map?kv:%E8%B5%B5%E4%BA%91=%E8%9C%80%E5%9B%BD&kv:%E6%9B%B9%E6%93%8D=%E9%AD%8F%E5%9B%BD
        if(map == null){
            return "@Map is null";
        }
        StringBuilder res = new StringBuilder("@Map Content: ");
        for(Object key : map.keySet()){
            res.append(key + " " + map.get(key) + "\n");
        }
        return res.toString();
    }
    @Get("user")
    public String beanTest(TestUser user){ //注意没有@Param
        if(user == null){
            return "@user is null";
        }
        return "@User: " + JSON.toJSONString(user);
    }

    @Get("not-blank")
    public String notBlankTest(@NotBlank @Param("messages") String messages) throws Exception{
        return "@Input messages: " + messages;
    }

    /*
     * 3.7 controller层：门户必备portal支持

    @Get("portal-test")
    public String portalTest(Portal portal){
        portal.addWindow("p1", "/wp1");
        portal.addWindow("p2", "/wp2");
        return "test/portal";
    }
    @Get("/wp1")
    public String portal1() {
        return "@this is p1";
    }

    @Get("/wp2")
    public String portal2() {
        return "@this is p2";
    }
    */

    @Test
    public static void createStream_whenFindAnyResultIsPresent_thenCorrect() {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();
        System.out.println(result.isPresent() == false? "None" : result.get());
        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }

    @Test
    public static void createParallelStream_whenFindAnyResultIsPresent_thenCorrect(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num < 4).findAny();
        System.out.println();
        System.out.println(result.isPresent() == false? "None" : result.get());
        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is(1), is(2), is(3)));
    }

    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i < 3; i++){
            JSONObject config = new JSONObject();
            config.put("switch_power_default", false);
            config.put("test_channel_ids", "0,666");
            config.put("m_switch_power_default", false);
            config.put("m_test_channel_ids", "0,666");
            config.put("discuss_t_rec_ids", "763111005");
            Date now = new Date();
            System.out.println(now);
            System.out.println(config);
            jsonArray.add(config);
        }
        System.out.println(jsonArray);
        System.out.println(new Date(0));
        createParallelStream_whenFindAnyResultIsPresent_thenCorrect();
        System.out.println(new SimpleDateFormat("2030-12-31"));
    }
}
