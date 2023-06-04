package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import v2.Service.SystemService;
//import v2.Service.UserService;
import v2.model.response.SystemResponse;

import java.util.List;

@Controller
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class SystemController {

    private final SystemService systemService;

    public @NotNull List<SystemResponse> findAll() {
        return systemService.findAll();
    }

}
