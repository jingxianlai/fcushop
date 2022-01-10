package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productManager;

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productManager.getProducts();

  }

  @GetMapping("/products/{keyword}")
  public List<Product> getProducts(@PathVariable("keyword") String keyword) {
    return productManager.getProducts(keyword);
  }
  @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
  @ResponseBody
  public String addProduct(
      @RequestParam("name") String name,
      @RequestParam("imgurl") String imgurl,
      @RequestParam("price") Integer price,
      @RequestParam("description") String description
  ) {
    return productManager.aaAddProduct(name, imgurl, price, description);
  }

  @RequestMapping(value = "/updateproduct", method = RequestMethod.GET)
  @ResponseBody
  public String updateProduct(
      @RequestParam("bookname") String name,
      @RequestParam("price") Integer price
  ) {
    return productManager.aaUpdateProduct(name, price);
  }
}
