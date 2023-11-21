package io.github.cuckooplus.uitls;

import java.util.*;

/**
 * List工具类
 *
 * @author cuckooing
 * @date 2022/11/21
 */
public class ListUtils {

    /**
     * Map去重
     * 由于Set的无序性，不会保持原来顺序
     *
     * @param list
     */
    public static List<Map<String, Object>> distinct(List<Map<String, Object>> list) {
        final boolean sta = null != list && list.size() > 0;
        if (sta) {
            Set set = new HashSet();
            List doubleList = new ArrayList();
            set.addAll(list);
            doubleList.addAll(set);
            return doubleList;
        }
        return null;
    }


    /**
     * 字符串去重，保持原来顺序
     *
     * @param list 列表
     * @return {@link List}<{@link String}>
     */
    public static List<String> delRepeat(List<String> list) {
        List<String> listNew = new ArrayList<String>();
        for (String str : list) {
            if (!listNew.contains(str)) {
                listNew.add(str);
            }
        }
        return listNew;
    }


}
