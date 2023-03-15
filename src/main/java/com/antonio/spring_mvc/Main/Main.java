package com.antonio.spring_mvc.Main;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {

        byte[] filecontent= FileUtils.readFileToByteArray(new File("/home/antonio/ITU/Naina/SpringMVC/Project/Project1/src/main/webapp/resources/theme/Images/pexels-asish-aji-15439635.jpg"));
        System.out.println(Base64.getEncoder().encodeToString(filecontent));
    }
}
