package com.example.implement_relation_database.controllers;

import com.example.implement_relation_database.delete.DeleteUtil;
import com.example.implement_relation_database.insert.InsertUtil;
import com.example.implement_relation_database.select.SelectUtil;
import com.example.implement_relation_database.update.UpdateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/api/v1/sql_query")
public class SqlController {
    @GetMapping
    public String queryPage() {
        return "query";
    }

    @PostMapping
    public String query(@RequestParam("query") String query, Model model) {
        String command = query.split(" ")[0].toUpperCase(Locale.ROOT);

        switch (command){
            case "SELECT":
                model.addAttribute("result", SelectUtil.answerRequest(query));
            break;
            case "INSERT":
                model.addAttribute("result", InsertUtil.addUser(query));
            break;
            case "DELETE":
                model.addAttribute("result", DeleteUtil.deleteAllUser(query));
            break;
            case "UPDATE":
                model.addAttribute("result", UpdateUtil.answer(query));
            break;
            default:
                model.addAttribute("error", true);
                break;
        }

        return "query";
    }
}
