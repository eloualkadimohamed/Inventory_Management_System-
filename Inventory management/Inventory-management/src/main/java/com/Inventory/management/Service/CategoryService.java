package com.Inventory.management.Service;

import com.Inventory.management.Entity.Category;
import com.Inventory.management.Entity.Product;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AdminRepository adminRepository;
    public Category saveCategory(String admin_Company,Category category) {
        category.setAdmin_id(adminRepository.getAdminByCompany(admin_Company));
        return categoryRepository.save(category);
    }

    public List<Category> fetchData(String adminId) {
        return categoryRepository.getCategoryWithAdminIdNativeNamedParam(adminId);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }
    public Category updateCategoryByTd( Long id,Category category) {
        Category DB= categoryRepository.findById(id).get();
        if (Objects.nonNull(category.getName()) &&
                !"".equalsIgnoreCase(category.getName())){
            DB.setName(category.getName());
        }
        if (Objects.nonNull(category.getStatus()) &&
                !"".equalsIgnoreCase(category.getStatus())){
            DB.setStatus(category.getStatus());
        }
        return categoryRepository.save(DB);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
