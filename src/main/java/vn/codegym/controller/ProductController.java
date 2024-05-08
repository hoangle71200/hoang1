package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.entity.Product;
import vn.codegym.service.IProductService;
import vn.codegym.service.ITypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeService typeService;

    @GetMapping("/list")
    public ModelAndView showPrList() {
        return new ModelAndView("/product/product-list",
                "productList", productService.findAll());
    }
    @GetMapping("/search")
    public ModelAndView searchMovieList1(@RequestParam("keywordSearch") String keyword) {
//        Optional<List<Movie>> movieOptional = movieService.findMoviesByNameMovieContaining(keyword);
//        List<MovieDto> movieDtoList = new ArrayList<>();
//        if (movieOptional.isPresent()) {
//            for (Movie movie: movieOptional.get()) {
//                MovieDto movieDto = new MovieDto();
//                BeanUtils.copyProperties(movie, movieDto);
//                movieDtoList.add(movieDto);
//            }
//        }
        return new ModelAndView("/movie/movie");
    }
//    @GetMapping("/addForm")
//    public ModelAndView addPrForm() {
//        return new ModelAndView("/product/product-add");
//    }
    @GetMapping("/addForm")
    public String showCreatePage(Model model) {

        model.addAttribute("typeList", typeService.findAll());
        model.addAttribute("product", new Product());
        return "/product/product-add";
    }
    @GetMapping
    public String showSearchPage(Model model) {

        model.addAttribute("typeList", typeService.findAll());
        model.addAttribute("product", new Product());
        return "/product/product-list";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes
    ) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message",
                "Create product: " + product.getName() + " OK!");
        return "redirect:/product/list";

    }
    @PostMapping("/search")
    public String searchProduct(@ModelAttribute Product product
    ) {
        productService.save(product);
        return "redirect:/product/list";

    }
}
