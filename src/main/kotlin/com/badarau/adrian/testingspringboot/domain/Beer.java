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
package com.badarau.adrian.testingspringboot.domain;

import com.badarau.adrian.testingspringboot.web.model.BeerStyleEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by jt on 2019-01-26.
 */
@Entity
public class Beer extends BaseEntity {

    private String beerName;
    private BeerStyleEnum beerStyle;

    @Column(unique = true)
    private Long upc;

    /**
     * Min on hand qty - used to trigger brew
     */
    private Integer minOnHand;
    private Integer quantityToBrew;
    private BigDecimal price;

    @OneToMany(mappedBy = "beer")
    private Set<BeerInventory> beerInventory;


    public Beer() {
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public BeerStyleEnum getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(BeerStyleEnum beerStyle) {
        this.beerStyle = beerStyle;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    public Integer getMinOnHand() {
        return minOnHand;
    }

    public void setMinOnHand(Integer minOnHand) {
        this.minOnHand = minOnHand;
    }

    public Integer getQuantityToBrew() {
        return quantityToBrew;
    }

    public void setQuantityToBrew(Integer quantityToBrew) {
        this.quantityToBrew = quantityToBrew;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<BeerInventory> getBeerInventory() {
        return beerInventory;
    }

    public void setBeerInventory(Set<BeerInventory> beerInventory) {
        this.beerInventory = beerInventory;
    }
}
