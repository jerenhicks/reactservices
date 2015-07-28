package com.ocean.reactservices.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ocean.reactservices.dao.TestDao;
import com.ocean.reactservices.model.Recipe;

@Controller
public class SearchController {
	
	@Value("${file.upload.directory}")
    private String fileUploadDirectory;
	private TestDao testDao = new TestDao();
	private static final String RECIPE_IMAGE_LOCATION = "/recipe/image/%s";
	
	@RequestMapping(method=RequestMethod.GET, value ="/recipe")  
	public @ResponseBody List<Recipe> getTest(){
	    return testDao.readAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/recipe/{id}")  
	public @ResponseBody Recipe getById(@PathVariable Integer id) {
		return testDao.read(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/recipe/image/{imageid}", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")  
	public @ResponseBody byte[] getRecipeImage(@PathVariable String imageid) throws IOException {
        File serverFile = new File(fileUploadDirectory + File.separator + "images" + File.separator + imageid + File.separator + "image");
        InputStream inputStream = new FileInputStream(serverFile);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write( bufferedImage  , "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
	}

	@RequestMapping(method=RequestMethod.POST, value ="/recipe")  
	public @ResponseBody Recipe createTest(@ModelAttribute("recipe")Recipe recipe, @RequestParam("image") MultipartFile file) {
		String fileName = handleFileUpload(file);
		recipe.setImageLocation(fileName);
		return testDao.create(recipe);
	}
	
    public String handleFileUpload(MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                UUID id = UUID.randomUUID();
                File dir = new File(fileUploadDirectory + File.separator + "images" + File.separator + id);
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "image");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                
                return String.format(RECIPE_IMAGE_LOCATION, id);
            } catch (Exception e) {
                return "catch message";
            }
        } else {
        	return "catch message";
        }
    }



}
