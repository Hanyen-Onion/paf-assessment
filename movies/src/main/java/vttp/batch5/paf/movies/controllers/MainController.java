package vttp.batch5.paf.movies.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vttp.batch5.paf.movies.services.MovieService;

@Controller
@RequestMapping("/api")
public class MainController {

  @Autowired
  private MovieService mSvc;

  // TODO: Task 3
  @GetMapping(path ="/summary", consumes=MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> getPnL(@RequestParam String query) {

    return ResponseEntity.ok().body("");
  }

  
  // TODO: Task 4


}
