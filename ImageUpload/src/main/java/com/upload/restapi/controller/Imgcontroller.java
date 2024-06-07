package com.upload.restapi.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.upload.restapi.model.Images;
import com.upload.restapi.repository.Imagerepos;

import jakarta.servlet.http.HttpSession;

@Controller
public class Imgcontroller {
	@Autowired
	private Imagerepos imagerepos;
	
	@GetMapping("/")
	public String Imgupld()
	{
		return "Imgupld";
	}
	@PostMapping("/Imgupld")
	public String imageUpload(@RequestParam MultipartFile img, HttpSession session)
	{
		//System.out.println(img.getOriginalFilename());
		Images im=new Images();
		im.setImageName(img.getOriginalFilename());
		
		
		Images uploadImg=imagerepos.save(im);
		if(uploadImg!=null) {
			try {
				
					File saveFile=new ClassPathResource("static/img").getFile();	
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
				System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		System.out.println(img.getOriginalFilename());
		System.out.println(img.getContentType());
		System.out.println(img.getSize());
		System.out.println("Image upload Sucessfully");
		//return "Image upload Sucessfully";
		return "redirect:/";
		
	}
}
