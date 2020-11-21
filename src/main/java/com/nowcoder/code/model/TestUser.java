package com.nowcoder.code.model;

/**
 * @author Pengfei Li
 * @date 2020/11/9
 */
public class TestUser {
    String id;
    String name;
    TestLevel level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestLevel getLevel() {
        return level;
    }

    public void setLevel(TestLevel level) {
        this.level = level;
    }
}
