package com.prodemy.springmp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prodemy.springmp.dto.UserDto;
import com.prodemy.springmp.dto.ProductDto;
import com.prodemy.springmp.model.Category;
import com.prodemy.springmp.model.Product;
import com.prodemy.springmp.model.User;
import com.prodemy.springmp.service.CategoryService;
import com.prodemy.springmp.service.ProductService;
import com.prodemy.springmp.service.UserService;

@Controller
public class AdminController {
	
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
    
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    
    // Show admin home
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    
    // Show admin users
    @GetMapping("/admin/users")
    public String getUsers(Model model){
    	List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
    // Show admin add new users
    @GetMapping("/admin/users/add")
    public String getUserAdd(Model model){
    	model.addAttribute("userDto", new UserDto());
        return "usersAdd";
    }
    
    // Add new users
    @PostMapping("/admin/users/add")
    public String postUserAdd(@ModelAttribute("user") UserDto userDto){
        userService.saveUser(userDto);
        return "redirect:/admin/users";
    }
    
    // Remove users
    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable(value="id") Long id){
        userService.deleteUserById(id);
        return "/redirect:/admin/users";
    }
    
    @GetMapping("/admin/users/update/{id}")
    public String updateUser(@PathVariable(value="id") Long id, Model model){
        UserDto userDto = userService.getUserById(id);
        model.addAttribute("userDto", userDto);
        return "usersAdd";
//        Optional<User> user = userService.getUserById(id);
//        if(user.isPresent()) {
//            model.addAttribute("user", user.get());
//            return "usersUpdate";
//        } else {
//            return "404";
//        }
        
    }
    
    // Show admin categories
    @GetMapping("/admin/categories")
    public String getCats(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }
    
    // Show admin add new categories
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }
    
    // Add new categories
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    
    // Remove categories
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable Long id){
        categoryService.removeCategoryById(id);
        return "/redirect:/admin/categories";
    }
    
    // Edit/update categories
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Long id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }

    //Show admin all products
    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }
    
    // Show admin add products
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "productsAdd";
    }
    
    // Add new products
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDto") ProductDto productDto,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductDescription(productDto.getProductDescription());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }
    
    // Delete products
    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    
    // Edit/update products
    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setCategoryId((product.getCategory().getId()));
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("productDto",productDto);
        return "productsAdd";
    }
    
}
