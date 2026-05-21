package com.example.user.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParserExample {

    public static void main(String[] args) {
        try {
            // 创建 DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 创建 DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 解析 XML 文件并获取 Document 对象
            File xmlFile = new File("D:\\code_repository\\father\\user\\src\\main\\resources\\example.xml");
            Document document = builder.parse(xmlFile);

            // 可选：规范化 XML 结构
            document.getDocumentElement().normalize();

            // 获取所有 user 节点
            NodeList nodeList = document.getElementsByTagName("user");

            // 遍历每个 user 节点
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);


                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("element = " + element);
                    // 提取 id、name 和 email
                    int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String email = element.getElementsByTagName("email").item(0).getTextContent();

                    // 打印用户信息
                    System.out.println("User ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("--------------------");
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
