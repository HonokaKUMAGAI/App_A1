package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AppController {

	@Autowired
	private PaymentsService paymentsService;
	@Autowired
    private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private CategoryRepository categoryRepository;
	@Autowired
	MyService service;
		
	@GetMapping("/payments")
	public List<Payments> getAllKakeibo(@RequestParam(required = false) List<String> categories) {
		return paymentsService.findAll();
    }

	/*
	 * 家計簿データ追加処理
	 */
	@PostMapping("/payments/new")
    public Payments createPayment(@RequestBody ToPayments toPayments) {
        Payments payment = new Payments();
        payment.setAmount(toPayments.getAmount());
        payment.setDate(toPayments.getDate());
        payment.setMemo(toPayments.getMemo());
        Category category = categoryRepository.findById(toPayments.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        payment.setCategory(category);
        return service.save(payment);
    }
	
	/*
	 * 来月目標設定処理
	 */
	@GetMapping("/nextTarget")
    public List<Payments> getNextTargetData() {
        return paymentsService.findAll();
    }
	
	/*
	 * ログイン関連
	 */
	@PostMapping("/users/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
    
    /*
     * カテゴリ追加処理
     */
    @PostMapping("/category/new")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
    
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
    	return categoryRepository.findAll();
    }
    
	
//	@GetMapping("/")
//	public String getIndex(Model model) {
//		return "index";
//	}
	
	@Autowired
	CalcService_sum calcService_sum;
	
	@Autowired
	CalcService calcService;
	
//	@Autowired
//    private PaymentsService paymentsService;
    
	@Autowired
	private PaymentsRepository paymentsRepository;
	

	private Payments.Kind kind = Payments.Kind.SPENDING;

	private int user = 0;

//	@GetMapping("/home")
//	@PostMapping("/payments/sort")
//	public String getPaymentsList(Model model, @RequestParam(value = "sort", required = false) String sort) {
//		List<Payments> pays;
//		if (sort != null) {
//			switch (sort) {
//			case "category":
//				pays = service.getKindSortedByCategory(kind, user);
//				break;
//			case "date":
//				pays = service.getKindSortedByDate(kind, user);
//				break;
//			case "amount":
//				pays = service.getKindSortedByAmount(kind, user);
//				break;
//			default:
//				pays = service.getAllByKind(kind, user);
//				break;
//			}
//		} else {
//			pays = service.getAllByKind(kind, user);
//		}
//		model.addAttribute("pays", pays);
//		return "index";
//	}

	@PostMapping("/button")
	public String handleButton(@RequestParam(name = "input", required = false, defaultValue = "") long input,
			Model model) {
		user = 1;//表示するユーザー設定　今はとりあえず１に変更するようにしてる　指定なしは＝０
		return "redirect:/home";
	}
	
	
	
	//目標金額設定
	@PostMapping("/setTargetAmount")
	public String setTargetAmount(@RequestParam(name = "input", required = false, defaultValue = "") int input,
			Model model) {
		service.setTargetAmount(input);
		return "redirect:/home";
	}
	

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("payments", paymentsService.findAll());
        System.out.println(calcService_sum.getTotalIncome());
        return "index";
    }

    @GetMapping("/payments/new")
    public String newExpense(Model model) {
        model.addAttribute("payments", new Payments());
        return "paymentsForm";
    }

//    @PostMapping("/payments")
//    public String saveExpense(@ModelAttribute Payments payments) {
//    	myService.save(payments);
//        return "redirect:/";
//    }
    
    @PostMapping("/payments")
    public String saveExpense(@ModelAttribute Payments payments) {
    	paymentsService.save(payments);
        return "redirect:/";
    }

    @GetMapping("/payments/edit/{paymentsId}")
    public String editExpense(@PathVariable("paymentsId") Long id, Model model) {
        model.addAttribute("payments", paymentsService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paymentsId:" + id)));
        return "paymentsForm";
    }

    @GetMapping("/payments/delete/{paymentsId}")
    public String deleteExpense(@PathVariable("paymentsId") Long id) {
    	paymentsService.deleteById(id);
        return "redirect:/";
    }
    
    
    @PostMapping("/payments/sort")
    public String sort(@RequestParam("sortType") String sortType, Model model) {
    	Payments payments = new Payments();
        List<Payments> sortedPayments = null;
        switch (sortType) {
            case "categoryId":
//            	sortedPayments = paymentsRepository.findByKind(payments.getKind());
            	sortedPayments = service.getKindSortedByCategory(payments.getKind(), payments.getUserId());
//            	model.addAttribute("payments", paymentsRepository.findByKind(payments.getKind()));
                break;
            case "date":
            	sortedPayments = service.getKindSortedByDate(payments.getDate(), payments.getUserId());
                break;
            case "amount":
            	sortedPayments = paymentsRepository.findByAmount(payments.getAmount());
                break;
            default:
                // デフォルトでは追加した順に表示する
            	sortedPayments = paymentsRepository.findAll();
                break;
        }
        model.addAttribute("payments", sortedPayments);
        return "index"; // ソート後のデータを表示するHTMLファイルの名前を指定
    }


    
}