package com.prijilevschi.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.prijilevschi.dto.LinkDTO;
import com.prijilevschi.dto.NodeDTO;
import com.prijilevschi.model.DynamicModel;
import com.prijilevschi.model.UploadedFile;
import com.prijilevschi.repository.Language;
import com.prijilevschi.service.DynamicModelService;
import com.prijilevschi.service.GeneratorService;

/**
 * Main Page
 * 
 * @author Evgheni Prijilevschi
 */

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	DynamicModelService dynamicModelService;
	
	@Autowired
	GeneratorService generatorService;
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
			
	UploadedFile ufile;
	public IndexController(){
		logger.info("init IndexController");
		ufile = new UploadedFile();
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value){
          try {
   
              response.setContentType(ufile.getType());
              response.setContentLength(ufile.getLength());
              FileCopyUtils.copy(ufile.getBytes(), response.getOutputStream());
   
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {                
  
      //0. notice, we have used MultipartHttpServletRequest
  
      //1. get the files from the request object
      Iterator<String> itr =  request.getFileNames();
  
      MultipartFile mpf = request.getFile(itr.next());
      System.out.println(mpf.getOriginalFilename() +" uploaded!");
      
      try {
                 //just temporary save file info into ufile
         ufile.setLength(mpf.getBytes().length);
         ufile.setBytes(mpf.getBytes());
         ufile.setType(mpf.getContentType());
         ufile.setName(mpf.getOriginalFilename());
  
     } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
  
      //2. send it back to the client as <img> that calls get method
      //we are using getTimeInMillis to avoid server cached image
  
      return "<img src='http://localhost:8080/index/get/"+Calendar.getInstance().getTimeInMillis()+"' />";
  
   }
    
    @RequestMapping(value = "/send", 
    		method = RequestMethod.POST
    		)
    public @ResponseBody String send(@RequestBody final DynamicModel dm){
    	dynamicModelService.setLanguage(dm.getLanguage()); //convert String
    	Language language = dynamicModelService.getLanguage(); //to Language class
    	Set<NodeDTO> states = dynamicModelService.getNodes(dm.getStates());
    	Set<LinkDTO> links = dynamicModelService.getLinks(dm.getLinks());
    	
    	generatorService.setLanguage(language);
    	generatorService.generateCode(states, links);
    	System.out.println("priem");
    	return "hello";    	
    }

}
