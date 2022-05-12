package com.hoangkhanh.khanhshop.service;

import com.hoangkhanh.blogweb.common.exception.ApiException;
import com.hoangkhanh.khanhshop.common.util.FileUploadUtil;
import com.hoangkhanh.khanhshop.common.util.ProductMapper;
import com.hoangkhanh.khanhshop.dto.ProductDto;
import com.hoangkhanh.khanhshop.model.Category;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public Product getProductByid(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ApiException("Product does not exist", HttpStatus.NOT_FOUND));
        return product;
    }

    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Product addProduct(ProductDto productDto, MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Product product = ProductMapper.toProduct(productDto);
        product.setImage(fileName);
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);
        productRepository.save(product);

        String uploadDir = "product-photos/" + product.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return product;
    }

    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delProducts(Long[] productId){
        for (Long id : productId){
            deleteDirectory(id.toString());
        }
        productRepository.delProduct(Arrays.asList(productId));
    }

    public void deleteDirectory(String directoryName){
        try {
            File directory = new File("D:\\khanhshop\\product-photos\\" + directoryName);
            File[] files = directory.listFiles();
            for(File file : files) {
                file.delete();
            }
            Files.deleteIfExists(Paths.get("D:\\khanhshop\\product-photos\\" + directoryName ));
        }catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(DirectoryNotEmptyException e)
        {
            System.out.println("Directory is not empty.");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
    }

//    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delProduct(Long id){
        productRepository.deleteById(id);
        deleteDirectory(id.toString());

    }

    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void editProduct(ProductDto productDto, MultipartFile multipartFile) throws IOException {
        Product newProduct = getProductByid(productDto.getId());
        newProduct.setName(productDto.getName());
        newProduct.setQuantity(productDto.getQuantity());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setAbout(productDto.getAbout());
        newProduct.setCreateDate(productDto.getCreateDate());

        if (!multipartFile.isEmpty()){
            File directory = new File("D:\\khanhshop\\product-photos\\" + productDto.getId());
            File[] files = directory.listFiles();
            for(File file : files) {
                file.delete();
            }
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            newProduct.setImage(fileName);
            String uploadDir = "product-photos/" + newProduct.getId();

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        newProduct.setCategory(category);
        productRepository.save(newProduct);

    }

}
