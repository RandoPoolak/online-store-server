package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.models.Category;
import com.sda.onlinestoreserver.models.Product;
import com.sda.onlinestoreserver.models.ProductType;
import com.sda.onlinestoreserver.models.TreeNode;
import com.sda.onlinestoreserver.services.ProductTypeService;
import com.sda.onlinestoreserver.services.TreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeNodeServiceImpl implements TreeNodeService {
    @Autowired
    private ProductTypeService productTypeService;

    @Override
    public List<TreeNode> generateTreeNode() {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<ProductType> productTypes = productTypeService.getAll();

        for (ProductType productType : productTypes) {
            if (productType.isActive()) {
                List<TreeNode> treeNodeCategories = new ArrayList<>();
                for (Category category : productType.getCategories()) {
                    if (category.isActive()) {
                        List<TreeNode> treeNodeProducts = new ArrayList<>();
                        for (Product product : category.getProducts()) {
                            if (product.isActive()) {
                                treeNodeProducts.add(new TreeNode(product.getId(), product.getDescription(), category.getId(), null, "Product", product.isActive()));
                            }
                        }
                        treeNodeCategories.add(new TreeNode(category.getId(), category.getName(), productType.getId(), treeNodeProducts, "Category", category.isActive()));
                    }
                }
                treeNodes.add(new TreeNode(productType.getId(), productType.getName(), treeNodeCategories,"ProductType", productType.isActive()));
            }
        }

        return treeNodes;
    }

    public List<TreeNode> generateTreeNodeAdmin() {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<ProductType> productTypes = productTypeService.getAll();

        for (ProductType productType : productTypes) {
            List<TreeNode> treeNodeCategories = new ArrayList<>();
            for (Category category : productType.getCategories()) {
                List<TreeNode> treeNodeProducts = new ArrayList<>();
                for (Product product : category.getProducts()) {
                    treeNodeProducts.add(new TreeNode(product.getId(), product.getDescription(), category.getId(), null, "product", product.isActive()));
                }
                treeNodeCategories.add(new TreeNode(category.getId(), category.getName(), productType.getId(), treeNodeProducts, "category", category.isActive()));
            }
            treeNodes.add(new TreeNode(productType.getId(), productType.getName(), treeNodeCategories,"product-type", productType.isActive()));
        }
        return treeNodes;
    }
}
