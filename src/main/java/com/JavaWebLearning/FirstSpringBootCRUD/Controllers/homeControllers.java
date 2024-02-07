package com.JavaWebLearning.FirstSpringBootCRUD.Controllers;

import com.JavaWebLearning.FirstSpringBootCRUD.Services.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class homeControllers {
    @Autowired
    private final HomeServices homeServices;

    public homeControllers(HomeServices homeServices) {
        this.homeServices = homeServices;
    }

    @RequestMapping (value = {"","/home"})
public String welcome(){
    return homeServices.welcome();
}

}
