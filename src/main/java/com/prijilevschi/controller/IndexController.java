package com.prijilevschi.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.prijilevschi.model.UploadedFile;

/**
 * Main Page
 * 
 * @author eprijilevschi
 */

@Controller
@RequestMapping("/index")
public class IndexController {

	UploadedFile ufile;
	public IndexController(){
		System.out.println("init RestController");
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

}
