package K23CNT2.nvhLabGuide05.controller;


import K23CNT2.nvhLabGuide05.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {
    private List<Info> list = new ArrayList<>(Arrays.asList(
            new Info(1, "Nong Van Hung", "nvh@devmaster.edu.vn", "https://devmaster.edu.vn")
    ));


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("infos", list);
        return "info_list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("info", new Info());
        return "info_add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Info info) {
        info.setId(list.size() + 1);
        list.add(info);
        return "redirect:/info/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Info info = list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
        model.addAttribute("info", info);
        return "info_edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Info info) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == info.getId()) {
                list.set(i, info);
                break;
            }
        }
        return "redirect:/info/list";
    }
}
