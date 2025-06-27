package rw.ac.auca.ecommerce.controller.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rw.ac.auca.ecommerce.core.customer.model.Customer;
import rw.ac.auca.ecommerce.core.customer.service.ICustomerService;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private  final ICustomerService customerService;

    @GetMapping("/search/all")
    public String getAllCustomers(Model model){
        List<Customer> customers = customerService.findCustomersByState(Boolean.TRUE);
        model.addAttribute("customers",customers);
        return  "customer/customerList";
    }

    @GetMapping("/register")
    public String getCustomerRegistrationPage(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerRegistrationPage";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer theCustomer, Model model){
        if(Objects.nonNull(theCustomer)){
            customerService.registerCustomer(theCustomer);
            model.addAttribute("message","Customer Registered Successfully");
        }else{
            model.addAttribute("error","Data not Sved Successfully");
        }
        return "customer/customerRegistrationPage";
    }


}
