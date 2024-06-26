package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Payment;
import com.example.demo.services.CategoryService;
import com.example.demo.services.PaymentService;


@Controller
public class AppController {

//	@GetMapping("/")
//	public String getIndex(Model model) {
//		return "index";
//	}

//	@Autowired
//	MyService service;
	
//	@Autowired
//	CalcService_sum calcService_sum;
	
//	@Autowired
//	CalcService calcService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
    private PaymentService paymentService;
    
//	@Autowired
//	private PaymentsRepository paymentsRepository;
	

//	private Payments.Kind kind = Payments.Kind.SPENDING;
//
//	private int user = 0;
//
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
//
//	@PostMapping("/button")
//	public String handleButton(@RequestParam(name = "input", required = false, defaultValue = "") long input,
//			Model model) {
//		user = 1;//表示するユーザー設定　今はとりあえず１に変更するようにしてる　指定なしは＝０
//		return "redirect:/home";
//	}
//	
//	
	
	//目標金額設定
//	@PostMapping("/setTargetAmount")
//	public String setTargetAmount(@RequestParam(name = "input", required = false, defaultValue = "") int input,
//			Model model) {
//		categoryService.setTargetAmount(input);
//		return "redirect:/home";
//	}
//	

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("payments", paymentService.findAll());
//        System.out.println(calcService_sum.getTotalIncome());
        return "index";
    }

//    @GetMapping("/payments/new")
//    public String newExpense(Model model) {
//        model.addAttribute("payments", new Payments());
//        return "paymentsForm";
//    }

//    @PostMapping("/payments")
//    public String saveExpense(@ModelAttribute Payments payments) {
//    	myService.save(payments);
//        return "redirect:/";
//    }
    
    @PostMapping("/payments")
    public String saveExpense(@ModelAttribute Payment payment) {
    	paymentService.save(payment);
        return "redirect:/";
    }

//    @GetMapping("/payments/edit/{paymentsId}")
//    public String editExpense(@PathVariable("paymentsId") Long id, Model model) {
//        model.addAttribute("payments", paymentsService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid paymentsId:" + id)));
//        return "paymentsForm";
//    }
//
//    @GetMapping("/payments/delete/{paymentsId}")
//    public String deleteExpense(@PathVariable("paymentsId") Long id) {
//    	paymentsService.deleteById(id);
//        return "redirect:/";
//    }
    
    
//    @PostMapping("/payments/sort")
//    public String sort(@RequestParam("sortType") String sortType, Model model) {
//    	Payments payments = new Payments();
//        List<Payments> sortedPayments = null;
//        switch (sortType) {
//            case "categoryId":
////            	sortedPayments = paymentsRepository.findByKind(payments.getKind());
//            	sortedPayments = service.getKindSortedByCategory(payments.getKind(), payments.getUserId());
////            	model.addAttribute("payments", paymentsRepository.findByKind(payments.getKind()));
//                break;
//            case "date":
//            	sortedPayments = service.getKindSortedByDate(payments.getDate(), payments.getUserId());
//                break;
//            case "amount":
//            	sortedPayments = paymentsRepository.findByAmount(payments.getAmount());
//                break;
//            default:
//                // デフォルトでは追加した順に表示する
//            	sortedPayments = paymentsRepository.findAll();
//                break;
//        }
//        model.addAttribute("payments", sortedPayments);
//        return "index"; // ソート後のデータを表示するHTMLファイルの名前を指定
//    }


    
}