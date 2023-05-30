package com.neizu.paydaytrade.service;



import com.neizu.paydaytrade.dto.UserStockDto;
import com.neizu.paydaytrade.dto.request.BuyUserStockRequest;
import com.neizu.paydaytrade.entity.Account;
import com.neizu.paydaytrade.entity.StockFinance;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.entity.UserStock;
import com.neizu.paydaytrade.exception.CheckCardNumberNotFoundException;
import com.neizu.paydaytrade.exception.EnoughMoneyException;
import com.neizu.paydaytrade.exception.FinanceStockNotFoundException;
import com.neizu.paydaytrade.exception.UserNotFoundException;
import com.neizu.paydaytrade.repository.AccountRepo;
import com.neizu.paydaytrade.repository.FinanceStockRepo;
import com.neizu.paydaytrade.repository.UserRepo;
import com.neizu.paydaytrade.repository.UserStockRepo;
import com.neizu.paydaytrade.util.UserStockConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserStockService {


   // private final UserRepo userRepo;
   // private final UserService userService;
   // private final FinanceApiService financeApiService;


    @Autowired
    private UserRepo userRepo;
    private FinanceStockRepo financeStockRepo;
    private UserStockRepo userStockRepo;
    private UserStockConverter userStockConverter;
    private AccountRepo accountRepo;



    public UserStockService(UserRepo userRepo,
                            FinanceStockRepo financeStockRepo,
                            UserStockRepo userStockRepo,
                            UserStockConverter userStockConverter,
                            AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.financeStockRepo=financeStockRepo;
        this.userStockRepo=userStockRepo;
        this.userStockConverter=userStockConverter;
        this.accountRepo=accountRepo;
    }


    public List<UserStockDto> getAllUserStock() {
        return userStockRepo.findAll()
                .stream()
                .map(userStockConverter :: converter )
                .collect(Collectors.toList());
    }


    public UserStockDto findUserStockByUserId(Integer id) {
       Optional<User> user=userRepo.findById(id);
       if (user.isPresent()){
           return userStockConverter.converter(userStockRepo.findUserStockByUserId(id));
       }
        throw new UserNotFoundException
                (id+"-is userId NotFound");
    }


    public void buyStockTargetPrice(BuyUserStockRequest buyUserStockRequest) {
        Optional<User> user1=userRepo.findById(buyUserStockRequest.getUserId());
        if (user1.isPresent()){
            user1.get();
        }else {
            throw new UserNotFoundException
                    (buyUserStockRequest.getUserId()+"-is userId NotFound");
        }
       Optional<StockFinance> finance1= financeStockRepo.findStockFinanceByName(buyUserStockRequest.getStockName());
        if (finance1.isPresent()){
            finance1.get();
        }else {
           throw new FinanceStockNotFoundException
                    (buyUserStockRequest.getStockName() +"-is NotFound");
        }
        Account cardNumber= checkCard(user1.get(),buyUserStockRequest.getCardNumber());
        if (finance1.get().getPrice().compareTo(buyUserStockRequest.getTargetPrice())>0){
            throw new RuntimeException("target yetersiz");
        }
        else {
          Account account=compare(finance1.get(),cardNumber);
          accountRepo.save(account);
           UserStock userStock=new UserStock(finance1.get().getName(), finance1.get().getPrice(),user1.get());
           userStockRepo.save(userStock);
        }
    }



    private  Account compare(StockFinance finance, Account account){
        if (finance.getPrice().compareTo(account.getCostumerBalance())>0){
            throw new EnoughMoneyException("Yetersiz card pulu");
        }else {
            account.setCostumerBalance(account.getCostumerBalance().subtract(finance.getPrice()));
            return account;
        }
    }

    private Account checkCard(User user, String cardNumber) {
        Optional<Account> matchingAccount = user.getAccounts().stream()
                .filter(account -> account.getCardNumber().equals(cardNumber))
                .findFirst();

        if (matchingAccount.isPresent()) {
            return matchingAccount.get();
        } else {
            throw new CheckCardNumberNotFoundException(cardNumber + "-Cartiniz duzgun deyil:::");
        }
    }







}
