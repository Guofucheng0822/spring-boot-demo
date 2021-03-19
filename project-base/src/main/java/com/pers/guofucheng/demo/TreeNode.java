package com.pers.guofucheng.demo;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class TreeNode {

    public static Node getNodes(List<Node> nodes, String path) {

        if (nodes == null || nodes.size() == 0 || path == null) {
            return null;
        }

        for (Node node : nodes) {
            if (path.equals(node.getPath())) {
                return node;
            }
            return getNodes(node.getChildren(), path);
        }
        return null;
    }

    public static void main(String[] args) {
        String nodes = "[\n" +
                "    {\n" +
                "        \"path\":\"level0_0/\",\n" +
                "        \"value\":\"value\",\n" +
                "        \"children\":[\n" +
                "            {\n" +
                "                \"path\":\"level0_0/level1_0/\",\n" +
                "                \"value\":\"value\",\n" +
                "                \"children\":[\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_0\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"path\":\"level0_0/level1_1/\",\n" +
                "                \"value\":\"value\",\n" +
                "                \"children\":[\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_0\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"path\":\"level0_1/\",\n" +
                "        \"value\":\"avaluearg\",\n" +
                "        \"children\":[\n" +
                "\n" +
                "        ]\n" +
                "    }\n" +
                "]";


        List<Node> nodes1 = JSON.parseArray(nodes, Node.class);
        Node nodes2 = getNodes(nodes1, "level0_0/level1_0/level2_1");
        String s = JSON.toJSONString(nodes2);
        System.out.println(s);
    }
}
