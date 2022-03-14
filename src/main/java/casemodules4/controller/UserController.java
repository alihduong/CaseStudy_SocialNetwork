package casemodules4.controller;

import casemodules4.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Value("${default.page.size}")
    private Integer defaultPageSize;

    private final UserServiceImpl userService;

    @GetMapping("/users")
    public String getUserList(HttpServletRequest request,
                              @RequestParam(value = "search", required = false) String search,
                              @RequestParam(value = "page", required = false) Integer page,
                              Model model) {
        UserDTO user = getUserFromSession(request);
        if (page == null)
            page = 0;

        PageRequest pageRequest = PageRequest.of(page, defaultPageSize, Sort.by("lastName").and(Sort.by("firstName")));
        PageDTO<UserDTO> allPageable;
        if (StringUtils.isEmpty(search)) {
            allPageable = userService.findAllPageable(user.getId(), pageRequest);
        } else {
            allPageable = userService.findAllWithSearch(user.getId(), search, pageRequest);
        }
        model.addAttribute("page", allPageable);
        model.addAttribute("search", search);
        return "users";
    }
}
