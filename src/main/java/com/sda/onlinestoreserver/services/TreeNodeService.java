package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.models.TreeNode;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TreeNodeService {

    List<TreeNode> generateTreeNode();
    List<TreeNode> generateTreeNodeAdmin();
}
