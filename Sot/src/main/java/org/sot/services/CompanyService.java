/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sot.services;

import org.sot.enums.LifeStatus;
import org.sot.models.entities.Address;
import org.sot.models.entities.Company;
import org.sot.models.entities.Mrp;
import org.sot.models.entities.Place;
import org.sot.models.entities.Recipient;
import org.sot.models.entities.Street;
import org.sot.repositories.CompanyRepository;
import org.sot.repositories.PlaceRepository;
import org.sot.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jordan
 */
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final PlaceRepository placeRepository;
    private final StreetRepository streetRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, PlaceRepository placeRepository, StreetRepository streetRepository) {
        this.companyRepository = companyRepository;
        this.placeRepository = placeRepository;
        this.streetRepository = streetRepository;
    }

    // метод за тестване (за триене по-късно)
//    @Transactional
//    public Company saveCompany() {
//        String placeName = "петрич";
//        String streetName = "мусала";
//
//        Street street = (Street) streetRepository.findOneByName(streetName).get();
//        Place place = placeRepository.findOneByName(placeName);
////        Address address = new Address(street, "4", "Б", "5", "2");
////        if (place == null) {
////            System.out.println("Създаде новo населено място с име: " + placeName);
////            address.setPlace(new Place(placeName));
////        } else {
////            System.out.println("Попълни id:" + place.getId() + " и име: " + place.getName() + " на вече съществуващо населено място!");
////            address.setPlace(place);
////        }
////        if (street == null) {
////            System.out.println("Създаде нова улица с име: " + streetName);
////            address.setStreet(new Street(placeName, LifeStatus.EXISTING));
////        } else {
////            System.out.println("Попълни id:" + street.getId() + " и име: " + street.getName() + " на вече съществуваща улица!");
////            address.setStreet(street);
////        }
//
//        Company company = new Company();
//        company.setBulstat("123456789111111");
//        company.setMrp(new Mrp("киро", "dimitrov", "lazarov"));
//        company.setResipient(new Recipient("киро", "kirilov", "kirilov"));
//        company.setAddress(address);
//        Company saved = companyRepository.save(company);
//        Address savedAddress = saved.getAddress();
//        System.out.println("Запазено ново населено място с id: " + savedAddress.getPlace().getId() + " и име: " + savedAddress.getPlace().getName());
//        System.out.println("Запазено нов улица с id: " + savedAddress.getStreet().getId() + " и име: " + savedAddress.getStreet().getName());
//        return saved;
//    }
}
