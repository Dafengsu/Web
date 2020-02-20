package com.hzau.servletcontext;

import com.hzau.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author su
 * @description
 * @date 2020/2/19
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        String agent = request.getHeader("user-agent");
        String fileName = DownLoadUtils.getFileName(agent, filename);
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(path);
        ServletOutputStream sos = response.getOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int len;
        String mimeType = context.getMimeType(filename);
        response.setContentType(mimeType);
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        while (((len = fis.read(buffer)) != -1)) {
            sos.write(buffer, 0, len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
