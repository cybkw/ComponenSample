package com.bkw.module.common.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局路径记录器（根据子模块分组）
 */
public class RecordPathManager {

    // key:"order"组     value:order子模块下，对应所有的Activity路径信息
    private static Map<String, List<PathBean>> groupMap = new HashMap<>();

    /**
     * 将路径信息加入全局Map
     *
     * @param groupName 组名，如："personal"
     * @param pathName  路劲名，如："Personal_MainActivity"
     * @param clazz     类对象，如：Personal_MainActivity.class
     */
    public static void joinGroup(String groupName, String pathName, Class<?> clazz) {
        //先从全局Map中取出这个组名已存的路径信息
        List<PathBean> list = groupMap.get(groupName);
        if (list == null) {
            //如果全局Map没有这个组名，表示这是个新加入的组，将传递的路径信息和目标class存储到集合并put这个组名到全局map中
            list = new ArrayList<>();
        }
        //如果存在这个组名的记录，直接将路径信息和具体的类对象添加
        list.add(new PathBean(pathName, clazz));
        groupMap.put(groupName, list);
    }

    /**
     * 根据组名和路径名获取类对象，达到跳转目的
     *
     * @param groupName 组名
     * @param pathName  路径名
     * @return 跳转目标的class类对象
     */
    public static Class<?> getTargetClass(String groupName, String pathName) {
        List<PathBean> list = groupMap.get(groupName);
        if (list == null) {
            return null;
        }
        for (PathBean path : list) {
            if (pathName.equalsIgnoreCase(path.getPath())) {
                return path.getClazz();
            }
        }
        return null;
    }

    /**
     * 清理、回收
     */
    public static void recycleGroup() {
        groupMap.clear();
        groupMap = null;
        System.gc();
    }

}
