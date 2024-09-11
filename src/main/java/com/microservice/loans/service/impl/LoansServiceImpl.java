package com.microservice.loans.service.impl;

import com.microservice.loans.constants.LoansConstants;
import com.microservice.loans.dto.LoansDto;
import com.microservice.loans.entity.Loans;
import com.microservice.loans.exception.LoansAlredyExistentException;
import com.microservice.loans.exception.ResourceNotFoundException;
import com.microservice.loans.mapper.LoansMapper;
import com.microservice.loans.repository.LoansRepository;
import com.microservice.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent())
        {
            throw new LoansAlredyExistentException("Loan already registed with given mobile number" + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    public Loans createNewLoan(String mobileNumber)
    {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);

        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);

        return newLoan;
    }
    @Override
    public LoansDto getLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber())
        );
        LoansMapper.mapToLoans(loansDto, new Loans());

        loansRepository.save(loans);

        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );

        loansRepository.deleteById(loans.getLoanId());

        return true;
    }
}
