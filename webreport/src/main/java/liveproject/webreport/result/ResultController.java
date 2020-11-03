package liveproject.webreport.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/reports")
public class ResultController {

    private ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("season-report/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public String account(@PathVariable("year") int year, Model model) {
        model.addAttribute("season", resultService.aggregateSeason(year));
        return "reports/SeasonReport";
    }
}