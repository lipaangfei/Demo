package com.nowcoder.code.test._1;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashSet;

/**
 * @author Pengfei Li
 * @date 2020/12/22
 */
public class TestJSON {
    public static void main(String[] args) {
        String str = "{\n" +
                "  \"viewName\": \"ta_templates_tow_column_right.vm\",\n" +
                "  \"title\": \"九章算法\",\n" +
                "  \"url\": \"nine-chapter\",\n" +
                "  \"groupId\": 1,\n" +
                "  \"modules\": [\n" +
                "    {\n" +
                "      \"name\": \"banner\",\n" +
                "      \"layout\": \"top\",\n" +
                "      \"context\": {\n" +
                "        \"url\": \"https://static.nowcoder.com/images/banner/offer-v2.png\",\n" +
                "        \"color\": \"#fdbe7a\",\n" +
                "        \"shareData\": {\n" +
                "          \"weiboUrl\": \"http://service.weibo.com/share/share.php?url=http%3A%2F%2Fwww.nowcoder.com%2Fta%2Fnine-chapter&appkey=&title=BAT%E7%BB%8F%E5%85%B8%E9%9D%A2%E8%AF%95%E9%A2%98%E5%A4%A7%E5%90%88%E9%9B%86%EF%BC%8C%E4%BA%86%E8%A7%A3%E9%9D%A2%E8%AF%95%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98%E5%8F%8A%E8%80%83%E5%AF%9F%E7%82%B9%EF%BC%8C%E8%BD%AC%E7%BB%99%E9%9C%80%E8%A6%81%E7%9A%84%E7%A8%8B%E5%BA%8F%E7%8C%BF%E4%BB%AC~%EF%BC%88%E9%A2%98%E7%9B%AE%E6%9D%A5%E8%87%AA%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%EF%BC%89%20%E5%88%86%E4%BA%AB%E6%9D%A5%E8%87%AA%20%40%E7%89%9B%E5%AE%A2%E7%BD%91&pic=http%3A%2F%2Fstatic.nowcoder.com%2Fimages%2Fjiuzhang_algorithm_share.png&ralateUid=&language=zh_cn\",\n" +
                "          \"qqUrl\": \"http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?desc=BAT%E7%BB%8F%E5%85%B8%E9%9D%A2%E8%AF%95%E9%A2%98%E5%A4%A7%E5%90%88%E9%9B%86%EF%BC%8C%E4%BA%86%E8%A7%A3%E9%9D%A2%E8%AF%95%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98%E5%8F%8A%E8%80%83%E5%AF%9F%E7%82%B9%EF%BC%8C%E8%BD%AC%E7%BB%99%E9%9C%80%E8%A6%81%E7%9A%84%E7%A8%8B%E5%BA%8F%E7%8C%BF%E4%BB%AC~%EF%BC%88%E5%88%86%E4%BA%AB%E8%87%AA%40%E7%89%9B%E5%AE%A2%E7%BD%91%EF%BC%89&title=&summary=&url=http%3A%2F%2Fwww.nowcoder.com%2Fta%2Fnine-chapter&site=%40%E7%89%9B%E5%AE%A2%E7%BD%91&pics=http%3A%2F%2Fstatic.nowcoder.com%2Fimages%2Fjiuzhang_algorithm_share.png&picSep=%7C&images=http%3A%2F%2Fstatic.nowcoder.com%2Fimages%2Fjiuzhang_algorithm_share.png\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"breadcrumb\",\n" +
                "      \"context\": {\n" +
                "        \"middlePathUrl\": \"http://www.nowcoder.com/activity/topics\",\n" +
                "        \"middlePathTitle\": \"精华专题\",\n" +
                "        \"title\": \"九章算法\"\n" +
                "      },\n" +
                "      \"layout\": \"middle\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"pageIntro\",\n" +
                "      \"layout\": \"left\",\n" +
                "      \"context\": {\n" +
                "        \"pageName\": \"九章算法介绍\",\n" +
                "        \"intro\": \"本套面试题由@九章算法 友情提供。九章算法致力于帮助更多中国人找到好工作，由美国硅谷顶尖IT企业一线工程师提供算法培训、面试咨询等服务。官网：<a target='_blank' href='/jump?url=http://www.jiuzhang.com/?source=nowcoder'>http://www.jiuzhang.com</a>。\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"questionReviewList\",\n" +
                "      \"layout\": \"left\",\n" +
                "      \"context\": {\n" +
                "        \"terminalUrl\": \"/ta/nine-chapter/review\"\n" +
                "      },\n" +
                "      \"dataProviders\": [\n" +
                "        {\n" +
                "          \"name\": \"questionList\",\n" +
                "          \"data\": [\n" +
                "            {\n" +
                "              \"uuid\": \"9602083ec8d749999d86adf8a725b4f7\",\n" +
                "              \"knowledgePoint\": \"笔/面试风格及准备\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"622c33101a574073b039486dadfe51e6\",\n" +
                "              \"knowledgePoint\": \"笔/面试风格及准备\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"c5e53c4e83aa49b68333391101818348\",\n" +
                "              \"knowledgePoint\": \"笔/面试风格及准备\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"ea2cf19557d546819d7fde300daeabb1\",\n" +
                "              \"knowledgePoint\": \"笔/面试风格及准备\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"359d6869d5ce4738bf9c9a42b67d9568\",\n" +
                "              \"knowledgePoint\": \"笔/面试风格及准备\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"c2c3fef0724c4a2f8a795c3cfd70a08c\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"15be363c213f437081abf0b31b727951\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"67327d4f4cfc4f02a4bb704e6aa759b9\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"0a584aa13f804f3ea72b442a065a7618\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"0482d89ea4d34032ab89a72807aa4abf\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"61987bb9e369427282eb50f9d753fb42\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"a60c01a7c4ab473e81218ed0b333b4e6\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"2f04608344924b929d6a09dc00166d3b\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"84c6de43ca954bbbb5581d9cfbb60431\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"3dcc1dc72db540a4911f17252b84fb7f\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"bf4cff1d1ea44d0484c5cb861e089181\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"a69abbf329e44936905ba7b59baef427\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"f5fa2ec556a94f908a297e57f0eb8944\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"7286b3e51b0a4d298c94fd528690afe7\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(上)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"60d5946e22644ddea1268b7d56d7fb50\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"1f67d4e2b6134c298e993e622181b333\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"db1ba7ce821948538b89f43da60be37c\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"e399e983f44c49c49993c41c033615cd\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"83e15a38ab63422ca6aa0029a265e7dd\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"4ef1d67edee049c78aa597067c519246\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"638f798ac0da4a89a0c3e893f62d5376\",\n" +
                "              \"knowledgePoint\": \"C/C++基础(下)\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"a995ca30fb44421b846c6c687b3c6ca5\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"b2f0ce3ae24a469d96af62adfddcddf7\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"336639d0afb74c319e3edfe2d1cfd089\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"e6d92bae51244b6e84b0608795d0d5f7\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"ae5c42434cd44d02b800bea070f31c3b\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"d8a4a3f52d4943c0864caa7c1eb972a7\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"1f9c23d0264a4630b3b996aaf2b931d0\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"20a6657b0e27474f9213bd7e97a93908\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"46213138ad38447ca2c28a77d366b32a\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"c39aaa04981544518b125da654fd5f26\",\n" +
                "              \"knowledgePoint\": \"智力题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"12796031452e4ced8a16255bb02c4168\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"444788e2fc3649888a16798da9b46094\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"09dfb22254ae49a994f17b001c2905a3\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"61299e2423254c5e807ec80caad22fd1\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"ebc56ba3b42c4f4eb2dfd2b8295a1c4d\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"7de04ff772f54dabb1facc69c6384261\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"bfa0b0796e1847c8b36f96ad1614d4d0\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"43698554cdc04456ac6fb81331581a52\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"7b598dfdf0574c109e3a63411d91fde3\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"6eee35cb516041b38322fac49406620f\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"3147a7b0cd174879bed8d555081376a2\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"b1abf79bf9c34f1b9828fd644fefb10d\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"5aae63b290c542f0ab0582d293e6c791\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"eb5380afce4d478e88cc215a0b194862\",\n" +
                "              \"knowledgePoint\": \"概率题与操作系统题\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"e353d10363a54b21ac6a7b49c7fdf064\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"ef396ef8bcba4dcab6ed04c6b1ab60e1\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"2036b155b9c442c1ae2335e881a12f30\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"8006ac33cb964c54bad92ab7b6391fad\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"842e5950db9544878e8930ae05fef4f5\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"73119166fe4b4c4e9f14ae828bbca0c5\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"bbb87bcb874b4195b7f1fe0d734b4159\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"36694b70866c4964b071aa19363bbd90\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"58c629948fe64d1ea150691ca8e6849b\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"e46de601e83f4fa89feb1abccc0e667e\",\n" +
                "              \"knowledgePoint\": \"面向对象及数据结构设计\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"4879439a1e444e8ebff2232d206e05e7\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"689927a367c54bafa5c9435318506a62\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"cdd98d9efb2547b2bfab4ec96a63f22e\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"982c9c8319ea4d66a28321b488d7b6d3\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"4d52821ef8d84ba6b0eb08d5ce78410d\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"75f183c1394e4d07aa96b990b2efe63a\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"ff4c9589b31c48e099a6840f7e4b6989\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"0434b1eac93d42cab4e67713648ed200\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"uuid\": \"c450905d39224b898367b92197f8ed97\",\n" +
                "              \"knowledgePoint\": \"大数据\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"adTopics\",\n" +
                "      \"layout\": \"right\",\n" +
                "      \"dataProviders\": [\n" +
                "        {\n" +
                "          \"name\": \"adTopics\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject json = JSONObject.parseObject(str);
        System.out.println(json.getString("title"));

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(4);
        linkedHashSet.add(4);
        linkedHashSet.add(3);
        System.out.println(linkedHashSet);

        String ids = "3695\n" +
                "3724\n" +
                "3717\n" +
                "3721\n" +
                "3720\n" +
                "3708\n" +
                "3694\n" +
                "3700\n" +
                "3701\n" +
                "3722\n" +
                "3712\n" +
                "3716\n" +
                "3723\n" +
                "3703\n" +
                "3725\n" +
                "3706\n" +
                "3732\n" +
                "3709\n" +
                "3718\n" +
                "3707\n" +
                "3729\n" +
                "3719\n" +
                "3728\n" +
                "3715\n" +
                "3693\n" +
                "3692\n" +
                "3730\n" +
                "3710\n" +
                "3702\n" +
                "3698\n" +
                "3711\n" +
                "3727\n" +
                "3735\n" +
                "3697\n" +
                "3699\n" +
                "3696\n" +
                "3713\n" +
                "3733\n" +
                "3689\n" +
                "3714\n" +
                "3690\n" +
                "3734\n" +
                "3705\n" +
                "3726\n" +
                "3691\n" +
                "3704\n" +
                "3687\n" +
                "3688\n" +
                "3731\n" +
                "3736\n" +
                "3737\n" +
                "3738\n" +
                "3739\n" +
                "3740\n" +
                "3741\n" +
                "3742\n" +
                "3743\n" +
                "3744\n" +
                "3746\n" +
                "3745\n" +
                "3747\n" +
                "3748\n" +
                "3749\n" +
                "3750\n" +
                "3751\n" +
                "3752\n" +
                "53299";

        ids = ids.replaceAll("\n", ",");
        System.out.println(ids);
    }
}
