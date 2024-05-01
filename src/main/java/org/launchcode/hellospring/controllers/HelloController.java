package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
//@ResponseBody
//@RequestMapping("hello")
public class HelloController
{
//    @GetMapping("hello") //argument represents the URL pattern...
//    @ResponseBody //plain text response, no template
//    public String hello()
//    {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye") //argument represents the URL pattern...
//    @ResponseBody //plain text response, no template
    public String goodbye()
    {
        return "Goodbye, Spring!";
    }

//    @GetMapping("hello")
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name, Model model)
    {
        //return "Hello," + name + "!";
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model)
    {
        //return "Hello," + name + "!";
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
//    @ResponseBody
    public String helloForm()
    {
//        return "<html>" +
//                "<body>" +
//                "<form action ='hello' method='post'>" +
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form" +
//                "</body>" +
//                "</html>";
        return "form"; //returns form.html using Thymeleaf template
    }

    public static String createMessage(String name, String language)
    {
        String result = "";

        if(language.equalsIgnoreCase("French"))
        {
            result = "Bonjour," + name + "!";
        }
        else if (language.equalsIgnoreCase("German"))
        {
            result = "Guten tag," + name + "!";
        }
        else if (language.equalsIgnoreCase("Spanish"))
        {
            result = "Hola," + name + "!";
        }
        else if (language.equalsIgnoreCase("Italian"))
        {
            result = "Ciao," + name + "!";
        }
        else if (language.equalsIgnoreCase("Portuguese"))
        {
            result = "OLÀ," + name + "!";
        }
        else if (language.equalsIgnoreCase("Hindi"))
        {
            result = "Namaste," + name + "!";
        }
        else if (language.equalsIgnoreCase("Persian (Farsi)"))
        {
            result = "Salaam," + name + "!";
        }

        return result;
    }

    @GetMapping("greeting")
    public String helloLanguageForm()
    {
        return "<html>" +
                "<body>" +
                "<form action ='helloLang' method='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='French'>French </option>"+
                "<option value='German'>German </option>"+
                "<option value='Spanish'>Spanish </option>"+
                "<option value='Italian'>Italian </option>"+
                "<option value='Portuguese'>Portuguese </option>"+
                "<option value='Hindi'>Hindi </option>"+
                "<option value='Persian (Farsi)'>Persian (Farsi) </option>"+
                "<input type='submit' value='Greet me!'>" +
                "</form" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value="helloLang", method=RequestMethod.POST)
    @ResponseBody
    public String helloLang(@RequestParam String name, @RequestParam String language)
    {
        if(name ==null)
            name = "World";
        return createMessage(name, language);
    }

    @GetMapping("hello-names")
    public String helloNames(Model model)
    {
        ArrayList<String> names = new ArrayList<>();

        names.add("What.");
        names.add("Is?");
        names.add("The");
        names.add("Word!");

        model.addAttribute("names", names);

        return "hello-list";
    }
}
