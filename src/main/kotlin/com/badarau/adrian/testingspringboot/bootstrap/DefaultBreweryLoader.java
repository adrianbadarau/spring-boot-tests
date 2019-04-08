/*
 *  Copyright 2019 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.badarau.adrian.testingspringboot.bootstrap;

import com.badarau.adrian.testingspringboot.domain.*;
import com.badarau.adrian.testingspringboot.repositories.*;
import com.badarau.adrian.testingspringboot.repositories.BreweryRepository;
import com.badarau.adrian.testingspringboot.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by jt on 2019-01-26.
 */
@Component
public class DefaultBreweryLoader implements CommandLineRunner {

    private final BreweryRepository breweryRepository;
    private final BeerRepository beerRepository;
    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerOrderRepository beerOrderRepository;
    private final CustomerRepository customerRepository;

    public DefaultBreweryLoader(BreweryRepository breweryRepository,
                                BeerRepository beerRepository, BeerInventoryRepository beerInventoryRepository,
                                BeerOrderRepository beerOrderRepository, CustomerRepository customerRepository) {
        this.breweryRepository = breweryRepository;
        this.beerRepository = beerRepository;
        this.beerInventoryRepository = beerInventoryRepository;
        this.beerOrderRepository = beerOrderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBreweryData();
    }

    private void loadBreweryData() {
        if (breweryRepository.count() == 0) {
            Brewery brewery = new Brewery();
            brewery.setBreweryName("Cage Brewing");
            breweryRepository.save(brewery);

            Beer beer = new Beer();
            beer.setBeerName("Mango Bobs");
            beer.setBeerStyle(BeerStyleEnum.IPA);
            beer.setMinOnHand(12);
            beer.setQuantityToBrew(200);
            beer.setUpc(337010000001L);
            beerRepository.save(beer);

            BeerInventory beerInventory = new BeerInventory();
            beerInventory.setBeer(beer);
            beerInventory.setQuantityOnHand(100);
            beerInventoryRepository.save(beerInventory);

            Beer galaxyCat = new Beer();
            beer.setBeerName("Galaxy Cat");
            beer.setBeerStyle(BeerStyleEnum.PALE_ALE);
            beer.setMinOnHand(12);
            beer.setQuantityToBrew(200);
            beer.setUpc(337010000002L);
            beerRepository.save(galaxyCat);

            BeerInventory beerInventory2 = new BeerInventory();
            beerInventory.setBeer(galaxyCat);
            beerInventory.setQuantityOnHand(100);
            beerInventoryRepository.save(beerInventory2);

            beerInventoryRepository.save(beerInventory2);

            Beer pinball = new Beer();
            beer.setBeerName("Pinball Porter");
            beer.setBeerStyle(BeerStyleEnum.PORTER);
            beer.setMinOnHand(12);
            beer.setQuantityToBrew(200);
            beer.setUpc(337010000003L);
            beerRepository.save(pinball);

            BeerInventory beerInventory3 = new BeerInventory();
            beerInventory.setBeer(pinball);
            beerInventory.setQuantityOnHand(100);
            beerInventoryRepository.save(beerInventory3);

            Customer customer = new Customer();
            customer.setCustomerName("Test 1");
            customer.setApiKey(UUID.randomUUID());
            Customer testCustomer = customerRepository.save(customer);

            BeerOrderLine beerOrderLine1 = new BeerOrderLine();
            beerOrderLine1.setBeer(galaxyCat);
            beerOrderLine1.setOrderQuantity(15);
            beerOrderLine1.setQuantityAllocated(0);
            BeerOrderLine beerOrderLine2 = new BeerOrderLine();
            beerOrderLine2.setBeer(pinball);
            beerOrderLine2.setOrderQuantity(7);
            beerOrderLine2.setQuantityAllocated(0);
            Set<BeerOrderLine> orderLines1 = new HashSet<>();
            orderLines1.add(beerOrderLine1);
            orderLines1.add(beerOrderLine2);

            BeerOrder beerOrder = new BeerOrder();
            beerOrder.setOrderStatus(OrderStatusEnum.NEW);
            beerOrder.setCustomer(testCustomer);
            beerOrder.setCustomerRef("testOrder1");
            beerOrder.setOrderStatusCallbackUrl("http://example.com/post");
            beerOrder.setBeerOrderLines(orderLines1);

            orderLines1.forEach(line -> line.setBeerOrder(beerOrder));

            beerOrderRepository.save(beerOrder);
        }
    }
}
