package com.antonio.spring_mvc.Service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Base64;
import java.util.List;

public class ServiceAuteur {
/*
    public void saveFile(HttpServletRequest request, Publicite pub){
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        File file=new File("/home/antonio/ITU/Naina/SpringMVC/Project/Project1/src/main/webapp/resources/theme/Images" + File.separator + name);
                        if(!file.exists())
                            item.write(file);
                        byte[] filecontent= FileUtils.readFileToByteArray(file);
                        pub.setPhoto(Base64.getEncoder().encodeToString(filecontent));
                    }
                }
            } catch (Exception ex) {
                System.out.println("File Upload Failed due to " + ex);
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            System.out.println("message No File found");
            request.setAttribute("message", "No File found");
        }
    }
*/
}
