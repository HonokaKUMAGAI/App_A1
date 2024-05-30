package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.example.demo.Payments.Kind;

@Service
public class MyService {

	@Autowired
	PaymentsRepository paymentsRepository;

	//収支毎に
	public List<Payments> getAllByKind(Kind kind, long user) {
		List<Payments> list = null;
		if (user != 0)
			list = paymentsRepository.findAllByKindAndUserId(kind, user);
		else
			list = paymentsRepository.findAllByKind(kind);
		return list;
	}

//	//	収支毎にカテゴリでソート
//	public List<Payments> getKindSortedByCategory(Long categoryId, long user) {
//		List<Payments> Payments;
//		if (user != 0) {
//			Payments = paymentsRepository.findByCategoryIdAndUserId(categoryId, user);
//		} else {
//			Payments = paymentsRepository.findByCategoryId(categoryId);
//		}
//		System.out.println(Payments);
//		return Payments.stream()
//				.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
//				.collect(Collectors.toList());
//	}
	
	/*
	 * カテゴリでソート
	 */
	
	public List<Payments> getPaymentsSortedByCategory(Long userId) {
        List<Payments> payments;
        if (userId != null && userId != 0) {
            payments = paymentsRepository.findByUserIdOrderByCategoryId(userId);
            System.out.println(paymentsRepository.findByUserIdOrderByCategoryId(userId));
            System.out.println("カテゴリでソートされた支払いを取得するメソッド");
        } else {
            payments = paymentsRepository.findAllByOrderByCategoryId();
            System.out.println(paymentsRepository.findAllByOrderByCategoryId());
        }
        return payments;
    }
	
//	public List<Payments> SortedByCategory(Long categoryId, Long userId) {
//		System.out.println("カテゴリ分けメソッド突入！！");
//		List<Payments> Payments;
//		if (userId != 0) {
//			System.out.println("0パターン");
//			Payments = paymentsRepository.findByCategoryIdAndUserId(categoryId, userId);
//			System.out.println(paymentsRepository.findByCategoryIdAndUserId(categoryId, userId));
//			System.out.println(paymentsRepository.findAll());
//			System.out.println("分岐はこちら");
//		} else {
//			System.out.println("1~パターン");
//			Payments = paymentsRepository.findByCategoryId(categoryId);
//			
//		}
//		System.out.println(Payments);
//		return Payments.stream()
//				.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
//				.collect(Collectors.toList());

//    // カテゴリでソートされた支払いを取得するメソッド
//    public List<Payments> getPaymentsSortedByCategory(Long categoryId, Long userId) {
//        List<Payments> payments;
//        if (userId != null && userId != 0) {
//            payments = paymentsRepository.findByCategoryIdAndUserId(categoryId, userId);
//            System.out.println(paymentsRepository.findByCategoryIdAndUserId(categoryId, userId));
//            System.out.println("カテゴリでソートされた支払いを取得するメソッド");
//        } else {
//            payments = paymentsRepository.findByCategoryId(categoryId);
//            System.out.println(paymentsRepository.findByCategoryId(categoryId));
//        }
//        return payments.stream()
//                .sorted(Comparator.comparingLong(Payments::getCategoryId))
//                .collect(Collectors.toList());
//    }
    
    
//	//	収支毎に日付でソート
//	public List<Payments> getKindSortedByDate(LocalDate date, long user) {
//		List<Payments> Payments;
//		if (user != 0) {
//			Payments = paymentsRepository.findByDateAndUserId(date, user);
//		} else {
//			Payments = paymentsRepository.findByDate(date);
//		}
//		System.out.println(Payments);
//		return Payments.stream()
//				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
//				.collect(Collectors.toList());
//	}
	

	/*
	 * 日付でソート
	 */
	
	/*
	 * カテゴリでソート
	 */
	
	public List<Payments> getPaymentsSortedByDate(Long userId) {
        List<Payments> payments;
        if (userId != null && userId != 0) {
            payments = paymentsRepository.findByUserIdOrderByDate(userId);
            System.out.println(paymentsRepository.findByUserIdOrderByDate(userId));
            System.out.println("カテゴリでソートされた支払いを取得するメソッド");
        } else {
            payments = paymentsRepository.findAllByOrderByDate();
            System.out.println(paymentsRepository.findAllByOrderByDate());
        }
        return payments;
    }
	
//	public List<Payments> SortedByDate(LocalDate date, Long userId) {
//		List<Payments> Payments;
//		if (userId != 0) {
//			Payments = paymentsRepository.findByDateGreaterThanEqualAndUserId(date, userId);
//		} else {
//			Payments = paymentsRepository.findByDateGreaterThanEqual(date);
//		}
//		System.out.println(Payments);
//		return Payments.stream()
//				.sorted((t1, t2) -> t1.getDate().compareTo(t2.getDate()))
//				.collect(Collectors.toList());
//	}

//	//	収支毎に金額でソート
//	public List<Payments> getKindSortedByAmount(int amount, long user) {
//		List<Payments> Payments;
//		if (user != 0) {
//			Payments = paymentsRepository.findByAmountAndUserId(amount, user);
//		} else {
//			Payments = paymentsRepository.findByAmount(amount);
//		}
//		System.out.println(Payments);
//		return Payments.stream()
//				.sorted((t1, t2) -> Integer.compare(t1.getAmount(), t2.getAmount()))
//				.collect(Collectors.toList());
//	}
	
	/*
	 * 金額でソート
	 */
	public List<Payments> getPaymentsSortedByAmount(Long userId) {
        List<Payments> payments;
        if (userId != null && userId != 0) {
            payments = paymentsRepository.findByUserIdOrderByAmount(userId);
            System.out.println(paymentsRepository.findByUserIdOrderByAmount(userId));
            System.out.println("カテゴリでソートされた支払いを取得するメソッド");
        } else {
            payments = paymentsRepository.findAllByOrderByAmount();
            System.out.println(paymentsRepository.findAllByOrderByAmount());
        }
        return payments;
    }
	
//	public List<Payments> SortedByAmount(int amount, Long userId) {
//	    List<Payments> payments;
//	    if (userId != 0) {
//	        payments = paymentsRepository.findByAmountGreaterThanEqualAndUserId(amount, userId);
//	    } else {
//	        payments = paymentsRepository.findByAmountGreaterThanEqual(amount);
//	    }
//	    return payments.stream()
////	            .sorted(Comparator.comparingInt(Payments::getAmount))
//	    		.sorted((t1, t2) -> Long.compare(t1.getCategoryId(), t2.getCategoryId()))
//	            .collect(Collectors.toList());
//	}


//	収支編集
	public void editExpense(Payments pay) {
		paymentsRepository.save(pay);
	}
//  収支削除
	public void deleteExpenses(long id) {
		paymentsRepository.deleteById(id);
	}
//  収支追加
	public void addExpenses(Payments pay) {
		paymentsRepository.save(pay);
	}
	
	@Autowired
	CategoryRepository categoryRepository;
	
//	カテゴリ追加
	public void addCategory(Category ca) {
		categoryRepository.save(ca);
	}
//	カテゴリ編集
	public void editCategory(Category ca) {
		categoryRepository.save(ca);
	}
//	カテゴリ削除
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}
	
	public void setTargetAmount(int amount) {
		
		TargetSetting.setCategoryList();
		TargetSetting.setHouseholdList();
		TargetSetting.setTargetAmount(amount);
		
	}
	
}