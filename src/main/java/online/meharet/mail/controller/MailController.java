package online.meharet.mail.controller;


import online.meharet.mail.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/simple")
    public ResponseEntity<String> sendMail(){
        // simple email
        emailService.sendEmail("salmanov.meharet@gmail.com","Mail subject","Mail body");
        return ResponseEntity.ok("Successfully");
    }

    @GetMapping("/html=template")
    public ResponseEntity<String> sendTemplate()
    {
        // email body html template
        emailService.sendEmail("salmanov.meharet@gmail.com","Mail subject");
        return ResponseEntity.ok("Successfully");
    }
}
