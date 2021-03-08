package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }

    //此方法tomcat可运行，jetty报错
//    @RequestMapping(method = RequestMethod.POST)
//    public String processUpload(@RequestPart("file") Part file) {
//
//        System.out.println(file.getSubmittedFileName());
//
//        System.out.println("---->  " + file.getName() + "  ::  " + file.getSize());
//
//        try {
//            file.write("c:/tmp/spittr/uploads/" + file.getSubmittedFileName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("file") MultipartFile file) {

        System.out.println(file.getOriginalFilename());

        System.out.println("---->  " + file.getName() + "  ::  " + file.getSize());

        try {
            file.transferTo(new File("c:/tmp/spittr/uploads/" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

}
