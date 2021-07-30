package com.nowcoder.code.test;

import java.util.*;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author Pengfei Li
 * @date 2021/3/25
 */
public class GenerateNowcoderAccount {
    class TrieNode {
        private String name;
        private TreeMap<String, TrieNode> children;
        private boolean isDirectory;
        private StringBuilder content;

        public TrieNode(String name, boolean isDirectory) {
            this.name = name;
            children = new TreeMap<>();
            this.isDirectory = isDirectory;
        }

        public boolean isDirectory() {
            return isDirectory;
        }

        public void append(String content) {
            this.isDirectory = false;
            this.content.append(content);
        }

        public String getContent() {
            return this.content.toString();
        }
    }

    class FileSystem {
        TrieNode root;

        public FileSystem() {
            this.root = new TrieNode("", true);
        }

        public String[] parsePath(String path) {
            return path.split("/");
        }

        public TrieNode getNode(String[] pathNames) {
            TrieNode node = this.root;
            for (int i = 1; i < pathNames.length; i++) {
                if (!node.children.containsKey(pathNames[i])) {
                    TrieNode newNode = new TrieNode(pathNames[i], true);
                    node.children.put(pathNames[i], newNode);
                }
                node = node.children.get(pathNames[i]);
            }
            return node;
        }

        public List<String> ls(String path) {
            String[] pathNames = this.parsePath(path);
            TrieNode node = this.getNode(pathNames);
            List<String> ans = new ArrayList<>();
            for (String key : node.children.keySet()) {
                ans.add(key);
            }
            return ans;
        }

        public void mkdir(String path) {
            String[] pathNames = this.parsePath(path);
            this.getNode(pathNames);
        }

        public void addContentToFile(String filePath, String content) {
            String[] pathNames = this.parsePath(filePath);
            TrieNode node = this.getNode(pathNames);
            node.append(content);
        }

        public String readContentFromFile(String filePath) {
            String[] pathNames = this.parsePath(filePath);
            TrieNode node = this.getNode(pathNames);
            return node.getContent();
        }
    }

    /**
     * Your FileSystem object will be instantiated and called as such: FileSystem obj = new
     * FileSystem(); List<String> param_1 = obj.ls(path); obj.mkdir(path);
     * obj.addContentToFile(filePath,content); String param_4 = obj.readContentFromFile(filePath);
     */

    public static void main(String[] args) {
        long id;

        String formatSql = "INSERT INTO user_basic_info (id, pwd, nickname, tinny_header_url, main_header_url, large_header_url, register_time, type, status, email, introduction, work_info, education_info, live_place, gender, phone, login_type, honor_level, honor_score, money_balance, money_total, continuous_login_day, register_client,  anonymous, source_uid, encrypt_password) VALUES (%s, '', '', null, null, null, '2020-12-24 14:21:16', 4, 0, '%s', null, null, null, null, null, '%s', 7, %s, %s, 0, 0, 0, 0, 0, 0, '383765f0c25c64210dccc2b43f40a73e08072063483a590d2dd1f2f12e4b24a5ca9df9e9d52c4dcaec36f8afefeb966cee549aaef023a42ccd7d664faea393feaf3e6fb3267b6fc5d65bc9466b059f9e');";
        List<Long> uidList = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        int beginEmail = 4836;
        for (int i = 0; i < 450; i++) {
            long uid = RandomUtils.nextLong(52343435L, 88878777L);
            uidList.add(uid);
            int emailPrefix = beginEmail++;
            String email = emailPrefix + "@nowcoder.com";
            emailList.add(email);
            String phone = "1500000" + emailPrefix;
            int level = RandomUtils.nextInt(2, 5);
            int honorLevel = 0;
            switch (level) {
                case 2:
                    honorLevel = RandomUtils.nextInt(13, 26);
                    break;
                case 3:
                    honorLevel = RandomUtils.nextInt(28, 81);
                    break;
                case 4:
                    honorLevel = RandomUtils.nextInt(80, 151);
                    break;
                default:
                    honorLevel = 66;
            }
            String sql = String.format(formatSql, uid, email, phone, level, honorLevel);

            System.out.println(sql);
        }
        for (int i = 0; i < 450; i++) {
            System.out.println(uidList.get(i) + "," + emailList.get(i));
        }

        System.out.println(uidList);
    }
}
