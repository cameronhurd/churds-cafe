package churd.cafe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChurdsCafeController {

    // TODO: add some variety to the dynamic behavior on these views

    @GetMapping("/about")
    public String about(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        model.addAttribute("name", name);
        return "about";
    }

    @GetMapping("/contact")
    public String contact(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        model.addAttribute("name", name);
        return "contact";
    }

    @GetMapping("/locations")
    public String locations(@RequestParam(name="name", required=false, defaultValue="you") String name, Model model) {
        model.addAttribute("name", name);
        return "locations";
    }

}

