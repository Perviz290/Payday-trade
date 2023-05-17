package com.neizu.paydaytrade.service;
import com.neizu.paydaytrade.dto.AccountDto;
import com.neizu.paydaytrade.dto.request.CreateAccountRequest;
import com.neizu.paydaytrade.dto.request.DepositAccountDto;
import com.neizu.paydaytrade.dto.request.UpdateAccountDto;
import com.neizu.paydaytrade.entity.Account;
import com.neizu.paydaytrade.entity.Bank;
import com.neizu.paydaytrade.entity.User;
import com.neizu.paydaytrade.exception.AccountNotFoundException;
import com.neizu.paydaytrade.exception.BankNotFoundException;
import com.neizu.paydaytrade.exception.UserNotFoundException;
import com.neizu.paydaytrade.repository.AccountRepo;
import com.neizu.paydaytrade.repository.BankRepo;
import com.neizu.paydaytrade.repository.UserRepo;
import com.neizu.paydaytrade.util.AccountConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;
    private final UserRepo userRepo;
    private final BankRepo bankRepo;
    private final AccountConverter accountConverter;


    public void createAccount(CreateAccountRequest createAccountRequest) {
       User user=userRepo.findById(createAccountRequest.getUserId())
               .orElseThrow(() -> new UserNotFoundException
                       (createAccountRequest.getUserId()+"-is userId NotFound"));
        Bank bank=bankRepo.findById(createAccountRequest.getBankId())
                .orElseThrow(() -> new BankNotFoundException(createAccountRequest.getBankId()+"-is bankId NotFound"));
        Account account=Account.builder()
                .fullName(createAccountRequest.getFullName())
                .mobileNumber(createAccountRequest.getMobileNumber())
                .passwordFinCode(createAccountRequest.getPasswordFinCode())
                .costumerBalance(BigDecimal.ZERO)
                .bank(bank)
                .user(user)
                .cardNumber(bank.getCardNumber() + String.format("%08d", (int) (Math.random() * 100000000)))
                .createDate(LocalDate.now())
              .build();
       accountRepo.save(account);
    }

    public List<AccountDto> getAllAccount() {
        return accountRepo.findAll().
                stream()
                .map(accountConverter::converterAccount).collect(Collectors.toList());
    }

    public AccountDto getAccountById(Integer id) {
        Account account=findById(id);
        return accountConverter.converterAccount(account);
    }

    public AccountDto updateAccount(Integer id, UpdateAccountDto updateDto) {
        Account account=findById(id);
        account.setMobileNumber(updateDto.getMobileNumber());
        return accountConverter.converterAccount(accountRepo.save(account));
    }

    public AccountDto loadMoneyAccount(Integer id, DepositAccountDto depositDto) {
        Account account=findById(id);
        account.setCostumerBalance(account.getCostumerBalance().add(depositDto.getBalance()));
        return accountConverter.converterAccount(accountRepo.save(account));
    }

    protected Account findById(Integer id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new AccountNotFoundException( (id + "-This Account is NotFound")));
    }






}
