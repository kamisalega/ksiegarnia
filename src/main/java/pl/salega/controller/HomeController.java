package pl.salega.controller;


/**
 * Created by kamilsalega on 21.06.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.salega.domain.Book;
import pl.salega.domain.User;
import pl.salega.domain.UserShipping;
import pl.salega.domain.security.PasswordResetToken;
import pl.salega.domain.security.Role;
import pl.salega.domain.security.UserRole;
import pl.salega.service.BookService;
import pl.salega.service.UserService;
import pl.salega.service.impl.UserSecurityService;
import pl.salega.utility.MailConstructor;
import pl.salega.utility.PLConstants;
import pl.salega.utility.SecurityUtility;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.*;


@Controller
public class HomeController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private UserService userService;

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("classActiveLogin", true);
        return "myAccount";
    }

    @RequestMapping("/bookshelf")
    public String bookshelf(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        return "bookshelf";

    }

    @RequestMapping("/bookDetail")
    public String bookDetail(@PathParam("id") Long id, Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute(user);
        }

        Book book = bookService.findOne(id);

        model.addAttribute("book", book);

        List<Integer> qtyList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        model.addAttribute("qtyList", qtyList);
        model.addAttribute("qty", 1);

        return "bookDetail";

    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(HttpServletRequest request, @ModelAttribute("email") String email,
                                 Model model) {

        model.addAttribute("classActiveForgetPassword", true);

        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("emailNotExists", true);
            return "myAccount";
        }
        String password = SecurityUtility.randomPassword();
        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(encryptedPassword);


        userService.save(user);

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        String applicationUrl = "http://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();

        SimpleMailMessage newEmail = mailConstructor.constructorResetTokenEmail(applicationUrl, request.getLocale(), token, user, password);
        javaMailSender.send(newEmail);

        model.addAttribute("forgetPasswordEmailSent", true);
        return "myAccount";
    }

    @RequestMapping("/myProfile")
    public String myProfile(Model model, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("userPaymentList", user.getUserPaymentList());
        model.addAttribute("userShippingList", user.getUserShippingList());
//        model.addAttribute("orderList", getUserOrderList());

        UserShipping userShipping = new UserShipping();
        model.addAttribute("userShipping", userShipping);

        model.addAttribute("listOfCreditCards", true);
        model.addAttribute("listOfShippingAddresses", true);

        List<String> voivodeshipsList = PLConstants.listOfPLVoivodeshipsCode;
        Collections.sort(voivodeshipsList);

        model.addAttribute("voivodeshipsList", voivodeshipsList);
        model.addAttribute("classActiveEdit", true);


        return "myProfile";

    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUserPost(HttpServletRequest request, @ModelAttribute("email") String userEmail,
                              @ModelAttribute("username") String username, Model model) throws Exception {

        model.addAttribute("classActiveNewAccount", true);
        model.addAttribute("email", userEmail);
        model.addAttribute("username", username);

        if (userService.findByUsername(username) != null) {
            model.addAttribute("usernameExists", true);
            return "myAccount";
        }

        if (userService.findByEmail(userEmail) != null) {
            model.addAttribute("emailExists", true);
            return "myAccount";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);

        String password = SecurityUtility.randomPassword();
        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(encryptedPassword);

        Role role = new Role();
        role.setRoleId(1);
        role.setName("ROLE_USER");
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        String applicationUrl = "http://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();

        SimpleMailMessage email = mailConstructor.constructorResetTokenEmail(applicationUrl, request.getLocale(), token, user, password);
        javaMailSender.send(email);
        model.addAttribute("user", user);
        model.addAttribute("emailSent", true);
        return "myAccount";

    }

    @RequestMapping("/newUser")
    public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
        PasswordResetToken passToken = userService.getPasswordResetToken(token);

        if (passToken == null) {
            String message = "Nieważny token";
            model.addAttribute("message", message);
            return "redirect:/badRequest";
        }

        User user = passToken.getUser();
        String username = user.getUsername();

        UserDetails userDetails = userSecurityService.loadUserByUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        model.addAttribute("user", user);

        model.addAttribute("classActiveEdit", true);
        return "myProfile";
    }
}
