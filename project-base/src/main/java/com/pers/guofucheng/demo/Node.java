package com.pers.guofucheng.demo;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable {
     String path;
     String value;
     List<Node> children;

    public Node() {
    }

    public Node(String path, String value, List<Node> children) {
        this.path = path;
        this.value = value;
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
