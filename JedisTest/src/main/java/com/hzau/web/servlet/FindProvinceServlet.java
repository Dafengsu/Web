package com.hzau.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzau.domain.Province;
import com.hzau.service.ProvinceService;
import com.hzau.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/2/23
 */
@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        ProvinceService service = new ProvinceServiceImpl();
       /* List<Province> list = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/
        String json = service.findAllJson();
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
