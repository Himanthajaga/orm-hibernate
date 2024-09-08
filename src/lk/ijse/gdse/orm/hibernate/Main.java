package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embedded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1);
//        customer.setName("Pasan nimilaya");
        NameIdentifier name = new NameIdentifier();
        name.setFirstName("Pasan");
        name.setMiddleName("Nimilaya");
        name.setLastName("Pasan");
        customer.setNameIdentifier(name);
        customer.setAddress("Colombo");
        customer.setSalary(1000);
        customer.setAge(23);


        List<MobileNo>mobileNos = new ArrayList<>();

        MobileNo homeNo = new MobileNo();
        homeNo.setType("HOME");
        homeNo.setMobileNo("0913916121");


        MobileNo mobileNo = new MobileNo();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0771234567");

        mobileNos.add(homeNo);
        mobileNos.add(mobileNo);


        customer.setPhoneNos(mobileNos);

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();


//       // update existing customer
//        Session updateSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction updateTransaction = updateSession
//                .beginTransaction();
//        customer.setAddress("Matara");
//        customer.setSalary(20000);
//        customer.setName("Nimalaaa");
//
//        updateSession.update(customer);
//
//        updateTransaction.commit();
//        updateSession.close();

////        get existing customer
//        Session getCusSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Customer existingCustomer = getCusSession.get(Customer.class, 7);
//        System.out.println(existingCustomer);
//        getCusSession.close();
//
////        delete exiting customer in DB
//        Session deleteSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction deletecustomerTransaction = deleteSession.beginTransaction();
//       // Customer deleteCustomer = deleteSession.get(Customer.class, 4);
//        deleteSession.delete(existingCustomer);
//        deletecustomerTransaction.commit();
//        deleteSession.close();

    }

}