package com.learning.concept.hateoas;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/hateoas")
public class HateoasController {

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        Order order = new Order();
        order.setId(id);
        List<Link> links = getLinks(id);
        order.add(links);
        return ResponseEntity.ok(order);
    }

    private List<Link> getLinks(String id) {
        List<Link> links = new ArrayList<>();

        Link sendSms = WebMvcLinkBuilder.linkTo(HateoasController.class)
                .slash("sendSms")
                .slash(id)
                .withSelfRel()
                .withType("POST")
                .withName("SEND_SMS");

        Link sendWhatsApp = WebMvcLinkBuilder.linkTo(HateoasController.class)
                .slash("sendWhatsApp")
                .slash(id)
                .withSelfRel()
                .withType("POST")
                .withName("SEND_WHATSAPP");

        links.add(sendSms);
        links.add(sendWhatsApp);
        return links;
    }
}
