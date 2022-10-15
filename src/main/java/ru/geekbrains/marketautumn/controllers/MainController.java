package ru.geekbrains.marketautumn.controllers;
// 1. поднять контроллер
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketautumn.dto.Client;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.services.ProductServices;
import ru.geekbrains.marketautumn.services.ClientService;

import java.util.List;

@Controller
//@RestController // позволяет не прописываеть  @ResponseBody для кадого метода а делает его по умолчанию, но
// при этом будет возращаться не page а строка всегда
@RequiredArgsConstructor // позволяет получить конструктор для каждого поля.
public class MainController {

    private final ClientService service;
    private final ProductServices productServices;

    // --------------------------------
    // Клиенты
    // http://localhost:8190/app/addClient
    // @PostMapping это Post запрос и @RequestBody - передача объекта

    @PostMapping("/addClient")
    @ResponseBody
    public void addClientPost (@RequestBody Client client)
    {
        service.addClientPost(client);
    }


   // http://localhost:8190/app/add_client_form
   @GetMapping("/add_client_form")
   //  @ResponseBody
    public String form()
    {
        return "simple_form.html";
    }

    // http://localhost:8190/app/clients
    @GetMapping("/clients")
    public String getAlClients(Model model) // Model - позволяет во фронт на страницу передаваать атрибуты.
    {
        model.addAttribute("studentsList",service.getAllClient());
        return "student.html";
    }

    // http://localhost:8190/app/findClient?id=1
    @GetMapping("/findClient")
    @ResponseBody
    public Client findClietn(Long id)
    {
       return service.getClient(id);
    }

    // http://localhost:8190/app/addClient/?id=5&name=A
    @GetMapping("/addClient")
    @ResponseBody
    public String addClient(@RequestParam Long id, @RequestParam String name)
    {
        service.addClient(id, name);
        String ret = "Id =" + id.toString() + " Name =" + name;
        return ret;
    }

// -----------------------------------------------------------------
// Продукты
// http://localhost:8190/app/allproducts/?id=2 - передача параметров
// -----------------------------------------------------------------

    @GetMapping("/allproducts/")
    public String getAllProducts(Model model, @RequestParam Long id)
    {
        model.addAttribute("productsList",productServices.GetAllProducts());
        model.addAttribute("product",productServices.getProductsById(id));
        return "products.html";
    }
    // http://localhost:8190/app/getallproducts
    @GetMapping("/getallproducts")
    @ResponseBody
    public List<Product> products()
    {
        return productServices.GetAllProducts();
    }

    // http://localhost:8190/app/product/?id=1
    @GetMapping("/product/")
    public String getproduct(Model model, @RequestParam Long id)
    {
        model.addAttribute("product",productServices.getProductsById(id));
        return "product.html";
    }

    // ----------------------------------------------------
    // Прочее
    //http://localhost:8189/app/calculate/?first=5&second=4

    @GetMapping("/page/")
    public String page(Model model, @RequestParam(name = "IDD") Long id){
        model.addAttribute("studentFront", service.getClient(id));
        return "index.html";
    }



    @GetMapping("/calculate")
    @ResponseBody
    public int culculate(@RequestParam(name = "first") int a,
                         @RequestParam(required = false, defaultValue = "0", name = "second") int b){
        return a+b;
    }

    @GetMapping("/page2")
    public String page(){
        return "in.html";
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








}
