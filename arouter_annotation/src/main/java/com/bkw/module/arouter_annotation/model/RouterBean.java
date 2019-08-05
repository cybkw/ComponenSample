package com.bkw.module.arouter_annotation.model;

import javax.lang.model.element.Element;

/**
 * PathBean对象的升级版
 *
 * @author bkw
 */
public class RouterBean {
    @Override
    public String toString() {
        return "RouterBean{" +
                "element=" + element +
                ", group='" + group + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public enum Type {
        //Activity
        ACTIVITY,
        //跨模块的业务接口
        CALL,
        //拓展
        FRAGMENT
    }

    /**
     * 枚举类型
     */
    private Type type;

    /**
     * 类节点
     */
    private Element element;

    /**
     * 被@ARouter注解的类对象
     */
    private Class<?> clazz;

    /**
     * 路由的组名
     */
    private String group;

    /**
     * 路由的地址
     */
    private String path;

    private RouterBean(Builder builder) {
        this.element = builder.element;
        this.path = builder.path;
        this.group = builder.group;
    }

    private RouterBean(Type type, Class<?> clazz, String path, String group) {
        this.type = type;
        this.clazz = clazz;
        this.path = path;
        this.group = group;
    }

    public static RouterBean create(Type type, Class<?> clazz, String path, String group) {
        return new RouterBean(type, clazz, path, group);
    }

    public Type getType() {
        return type;
    }

    public Element getElement() {
        return element;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getGroup() {
        return group;
    }

    public String getPath() {
        return path;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static final class Builder {
        /**
         * 类节点
         */
        private Element element;
        /**
         * 路由的组名
         */
        private String group;
        /**
         * 路由的地址
         */
        private String path;

        public Builder setElement(Element element) {
            this.element = element;
            return this;
        }

        public Builder setGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        /**
         * @description 最后的build或者create方法，往往是做参数校验或初始化操作
         */
        public RouterBean build() {
            if (path == null || path.length() == 0) {
                throw new IllegalArgumentException("path必填项为空，如app/MainAcvitiy");
            }
            return new RouterBean(this);
        }
    }
}
