package com.sda.onlinestoreserver.models;

import java.util.List;

public class TreeNode {
    private Long id;
    private String name;
    private String controllerUrl;
    private Long parentId;
    private boolean isActive;
    private List<TreeNode> children;

    public TreeNode(Long id, String name, Long parentId, List<TreeNode> children, String controllerUrl, boolean isActive) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = children;
        this.controllerUrl = controllerUrl;
        this.isActive = isActive;
    }

    public TreeNode(Long id, String name, List<TreeNode> children, String controllerUrl, boolean isActive) {
        this.id = id;
        this.name = name;
        this.children = children;
        this.controllerUrl = controllerUrl;
        this.isActive = isActive;
    }

    public String getControllerUrl() {
        return controllerUrl;
    }

    public void setControllerUrl(String controllerUrl) {
        this.controllerUrl = controllerUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
