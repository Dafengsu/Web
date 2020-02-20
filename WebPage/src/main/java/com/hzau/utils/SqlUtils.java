package com.hzau.utils;

import java.util.List;
import java.util.Map;

/**
 * @author su
 * @description
 * @date 2020/2/20
 */
public class SqlUtils {
    public static void conditionSqlAppend(Map<String, String[]> condition, StringBuilder sb, List<Object> params) {
        for (String key : condition.keySet()) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" AND " + key + " LIKE ?");
                params.add("%" + value + "%");
            }
        }
    }
}
