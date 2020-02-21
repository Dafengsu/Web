package com.hzau.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author su
 * @description
 * @date 2020/2/21
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(req, args);
                    value = replaceValue(value);
                    return value;
                }
                if (method.getName().equals("getParameterMap")) {
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    for (String key : map.keySet()) {
                        String[] values = map.get(key);
                        replaceStrings(values);
                    }
                    return map;
                }
                if (method.getName().equals("getParameterValues")) {
                    String[] values = (String[]) method.invoke(req, args);
                    replaceStrings(values);
                    return values;
                }
                return method.invoke(req,args);
            }
        });
        //2.放行
        chain.doFilter(proxy_req, resp);
    }

    /**
     * 替换字符数组
     * @param values 字符数组
     */
    private void replaceStrings(String[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = replaceValue(values[i]);
        }
    }

    /**
     * 替换字符串中的敏感字符
     * @param value 原字符串
     * @return  返回新字符串
     */
    private String replaceValue(String value) {
        if (value != null) {
            for (String str : list) {
                if (value.contains(str)) {
                    value = value.replaceAll(str, "***");
                }
            }
        }
        return value;
    }

    private List<String> list;

    public void init(FilterConfig config) throws ServletException {
        BufferedReader reader = null;
        list = new ArrayList<>();
        try {
            ServletContext context = config.getServletContext();
            String path = context.getRealPath("WEB-INF/classes/敏感词汇.txt");

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
