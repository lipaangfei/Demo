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
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

        String s = "-2222-3333-4444-5555-";
        System.out.println(s.split("-").length);
        for(String sub : s.split("-")){
            System.out.print(sub + ", ");
        }
        System.out.println();
        String str = ",a,b,,";
        String [] strLst = str.split(",", 0);
        System.out.println(strLst.length);
        for (String e : strLst) {
           System.out.println(e);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            Date date1 = sdf.parse("2020-11-30 12:25:09");
            System.out.println(date1.getTime());
            System.out.println(System.currentTimeMillis());
        }catch (Exception e){

        }

        // 10位的秒级别的时间戳
        long time1 = 1606710309L;
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time1 * 1000);
        System.out.println("10位数的时间戳（秒）--->Date:" + result1);
        Date date1 = new Date(time1*1000);   //对应的就是时间戳对应的Date
        // 13位的秒级别的时间戳
        long time2 = 1606710309366L;
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time2);
        System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
        System.out.println(new Date());

        long time3 = 1606710309366000L;
        long time4 = 1606905926800000L;
        System.out.println("13位数的时间戳（毫秒）--->Date:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time3/1000));
        System.out.println("13位数的时间戳（毫秒）--->Date:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time4/1000));
        System.out.println(System.currentTimeMillis() * 1000);
        System.out.println(System.currentTimeMillis());

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        changeList(list);
        System.out.println(list);
        list = changeList2(list);
        System.out.println(list);

        String format = "%s_牛客专刊";
        System.out.println(String.format(format, "ASDF"));

        //collectionMapTest();
        //linkedHashSet();
        //linkedHashMap();
        multiMapTest();
        VALUES[0] = new Integer(2);
        System.out.println(VALUES[0]);
        BigInteger bigInteger = new BigInteger("1234567890123456789");
        BigInteger bigInteger2 = new BigInteger("-1234567890123456789");
        StringBuilder sb = new StringBuilder("");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "12");
        System.out.println(jsonObject.get("gender"));
        try {
            FileWriter fw = new FileWriter("/Users/lipengfei/Desktop/res.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("你好");
            bw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        regExpressionTest();
    }
    private static void regExpressionTest(){
        String pattern = "题霸-.*企业题库";
        String name = "题霸-企业题库";
        String t = "剑指OffEr";
        System.out.println(t.toLowerCase());
        System.out.println(Pattern.matches(pattern, name));
        System.out.println(String.format("CodingSubmissionService#getCodingProblemCntOfRecentNDays, " +
                " userId = %s, n = %d, e = %s", Long.MAX_VALUE, 10, "ASFASD"));

    }
    public static final Integer[] VALUES = { new Integer(1)};

    private static void collectionMapTest(){
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(1, 100));
        pairs.add(new Pair(2, 99));
        pairs.add(new Pair(3, 98));

        List<Integer> aList = pairs.stream().map(Pair::getA).collect(Collectors.toList());
        System.out.println(aList);
    }
    private static void linkedHashSet(){
        // 创建集合
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1,1,2,2,4,5, 5, 6));
        LinkedHashSet<Integer> distinctSet = new LinkedHashSet<>(list);
        List<Integer> distinctList = new ArrayList<>(distinctSet);
        System.out.println(distinctList);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        // 创建并添加元素
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
//        linkedHashSet.add("java");
//        linkedHashSet.add("java");
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
        linkedHashSet.add("java");
        linkedHashSet.add("hello");

        // 便利结合
        for (String s : linkedHashSet) {
            System.out.println(s);
        }

    }

    private static void linkedHashMap(){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        System.out.println(map.values());
    }
    private static void changeList(List<Integer> list) {
        list = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        list.set(0,5);
        list.add(4);
    }
    private static List<Integer> changeList2(List<Integer> list) {
        list = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        list.set(0,5);
        list.add(4);
        return list;
    }

    private static void multiMapTest(){
        MultiMap map = new MultiValueMap();
        map.put(1, 2);
        map.put(1, 3);
        map.put(2, 5);
        map.put(2, 6);
        System.out.println(map.get(1));
        BigInteger bigInteger = new BigInteger("0");
//        Multimap<Integer, Integer> map = new Multimap<>();
//        map.put(1, 2);
//        map.put(1, 3);
//        map.put(2, 5);
//        map.put(2, 6);
//        System.out.println(map.get(1));

    }
    static class Pair{
        int a;
        int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
