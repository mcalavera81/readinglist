package com.example;

import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {
    private String myprop;


    public void setMyprop(String myprop) {
        this.myprop = myprop;
    }

    private ReadingListRepository readingListRepository;


    @Autowired
    private  CounterService counterService;


    @Autowired
    public ReadingListController(
            ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    @Timed

    public String readersBooks(
            @PathVariable("reader") String reader,
            Model model) {

        List<Book> readingList = readingListRepository.findByReader(reader);

        if (readingList != null) {
            model.addAttribute("books", readingList);
        }

        //counterService.increment("controller.readinglist.readersBook");

        model.addAttribute("var", myprop);

        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);

        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

}
