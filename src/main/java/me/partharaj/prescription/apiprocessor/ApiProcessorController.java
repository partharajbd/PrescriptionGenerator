package me.partharaj.prescription.apiprocessor;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import me.partharaj.prescription.apiprocessor.pojo.Nlm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class ApiProcessorController {

    ApiProcessorService apiProcessorService;

    @GetMapping("/report/api")
    public String showApiResult(Model model) throws Exception {
        String endPoint = "https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=341248";

        String payload = apiProcessorService.resolveData(endPoint);

        Nlm nlm = new Gson().fromJson(payload, Nlm.class);
        model.addAttribute("nlm", nlm);

        return "api_report";
    }
}
