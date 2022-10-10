package ru.geekbrains.marketautumn.controllers;
// 1. поднять контроллер
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.marketautumn.dto.Student;
import ru.geekbrains.marketautumn.services.ProductServices;
import ru.geekbrains.marketautumn.services.StudentService;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final StudentService service;
    private final ProductServices productServices;


// http://localhost:8190/app/allproducts/?id=2 - передача параметров
    @GetMapping("/allproducts/")
    public String getAllProducts(Model model, @RequestParam Long id)
    {
        model.addAttribute("productsList",productServices.GetAllProducts());
        model.addAttribute("product",productServices.getProductsById(id));
        return "products.html";
    }

    // http://localhost:8190/app/product/?id=1
    @GetMapping("/product/")
    public String getproduct(Model model, @RequestParam Long id)
    {
        model.addAttribute("product",productServices.getProductsById(id));
        return "product.html";
    }

    @GetMapping("/page/")
    public String page(Model model, @RequestParam(name = "IDD") Long id){
        model.addAttribute("studentFront", service.getStudent(id));
        return "index.html";
    }


    @GetMapping("/students")
    public String getAllStudents(Model model)
    {
        model.addAttribute("studentsList",service.getAllStudent());
        return "student.html";
    }

    // http://localhost:8189/app

    // http://localhost:8189/app/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<h1>Hello autumn market!</h1>";
    }

    //http://localhost:8189/app/buy
    @GetMapping("/buy")
    @ResponseBody
    public String buy(){
        return "buy";
    }

    //http://localhost:8189/app/calculate/?first=5&second=4
    @GetMapping("/calculate")
    @ResponseBody
    public int culculate(@RequestParam(name = "first") int a,
                         @RequestParam(required = false, defaultValue = "0", name = "second") int b){
        return a+b;
    }
/*
    //http://localhost:8189/app/products/12/info
    @GetMapping("/products/{anyName}/info")
    @ResponseBody
    public String info(@PathVariable(name = "anyName") String id){
        return "product with id = " + id;
    }*/

    // 1) Приходит запрос на /page
    // 2) Создаём модель, которую отдадим в нашу страницу
    // 3) До того, как мы отдаём страницу, в наш ответ мы вшиваем объект, который создали.

    // http://localhost:8190/app/page/?id=2


    @GetMapping("/page2")
    public String page(){
                return "in.html";
    }





}
