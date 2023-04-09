package tfip.day23workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import tfip.day23workshop.model.OrderSummary;
import tfip.day23workshop.repository.OrderRepository;

@Controller
public class OrderController {
    
    @Autowired
    private OrderRepository repo;
    
    @GetMapping("/")
    public String goToIndex(Model model) {
        model.addAttribute("orderSummary", new OrderSummary());
        return "index";
    }

    @GetMapping(path="/order/total/{orderId}") 
    public String getOrderSummary(@PathVariable Integer orderId, Model model, @RequestParam(required=false, name="orderId") Integer newOrderId) {
        if(newOrderId != null) {
            return "redirect:/order/total/?orderId=" + newOrderId;
        }

        OrderSummary os = repo.generateOrderSummary(orderId);
        model.addAttribute("orderSummary", os);
        return "index";
    }

    @GetMapping(path="/order/total/")
    public String getOrderSummaryByRequestParam(@RequestParam Integer orderId) {
        return "redirect:/order/total/" + orderId;
    }

}
